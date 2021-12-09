package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class CadastroProduto extends Cadastro {
	private List<Produto> produtos;
	private Entrada entrada;
	
	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		
		System.out.println("\nCADASTRO DE PRODUTO E SERVIÇOS");
		String tipo = "";
		String categoria = "";
		
		boolean exec = true;
		while (exec) {
			System.out.print("\n1 - Produtos\n2 - Serviços\n");
			
			Entrada entradaTipo = new Entrada();
			System.out.print("\nEscolha uma opção: ");
			String operacao = entradaTipo.receberTexto();
			switch (operacao) {
				case "1":
					tipo = "Produto";
					exec = false;
					break;
				case "2":
					tipo = "Serviço";
					exec = false;
					break;
				default:
					System.out.println("\nOpção Inválida :(");
			}
		}

		Double preco = 0.0;
		String codigo = "0";
		System.out.print("\nNome: ");
		String nome = entrada.receberTexto();
		boolean execPreco = true;
		while (execPreco) {
			try {
				Entrada entradaPreco = new Entrada();
				System.out.print("Preço: R$ ");
				String p = entradaPreco.receberTexto();
				preco = Double.parseDouble(p);
				System.out.print("Código: ");
				Entrada entradaCod = new Entrada();
				codigo = entradaCod.receberTexto();
				execPreco = false;
			} catch (Exception e) {
				
				System.out.println("\nPreço Inválido!\nUtilize 'Ponto .' para separar as casas decimais");
			}
		}

		boolean execCategoria = true;
		while (execCategoria) {
			System.out.print("n1 - Feminino\n2 - Masculino\n3 - Todos");
			Entrada entradaCategoria = new Entrada();
			System.out.print("\nEscolha uma opção: ");
			String c = entradaCategoria.receberTexto();
			switch (c) {
				case "1":
					categoria = "Feminino";
					execCategoria = false;
					break;
				case "2":
					categoria = "Masculino";
					execCategoria = false;
					break;
				case "3":
					categoria = "Todos";
					execCategoria = false;
					break;
				default:
					System.out.println("\nOpção Inválida");
			}
		}
		
		Produto produto = new Produto(nome, preco, categoria, codigo, tipo);
		this.produtos.add(produto);
		ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(produto);
		impressaoProd.imprimir();
		System.out.println("\nSeu Produto/Serviço foi cadastrado com sucesso!");
	
	}

}

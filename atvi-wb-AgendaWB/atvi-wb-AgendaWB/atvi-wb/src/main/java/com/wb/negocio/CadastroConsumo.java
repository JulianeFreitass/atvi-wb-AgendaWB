package com.wb.negocio;

import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;

public class CadastroConsumo extends Cadastro {

	private List<Consumo> consumos = new ArrayList<Consumo>();
	private List<Cliente> clientes;
	private List<Produto> produtosConsumidos = new ArrayList<Produto>();
	private List<Produto> todosProdutos;
	private Entrada entrada;

	public CadastroConsumo(List<Consumo> consumos, List<Cliente> clientes, List<Produto> todosProdutos) {
		this.consumos = consumos;
		this.clientes = clientes;
		this.todosProdutos = todosProdutos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		Double valorTotal = 0.0;
		String cpf = null;
		Cliente cliente = null;

		System.out.println("\nCONSUMO");
		
		boolean execucao = true;
		while(execucao) {
			System.out.print("\nCliente já cadastrado?\n\n1 - Sim\n2 - Não\n");
			System.out.print("\nEscolha uma Opção: ");
			int operacao = entrada.receberNumeroInteiro();
			switch(operacao) {
				case 1:
					System.out.print("\nInforme o CPF do cliente: ");
					entrada = new Entrada();
					cpf = entrada.receberTexto();
					execucao = false;
					break;
				case 2:
					Cadastro cadastroCliente = new CadastroCliente(clientes);
					cadastroCliente.cadastrar();
					cliente = clientes.get(clientes.size() - 1);
					cpf = cliente.getCpf().getValor();
					execucao = false;
					break;
				default:
					System.out.println("\nOpção Inválida\n");
			}
		}

		if (cpf != "") {
			for (Cliente c : clientes) {
				if (cpf.equals(c.getCpf().getValor())) {
					cliente = c;
					ImpressaoCLI impressaoCliente = new ImpressaoCLICliente(cliente);
					impressaoCliente.imprimir();
					break;
				}
			}
		} if (cliente == null) {
			System.out.println("\nNão encontramos nenhum cliente com esse CPF");
			return;
		}

		
		System.out.println("\nREGISTRO DE CONSUMO");
		boolean exec = true;
		while (exec) {
			Entrada entradaCod = new Entrada();
			System.out.print("\nCódigo do produto: ");
			String codigoProd = entradaCod.receberTexto();
			boolean flag = true;
			for (Produto prod : todosProdutos) {
				if (codigoProd.equals(prod.codigo)) {
					this.produtosConsumidos.add(prod);
					flag = false;
					ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(prod);
					impressaoProd.imprimir();
					System.out.println("\n"+ prod.getTipo() + " adicionado ao consumo!");
					boolean execAddProd = true;
					while (execAddProd) {
						System.out.print("\nAdicionar outro produto/serviço?\n\n1 - Sim\n2 - Não\n");
						System.out.print("\nEscolha uma opção: ");
						Entrada entradaCont = new Entrada();
						String oper = entradaCont.receberTexto();
						switch (oper) {
							case "1":
								execAddProd = false;
								break;
							case "2":
								execAddProd = false;
								exec = false;
								break;
							default:
								System.out.println("\nOpção Inválida :(");
						}
					}
					break;
				}
			}
			if (flag) {
				System.out.println("\nNão foi encontrado nenhum produto");
				System.out.print("\nTentar novamente?\n\n1 - Sim\n2 - Não\n");
				System.out.print("\nEscolha uma Opção: ");
				Entrada entradaAcao = new Entrada();
				int op = entradaAcao.receberNumeroInteiro();
				switch (op) {
					case 1:
						break;
					case 2:
						exec = false;
						break;
					default:
						System.out.println("\nOpção Inválida :(\n");
				}
			}
		}

		
		for (Produto produtoConsumido : produtosConsumidos) {
			valorTotal +=  produtoConsumido.getPreco();
		}
		
		Consumo novoConsumo = new Consumo(produtosConsumidos, valorTotal, cliente);
		cliente.getListaConsumo().add(novoConsumo);
		cliente.setConsumoTotal();
		this.consumos.add(novoConsumo);

		System.out.println("\nConsumo cadastrado!");
		System.out.print("\nCliente: " + cliente.nome);
		System.out.print("\nCPF: " + cliente.getCpf().getValor());
		System.out.println("\nValor total: R$ " + valorTotal);

		for(Produto prod : novoConsumo.getProdutosConsumidos()) {
			System.out.print("\n" + prod.getTipo() + ": " + prod.getNome());
			System.out.println("\nR$ " + prod.getPreco());
		}
		
	}
}
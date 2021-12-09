package com.wb.negocio;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class EdicaoProduto extends Edicao {
    private Produto produto;

    public EdicaoProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public void editar() {
        
        System.out.println("\nEDITAR PRODUTO/SERVIÇO");
        boolean execucao = true;
        while (execucao) {        
            System.out.println("1 - Tipo");
            System.out.println("2 - Categoria");
			System.out.println("3 - Nome");
			System.out.println("4 - PreÃ§o");
			System.out.println("5 - CÃ³digo");
            System.out.println("6 - Sair");
            System.out.print("\nEscolha uma opção: ");

			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
            switch (operacao) {
                case "1":
                    String tipo = "";
                    boolean exec = true;
                    while (exec) {                   
                        System.out.print("\n1 - Produto\n2 - Serviço\n");
                        System.out.print("\nEscolha uma opção: ");
                        String operacaoGenero = entrada.receberTexto();
                        switch (operacaoGenero) {
                            case "1":
                                tipo = "Produto";
                                exec = false;
                                break;
                            case "2":
                                tipo = "Serviço";
                                exec = false;
                                break;
                            default:
                                System.out.println("\nOpção Inválida :(\n");
                        }
                    }
                    produto.setTipo(tipo);
                    System.out.println("\nAlteração realizada com sucesso!");
                    break;
                case "2":
                    String categoria = "";
                    boolean execCategoria = true;
                    while (execCategoria) {                   
                        System.out.print("\n1 - Masculino\n2 - Feminino\n3 - Todos\n");
                        System.out.print("\nOpção Inválida: ");
                        
                        String operacaoGenero = entrada.receberTexto();
                        switch (operacaoGenero) {
                            case "1":
                                categoria = "Masculino";
                                execCategoria = false;
                                break;
                            case "2":
                                categoria = "Feminino";
                                execCategoria = false;
                                break;
                            case "3":
                                categoria = "Todos";
                                execCategoria = false;
                                break;
                            default:
                                System.out.println("\nOpção Inválida"); }
                    }
                    produto.setCategoria(categoria);
                    System.out.println("\nAlteração realizada com sucesso!");
                    break;
                case "3":
                    Entrada entradaNome = new Entrada();
                    System.out.print("\nNovo nome: ");
                    String nome = entradaNome.receberTexto();
                    produto.nome = nome;
                    System.out.println("\nAlteração realizada com sucesso!");
                    break;
                case "4":
                    boolean execPreco = true;
                    while (execPreco) {
                        try {
                            Entrada entradaPreco = new Entrada();
                            System.out.print("\nNovo preço: R$ ");
                            String p = entradaPreco.receberTexto();
                            Double preco = Double.parseDouble(p);
                            produto.preco = preco;
                            System.out.println("\nAlteração realizada com sucesso!");
                            execPreco = false;
                        } catch (Exception e) {
                        	System.out.println("\nPreço Inválido!\nUtilize 'Ponto .' para separar as casas decimais");
                        }
                    }
                    break;
                case "5":
                    Entrada entradaCod = new Entrada();
                    System.out.print("\nNovo código: ");
                    String codigo = entradaCod.receberTexto();
                    produto.codigo = codigo;
                    System.out.println("\nAlteração realizada com sucesso!");
                    break;
                case "6":
                    execucao = false;
                    break;
                default:
                    System.out.println("\nOpção inválida :(");
            }
        }
    }
    
}

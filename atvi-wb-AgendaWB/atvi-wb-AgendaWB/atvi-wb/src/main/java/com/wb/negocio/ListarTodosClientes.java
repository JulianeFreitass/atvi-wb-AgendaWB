package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;
	private ImpressaoCLI impressao;

	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		
		System.out.println("\nLISTA DE CLIENTES:");

		boolean exec = true;
		String genero = "T";
		while (exec) {
			System.out.println("\nLISTA POR GÊNERO:");
			Entrada entrada = new Entrada();
			System.out.println("\n1 - Masculino");
			System.out.println("2 - Feminino");
			System.out.println("3 - Todos");
			System.out.println("\nLISTA POR CONSUMO:");
			System.out.println("\n4 - 5 MAIS em valor de consumo");
			System.out.println("5 - 10 MAIS em quantidade de produtos");
			System.out.println("6 - 10 MENOS em quantidade de produtos");
			System.out.println("\n7 - Cancelar");
			System.out.print("\nEscolha uma opção: ");
			String operacao = entrada.receberTexto();
			switch (operacao) {
				case "1":
					genero = "Masculino";
					exec = false;
					break;
				case "2":
					genero = "Feminino";
					exec = false;
					break;
				case "3":
					genero = "Outro";
					exec = false;
					break;
				case "4":
					System.out.println("\n5 Clientes que MAIS consumiram em valor");
					Listagem listar5MaisClientes = new Listar5MaisClientes(clientes);
					listar5MaisClientes.listar();
					exec = false;
					break;
				case "5":
					System.out.println("\n10 Clientes que MAIS consumiram em quantidade");
					Listagem listar10Mais = new Listar10MaisEmProduto(clientes);
					listar10Mais.listar();
					exec = false;
					break;
				case "6":
					System.out.println("\n10 Clientes que MENOS consumiram em quantidade");
					Listagem listar10Menos = new Listar10MenosEmProduto(clientes);
					listar10Menos.listar();
					exec = false;
					break;
				case "7":
					exec = false;
					break;
				default:
					System.out.println("\nOpção Inválida");
			}
		}

		if (genero != "T") {
			if (genero == "Outro") {
				System.out.println("\nCLIENTES:");
				for (Cliente cliente : clientes) {
					this.impressao = new ImpressaoCLICliente(cliente);
					impressao.imprimir();
				}
			} else {
				System.out.println("\nCLIENTES:");
				for (Cliente cliente : clientes) {
					if (cliente.getGenero().equalsIgnoreCase(genero)) {
						this.impressao = new ImpressaoCLICliente(cliente);
						impressao.imprimir();
					}
				}
			}
		}
		
	}
}

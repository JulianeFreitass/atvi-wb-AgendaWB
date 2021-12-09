package com.wb;



import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;
import com.wb.negocio.Busca;
import com.wb.negocio.BuscaCliente;
import com.wb.negocio.BuscaProduto;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroConsumo;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarConsumo;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosProdutos;

public class App {
	public static void main(String[] args) {
				
		Empresa empresa = new Empresa();
		boolean execucao = true;


		while (execucao) {
			System.out.println("\nBem vindo ao Grupo World Beauty (WB)!\n");
			
			System.out.println("\nOperações\n");
			System.out.println("1 - Clientes");
			System.out.println("2 - Produtos e Serviços");
			System.out.println("3 - Consumos");
			System.out.println("4 - Sair");
			System.out.print("\nEscolha uma opção: ");

			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
			
			switch (operacao) {
				case "1":
					boolean execCliente = true;
					while (execCliente) {
						System.out.println("\nCLIENTES\n");
						System.out.println("1 - Cadastrar cliente");
						System.out.println("2 - Listar clientes");
						System.out.println("3 - Buscar cliente");
						System.out.println("4 - Cancelar");
						System.out.print("\nEscolha uma opção: ");

						Entrada entradaCliente = new Entrada();
						String opCliente = entradaCliente.receberTexto();
						switch (opCliente) {
							case "1":
								Cadastro cadastro = new CadastroCliente(empresa.getClientes());
								cadastro.cadastrar();
								execCliente = false;
								break;
							case "2":
								Listagem listagem = new ListarTodosClientes(empresa.getClientes());
								listagem.listar();
								execCliente = false;
								break;
							case "3":
								Busca busca = new BuscaCliente(empresa.getClientes());
								busca.buscar();
								execCliente = false;
								break;
							case "4":
								execCliente = false;
								break;
							default:
								System.out.println("\nOpção Inválida :(");
						}
					}
					break;
				case "2":
					boolean execProds = true;
					while (execProds) {
						System.out.println("\nPRODUTOS E SERVIÇOS\n");
						System.out.println("1 - Cadastrar Produto ou Serviço");
						System.out.println("2 - Listar Produtos ou Serviço");
						System.out.println("3 - Buscar Produto ou Serviço");
						System.out.println("4 - Voltar");
						System.out.print("\nEscolha uma opção: ");

						Entrada entradaProd = new Entrada();
						String opProd = entradaProd.receberTexto();
						switch (opProd) {
							case "1":
								Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
								cadastroProduto.cadastrar();
								execProds = false;
								break;
							case "2":
								Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos(), empresa.getConsumos());
								listagemProdutos.listar();
								execProds = false;
								break;
							case "3":
								Busca buscaProduto = new BuscaProduto(empresa.getProdutos());
								buscaProduto.buscar();
								execProds = false;
								break;
							case "4":
								execProds = false;
								break;
							default:
								System.out.println("\nOpção Inválida :(");
						}
					}
					break;
				case "3":
					boolean execConsumo = true;
					while (execConsumo) {
						System.out.println("\n CONSUMO\n");
						System.out.println("1 - Registrar consumo");
						System.out.println("2 - Listar consumo");
						System.out.println("3 - Voltar");
						System.out.print("\nEscolha uma opção: ");
						Entrada entradaConsumo = new Entrada();
						String operacaoConsumo = entradaConsumo.receberTexto();
						switch (operacaoConsumo) {
							case "1":
								Cadastro cadastroConsumo = new CadastroConsumo(empresa.getConsumos(), empresa.getClientes(), empresa.getProdutos());
								cadastroConsumo.cadastrar();
								execConsumo = false;
								break;
							case "2":
								Listagem listarConsumo = new ListarConsumo(empresa.getConsumos());
								listarConsumo.listar();
								execConsumo = false;
								break;
							case "3":
								execConsumo = false;
								break;
							default:
								System.out.println("\nOpção Inválida :(");
						}
					}
					break;
				case "4":
					execucao = false;
					System.out.println("\nFinalizando...\n");
					break;
				default:
					System.out.println("\nOperação Inválida");
			}
		}
	}
}
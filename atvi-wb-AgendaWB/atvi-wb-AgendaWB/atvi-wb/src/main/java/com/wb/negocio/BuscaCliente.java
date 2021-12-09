package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class BuscaCliente extends Busca {
    
    private List<Cliente> clientes;
	private ImpressaoCLI impressao;

    public BuscaCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void buscar() {
        
        System.out.println("\nBUSCAR CLIENTE");
        System.out.print("\nInsira o CPF: ");
        Cliente c = null;
        Entrada entrada = new Entrada();
        String cpf = entrada.receberTexto();

        for (Cliente cli : clientes) {
            if (cli.getCpf().getValor().equals(cpf)) {
                c = cli;
                impressao = new ImpressaoCLICliente(c);
                impressao.imprimir();
                boolean exec = true;
                while (exec) {
                    System.out.println("\nOPERAÇÕES");
                    System.out.println("\n1 - Editar cliente");
                    System.out.println("2 - Deletar cliente");
                    System.out.println("3 - Cancelar");
                    System.out.print("\nEscolha uma opção: ");
                    Entrada novaEntrada = new Entrada();                
                    String operacao = novaEntrada.receberTexto();
                    switch (operacao) {
                        case "1":
                            Edicao edicaoCliente = new EdicaoCliente(cli);
                            edicaoCliente.editar();
                            exec = false;
                            break;
                        case "2":
                            clientes.remove(cli);
                            System.out.println("\nCliente removido com sucesso!");
                            exec = false;
                            break;
                        case "3":
                            exec = false;
                            break;
                        default:
                            System.out.println("\nOpção inválida:(");
                    }
                }
                
                break;
            }
        }

        if (c == null) System.out.println("\nNão encontramos nenhum cliente com esse CPF");
        
    }
    
}

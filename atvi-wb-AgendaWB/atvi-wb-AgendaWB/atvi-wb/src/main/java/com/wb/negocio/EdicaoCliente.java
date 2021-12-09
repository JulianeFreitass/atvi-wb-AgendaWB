package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class EdicaoCliente extends Edicao{
    private Cliente cliente;

    public EdicaoCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void editar() {
        System.out.println("\nEDITAR CLIENTE");
        boolean execucao = true;
        while (execucao) {
			System.out.println("1 - Nome");
			System.out.println("2 - Nome Social");
            System.out.println("3 - Gênero");
            System.out.println("4 - CPF");
            System.out.println("5 - RG");
            System.out.println("6 - Telefone");
            System.out.println("7 - Sair");
            System.out.print("\nEscolha uma opção: ");

			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
            switch (operacao) {
                case "1":
                    Entrada entradaNome = new Entrada();
                    System.out.print("\nNovo nome: ");
                    String nome = entradaNome.receberTexto();
                    cliente.nome = nome;
                    System.out.println("\nAlteração concluida com sucesso!");
                    break;
                case "2":
                    Entrada entradaNomeSocial = new Entrada();
                    System.out.print("\nNovo nome social: ");
                    String nomeSocial = entradaNomeSocial.receberTexto();
                    cliente.nomeSocial = nomeSocial;
                    System.out.println("\nAlteração concluida com sucesso!");
                    break;
                case "3":
                    String g = "";
                    boolean exec = true;
                    while (exec) {
                        System.out.println("\nGÊNERO");
                        System.out.print("\n1- Masculino\n2 - Feminino\n3 - Outro\n");
                        System.out.print("\nEscolha uma Opção: ");
                        String operacaoGenero = entrada.receberTexto();
                        switch (operacaoGenero) {
                            case "1":
                                g = "M";
                                exec = false;
                                break;
                            case "2":
                                g = "F";
                                exec = false;
                                break;
                            case "3":
                                g = "T";
                                exec = false;
                                break;
                            default:
                                break;
                        }
                    }
                    cliente.setGenero(g);
                    System.out.println("\nAlteração concluida com sucesso!");
                    break;
                case "4":
                    entrada = new Entrada();
                    System.out.print("\nNumero do CPF: ");
                    String valor = entrada.receberTexto();
                    System.out.print("Data de Emissao do CPF [dd/mm/yyyy]: ");
                    String data = entrada.receberTexto();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataEmissao = LocalDate.parse(data, formato);
                    CPF cpf = new CPF(dataEmissao, valor);
                    cliente.setCpf(cpf);
                    System.out.println("\nAlteração concluida com sucesso!");
                    break;
                case "5":
                    boolean execEdicaoRg = true;
                    while (execEdicaoRg) {
                        System.out.println("\nRG\n");
                        System.out.println("1 - Editar RG");
                        System.out.println("2 - Adicionar RG");
                        System.out.println("3 - Apagar RG");
                        System.out.println("4 - Voltar");
                        System.out.print("\nEscolha uma opção: ");
                        Entrada entradaEdicaoRg = new Entrada();
                        String operacaoRg = entradaEdicaoRg.receberTexto(); 
                        switch (operacaoRg) {
                            case "1":
                                Edicao edicaoRg = new EdicaoRg(cliente.getRgs());
                                edicaoRg.editar();
                                break;
                            case "2":
                                Cadastro cadastroRg = new CadastroRg(cliente.getRgs());
                                cadastroRg.cadastrar();
                                break;
                            case "3":
                                int i = 0;
                                
                                for (RG rg : cliente.getRgs()) {
                                    System.out.println("”¸ [" + Integer.sum(i,1) + "] " + rg.getValor());
                                    ++i;
                                }
                                System.out.print("\nQual RG deseja deletar? ");
                                Entrada entradaDelRg = new Entrada();

                                boolean flag = true;
                                while (flag) {
                                    String operacaoDelRg = entradaDelRg.receberTexto();
                                    if (operacaoDelRg != null && operacaoDelRg.matches("[0-9.]+")) {
                                        int op = Integer.parseInt(operacaoDelRg);
                                        if (op > cliente.getRgs().size() || op == 0) {
                                            System.out.println("\nRG incorreto");
                                            System.out.print("\nQual RG deseja deletar? ");
                                        } else {
                                            cliente.getRgs().remove(op-1);
                                            System.out.println("\nRG excluido com sucesso!");
                                            flag = false;
                                        }
                                    } else {
                                        System.out.println("\nRG Inválido :(");
                                        System.out.print("\nQual RG deseja deletar?");
                                    }
                                }
                                break;
                            case "4":
                                execEdicaoRg = false;
                                break;
                            default:
                                System.out.println("\nOpção Inválida :(");
                        }
                    }
                    break;
                case "6":
                    boolean execEdicaoTel = true;
                    while (execEdicaoTel) {
                        System.out.println("\nTELEFONE\n");
                        System.out.println("1 - Editar telefone");
                        System.out.println("2 - Adicionar telefone");
                        System.out.println("3 - Apagar telefone");
                        System.out.println("4 - Voltar");
                        System.out.print("\nEscolha uma Opção: ");
                        Entrada entradaEdicaoTel = new Entrada();
                        String operacaoTel = entradaEdicaoTel.receberTexto(); 
                        switch (operacaoTel) {
                            case "1":
                                Edicao edicaoTel = new EdicaoTelefone(cliente.getTelefones());
                                edicaoTel.editar();
                                break;
                            case "2":
                                Cadastro cadastroTel = new CadastroTelefone(cliente.getTelefones());
                                cadastroTel.cadastrar();
                                System.out.println("\nAlteração realizada com sucesso");
                                break;
                            case "3":
                                int i = 0;
                                
                                for (Telefone telefone : cliente.getTelefones()) {
                                    System.out.println("[" + Integer.sum(i,1) + "] " + "(" + telefone.getDdd() + ") " + telefone.getNumero());
                                    ++i;
                                }
                                System.out.print("\nQual telefone deseja excluir? ");
                                Entrada entradaDelTel = new Entrada();

                                boolean flagTel = true;
                                while (flagTel) {
                                    String operacaoDelTel = entradaDelTel.receberTexto();
                                    if (operacaoDelTel != null && operacaoDelTel.matches("[0-9.]+")) {
                                        int op = Integer.parseInt(operacaoDelTel);
                                        if (op > cliente.getTelefones().size() || op == 0) {
                                            System.out.println("\nTelefone Inválido");
                                            System.out.print("\nQual telefone deseja deletar? ");
                                        } else {
                                            cliente.getTelefones().remove(op-1);
                                            System.out.println("\nTelefone deletado com sucesso!");
                                            flagTel = false;
                                        }
                                    } else {
                                        System.out.println("\nTelefone incorreto! Tente novamente.");
                                        System.out.print("\nQual telefone deseja deletar? ");
                                    }
                                }
                                break;
                            case "4":
                                execEdicaoTel = false;
                                break;
                            default:
                                System.out.println("\nOpção Inválida :(");
                        }
                    }
                    break;
                case "7":
                    execucao = false;
                    break;
                default:
                    System.out.println("\nOpção Inválida :(");
            }
        }
    }
    
}

package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private List<Telefone> telefones;
	private List<RG> rgs;
	private CPF cpf;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\nCADASTRO DE CLIENTE");
		
		System.out.print("\nNome: ");
		String nome = entrada.receberTexto();
		System.out.print("\nNome Social: ");
		String nomeSocial = entrada.receberTexto();
		String g = "";

		boolean exec = true;
		while (exec) {
			System.out.println("\nGENÊRO ");
			System.out.print("\n1 - Masculino\n2 - Feminino\n3 - Outro\n");
			System.out.print("\nEscolha uma opção: ");
			String operacao = entrada.receberTexto();
			
			switch (operacao) {
				case "1":
					g = "Masculino";
					exec = false;
					break;
				case "2":
					g = "Feminino";
					exec = false;
					break;
				case "3":
					g = "Outro";
					exec = false;
					break;
				default:
					System.out.println("\nOpção Inválida :(");
					break;
			}
		}
		String genero = g;

		Cliente cliente = new Cliente(nome, nomeSocial, genero, cpf, telefones, rgs);

		Cadastro cadastroCpf = new CadastroCpf(cliente);
		cadastroCpf.cadastrar();

		Cadastro cadastroRg = new CadastroRg(cliente.getRgs());
		cadastroRg.cadastrar();
		
		Cadastro cadastroTelefone = new CadastroTelefone(cliente.getTelefones());
		cadastroTelefone.cadastrar();
		
		int flag = 1;
		while(flag == 1) {
			System.out.print("\nCadastrar outro telefone?\n\n1 - Sim\n2 - Não\n");
			System.out.print("\nEscolha uma opção: ");
			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
			switch(operacao) {
				case "2":
					flag = 0;
					break;
				case "1":
					cadastroTelefone.cadastrar();
					break;
				default:
					System.out.println("\nOpção Inválida\n");
					break;
			}
		}
		
		this.clientes.add(cliente);
		System.out.println("\nCliente cadastrado com sucesso");
	}
}
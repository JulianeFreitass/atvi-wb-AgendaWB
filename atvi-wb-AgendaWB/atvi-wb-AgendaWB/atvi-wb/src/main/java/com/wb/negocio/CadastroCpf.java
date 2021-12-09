package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;

public class CadastroCpf extends Cadastro {
    private Cliente cliente;
	private Entrada entrada;

    public CadastroCpf(Cliente cliente) {
        this.cliente = cliente;
        this.entrada = new Entrada();
    }

    @Override
    public void cadastrar() {
        System.out.println("\nCADASTRO DE CPF");
        System.out.print("\nNúmero do CPF: ");
		String valorRg = entrada.receberTexto();
		
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Data de Emissao do CPF [dd/mm/yyyy]: ");
		        String dataRg = entrada.receberTexto();
		        DateTimeFormatter formatoRg = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataEmissaoRg = LocalDate.parse(dataRg, formatoRg);
                CPF cpf = new CPF(dataEmissaoRg, valorRg);
		        this.cliente.setCpf(cpf);
		        System.out.println("\nCPF cadastrado com sucesso!");
                isValid = true;
            }
            catch(Exception e) {
                System.out.println("\nData de emissao do CPF com formato inválido");
                System.out.println("\nPadrão de data válida: 00/00/0000\n");
            }
        }
    }
    
}

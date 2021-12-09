package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.RG;

public class CadastroRg extends Cadastro {
    private List<RG> rgs;
	private Entrada entrada;

    public CadastroRg(List<RG> rgs) {
        this.rgs = rgs;
        this.entrada = new Entrada();
    }

    @Override
    public void cadastrar() {
        System.out.println("\nCADASTRO DE RG");
        System.out.print("\nRG: ");
		String valorRg = entrada.receberTexto();

        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Data de Emissao do RG [dd/mm/yyyy]: ");
                String dataRg = entrada.receberTexto();
                DateTimeFormatter formatoRg = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataEmissaoRg = LocalDate.parse(dataRg, formatoRg);
                RG rg = new RG(dataEmissaoRg, valorRg);
                this.rgs.add(rg);
                System.out.println("\nSeu RG foi cadastrado com sucesso!");
                isValid = true;
            }
            catch(Exception e) {
                System.out.println("\nData de emissao do RG com formato inválido");
                System.out.println("\nPadrão de data válida: 00/00/0000\n");
            }
        }
        
    }
    
}

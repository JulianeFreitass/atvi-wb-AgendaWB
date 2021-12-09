package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.RG;

public class EdicaoRg extends Edicao{
    private List<RG> rgs;

    public EdicaoRg(List<RG> rgs) {
        this.rgs = rgs;
    }

    @Override
    public void editar() {
        int i = 0;
        
        for (RG rg : rgs) {
            System.out.println("”¸ [" + Integer.sum(i,1) + "] " + rg.getValor());
            ++i;
        }
        System.out.print("\nQual RG deseja editar?");
        Entrada entrada = new Entrada();
        
        boolean flag = true;
        while (flag) {
            String operacao = entrada.receberTexto();
            if (operacao != null && operacao.matches("[0-9.]+")) {
                int op = Integer.parseInt(operacao);
                if (op > rgs.size() || op ==  0) {
                    System.out.println("\nRG inválido");
                    System.out.print("\nQual RG deseja editar? ");
                } else {
                    rgs.remove(op-1);
                    flag = false;
                }
            } else {
                System.out.println("\nRG inválido");
                System.out.print("\nQual RG deseja editar? ");
            }
        }

        Cadastro cadastroRg = new CadastroRg(rgs);
		cadastroRg.cadastrar();

        System.out.println("\nAlteração realizada com sucesso!\n");
    }
}

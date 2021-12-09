package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class BuscaProduto extends Busca {
    private List<Produto> produtos;

    public BuscaProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public void buscar() {
        
        System.out.println("\nBUSCAR PRODUTO & SERVI�O");
        System.out.print("\nInsira o c�dido do produto/servi�o: ");
        Produto prod = null;
        Entrada entrada = new Entrada();
        String cod = entrada.receberTexto();

        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(cod)) {
                prod = produto;
                ImpressaoCLI impProd = new ImpressaoCLIProduto(prod);
                impProd.imprimir();

                boolean exec = true;
                while (exec) {
                    System.out.println("\nOPERA��ES");
                    System.out.println("\n1 - Editar produto");
                    System.out.println("2 - Deletar produto");
                    System.out.println("3 - Cancelar");
                    System.out.print("\nEscolha uma op��o: ");
                    
                    Entrada novaEntrada = new Entrada();
                    String operacao = novaEntrada.receberTexto();
                    switch (operacao) {
                        case "1":
                            Edicao edicaoProd = new EdicaoProduto(prod);
                            edicaoProd.editar();
                            exec = false;
                            break;
                        case "2":
                            produtos.remove(produto);
                            System.out.println("\nProduto deletado com sucesso!");
                            exec = false;
                            break;
                        case "3":
                            exec = false;
                            break;
                        default:
                            System.out.println("\nOp��o Inv�lida :(");
                    }
                }
                
                break;
            }
        }
        if (prod == null) System.out.println("\nN�o foi encontrado nenhum produto/servi�o com esse c�digo");      
    }

    
}

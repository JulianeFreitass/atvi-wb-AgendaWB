package com.wb.negocio;

import java.util.List;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;

public class ListarConsumo extends Listagem {
    private List<Consumo> consumos;

    public ListarConsumo(List<Consumo> consumos) {
        this.consumos = consumos;
    }

    @Override
    public void listar() {

        if (consumos.isEmpty()) {
        	System.out.println("\nNão foi encontrado nenhum registro de consumo");
        } else {
            System.out.println("\nLISTA DE CONSUMOS");
            int c = 1;
            for (Consumo consumo : consumos) {
                System.out.println("\nVenda Nº " + c);
                c += 1;
                System.out.print("\nCliente: " + consumo.getCliente().nome);
                System.out.print("\nValor: R$ " + consumo.getPrecoTotal());
                System.out.println("\nData: " + consumo.getDataConsumo());
                for (Produto prodCons : consumo.getProdutosConsumidos()) {
                    System.out.print("\nProduto: " + prodCons.getNome());
                    System.out.println("\nPreço: R$ " + prodCons.getPreco());
                }
            }
        }
    }
}

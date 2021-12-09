package com.wb.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wb.modelo.Consumo;
import com.wb.modelo.ConsumoProduto;
import com.wb.modelo.Produto;

public class ListarMaisConsumidos extends Listagem {
    private List<Produto> produtos;
    private List<Consumo> consumos;

    public ListarMaisConsumidos(List<Produto> produtos, List<Consumo> consumos) {
        this.produtos = produtos;
        this.consumos = consumos;
    }

    @Override
    public void listar() {
        Map<Produto, Integer> myDict = new HashMap<Produto, Integer>();

        for (Produto produto : produtos) {
            int total = 0;
            myDict.put(produto, total);
        }

        for (Consumo consumo : consumos) {
            List<Produto> produtos = consumo.getProdutosConsumidos();
            for (Produto produto : produtos) {
                myDict.merge(produto, 1, (a,b) -> a+b);
            }
        }

        Set<Produto> prodKeys = myDict.keySet();
        List<ConsumoProduto> consumosProdutos = new ArrayList<ConsumoProduto>();

        for(Produto produto : prodKeys) {
            if (myDict.get(produto) > 0) {
                int consumo = myDict.get(produto);
                ConsumoProduto consProd = new ConsumoProduto(consumo,  produto.nome);
                consumosProdutos.add(consProd);
            }
        }
        
        Collections.sort(consumosProdutos);

        if (consumosProdutos.isEmpty()) {
        	System.out.println("\nNão foi encontrado nenhum registro de consumo");
        } else {
            int c = 1;
            if (consumosProdutos.size() <= 10) {
                for(ConsumoProduto cP : consumosProdutos) {
                    System.out.println("\nProduto Nº " + c);
                    System.out.println("\nProduto/Serviço: " + cP.nome);
                    System.out.println("Total de Produtos Consumidos: " + cP.qntConsumo);
                    c++;
                }
            } else {
                for(ConsumoProduto cP : consumosProdutos) {
                    System.out.println("\nProduto Nº " + c);
                    System.out.println("\nProduto/Serviço: " + cP.nome);
                    System.out.println("Total de Produtos Consumidos: " + cP.qntConsumo);
                    c++;
                    if (c > 10) {
                        break;
                    }
                }
            }
        }
    }
    
}

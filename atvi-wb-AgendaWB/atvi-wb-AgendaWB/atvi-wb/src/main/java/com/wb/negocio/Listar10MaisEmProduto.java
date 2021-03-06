package com.wb.negocio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.wb.modelo.Cliente;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;

public class Listar10MaisEmProduto extends Listagem {
    private List<Cliente> clientes;

    public Listar10MaisEmProduto(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void listar() {
        Map<Cliente, Integer> myDict = new HashMap<Cliente, Integer>();

        for (Cliente cliente : clientes) {
            int totalProdutos = 0;
            List<Consumo> consumos = cliente.getListaConsumo();
            for (Consumo consumo : consumos) {
                List<Produto> produtos = consumo.getProdutosConsumidos();
                totalProdutos += produtos.size();
            }
            if (totalProdutos != 0) {
                myDict.put(cliente, totalProdutos);
            }
        }
        
        if (myDict.isEmpty()) {
            System.out.println("\nN?o foi encontrado nenhum registro de consumo");
        } else {
            Map<Cliente, Integer> reverseSortedMap = new TreeMap<Cliente, Integer>();
            reverseSortedMap.putAll(myDict);
        
            int c = 1;
            if (reverseSortedMap.size() <= 10) {
                for (Entry<Cliente, Integer> entry : reverseSortedMap.entrySet()) {
                String key = entry.getKey().nome;
                Object val = entry.getValue();   
                System.out.println("\nCliente N?" + c);
                System.out.println("\nNome: " + key);
                System.out.println("Total de Produtos Consumidos: " + val);
                c++;
                }
            } else {
                for (Entry<Cliente, Integer> entry : reverseSortedMap.entrySet()) {
                    String key = entry.getKey().nome;
                    Object val = entry.getValue();   
                    System.out.println("\nCliente N?" + c);
                    System.out.println("\nNome: " + key);
                    System.out.println("Total de Produtos Consumidos: " + val);
                    c++;
                    if (c > 10) {
                        break;
                    }
                }
            }
            if (c <= 10) {
                System.out.println("\nSomente " + c-- + " clientes consumiram nosos produtos/servi?os!");
            }
        }
    }
}

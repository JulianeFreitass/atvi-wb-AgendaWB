package com.wb.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wb.io.Entrada;
import com.wb.modelo.Consumo;
import com.wb.modelo.ConsumoProduto;
import com.wb.modelo.Produto;

public class ListarMaisConsumidosGenero extends Listagem {
    private List<Produto> produtos;
    private List<Consumo> consumos;

    public ListarMaisConsumidosGenero(List<Produto> produtos, List<Consumo> consumos) {
        this.produtos = produtos;
        this.consumos = consumos;
    }

    @Override
    public void listar() {

        String categoria = "Todos";
        boolean exec = true;

        while (exec) {
            System.out.println("\nMAIS CONSUMIDOS\n");
            System.out.println("1- Por gênero Masculino");
            System.out.println("2- Por gênero Feminino");
            System.out.println("3 - Todos");
            System.out.print("\nEscolha uma Opção: ");

            Entrada entradaProd = new Entrada();
            String opProd = entradaProd.receberTexto();
            switch (opProd) {
                case "1":
                    categoria = "Masculino";
                    exec = false;
                    break;
                case "2":
                    categoria = "Feminino";
                    exec = false;
                    break;
                case "3":
                    categoria = "Todos";
                    exec = false;
                    break;
                default:
                    System.out.println("\nOpção Inválida");
            }
        }
        
        Map<Produto, Integer> myDict = new HashMap<Produto, Integer>();

        for (Produto produto : produtos) {
            int total = 0;
            myDict.put(produto, total);
        }
        
        for (Consumo consumo : consumos) {
            List<Produto> produtos = consumo.getProdutosConsumidos();
            for (Produto produto : produtos) {
                if (produto.getCategoria() == categoria) {
                    myDict.merge(produto, 1, (a,b) -> a+b);
                }
            }
        }

        Set<Produto> prodKeys = myDict.keySet();
        List<ConsumoProduto> consumosProdutos = new ArrayList<ConsumoProduto>();

        for(Produto produto : prodKeys) {
            if (produto.getCategoria() == categoria && myDict.get(produto) > 0) {
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
            for(ConsumoProduto cP : consumosProdutos) {
                    System.out.println("\nProduto Nº " + c);
                    System.out.println("\nProduto/Serviço: " + cP.nome);
                    System.out.println("Total de Produtos Consumidos: " + cP.qntConsumo);
                    c++;
            }
        }
    }
    
}

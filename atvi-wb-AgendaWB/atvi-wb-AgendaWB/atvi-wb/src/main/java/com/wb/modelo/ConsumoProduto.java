package com.wb.modelo;

public class ConsumoProduto implements Comparable<ConsumoProduto> {
    public Integer qntConsumo;
    public String nome;

    public ConsumoProduto(Integer qntConsumo, String nome) {
        this.qntConsumo = qntConsumo;
        this.nome = nome;
    }

    @Override
    public int compareTo(ConsumoProduto o) {
        return o.qntConsumo.compareTo(this.qntConsumo);
    }
    
}

package com.wb.modelo;

import java.time.LocalDate;
import java.util.List;

public class Consumo {
    
    private Double precoTotal;
    private LocalDate dataConsumo;
    private String nomeCliente;
    private CPF cpfCliente;

    private Cliente cliente;
    private List<Produto> produtosConsumidos;

    public Consumo(){

    }

    public Consumo(List<Produto> produtosConsumidos, Double precoTotal,  Cliente cliente){
        this.produtosConsumidos = produtosConsumidos;
        this.precoTotal = precoTotal;
        this.dataConsumo = LocalDate.now();
        this.cliente = cliente;
    }
    
    public Consumo(List<ProdutoConsumido> produtosConsumidos, Double precoTotal,
            String nomeCliente, CPF cpfCliente) {
       
        this.precoTotal = precoTotal;
        this.nomeCliente = nomeCliente;
        this.dataConsumo = LocalDate.now();
        this.cpfCliente = cpfCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutosConsumidos() {
        return produtosConsumidos;
    }

    public void setProdutosConsumidos(List<Produto> produtosConsumidos) {
        this.produtosConsumidos = produtosConsumidos;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public LocalDate getDataConsumo() {
        return dataConsumo;
    }

    public void setDataConsumo(LocalDate dataConsumo) {
        this.dataConsumo = dataConsumo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public CPF getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(CPF cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    
}

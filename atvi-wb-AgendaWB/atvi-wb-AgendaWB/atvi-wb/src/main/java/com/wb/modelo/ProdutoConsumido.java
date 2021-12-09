package com.wb.modelo;

public class ProdutoConsumido {

  private String nome;
  private Double preco;

  public ProdutoConsumido(String nome, Double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

	public Double getPreco() {
		return preco;
	}
    
}

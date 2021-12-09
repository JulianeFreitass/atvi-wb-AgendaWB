package com.wb.modelo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Servico> servicos;
	private List<Consumo> consumos;
	
	public Empresa() {
		this.clientes = new ArrayList<Cliente>();
		this.produtos = new ArrayList<Produto>();
		this.servicos = new ArrayList<Servico>();
		this.consumos = new ArrayList<Consumo>();
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public List<Consumo> getConsumos() {
		return consumos;
	}
}
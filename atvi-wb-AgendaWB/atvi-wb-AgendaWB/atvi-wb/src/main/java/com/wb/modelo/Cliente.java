package com.wb.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Comparable<Cliente> {
	public String nome;
	public String nomeSocial;
	private String genero;
	private CPF cpf;
	private List<RG> rgs = new ArrayList<RG>();
	private LocalDate dataCadastro;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	private List<Consumo> listaConsumo = new ArrayList<Consumo>();
	private Double consumoTotal;

	public Cliente(String nome, String nomeSocial, String genero, CPF cpf) {
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.genero = genero;
		this.cpf = cpf;
		this.rgs = new ArrayList<RG>();
		this.dataCadastro = LocalDate.now();
		this.telefones = new ArrayList<Telefone>();
		this.listaConsumo = new ArrayList<Consumo>();
	}
	
	public Cliente(String nome, String nomeSocial, String genero, CPF cpf, List<Telefone> telefones, List<RG> rgs) {
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.genero = genero;
		this.cpf = cpf;
		this.rgs = new ArrayList<RG>();
		this.dataCadastro = LocalDate.now();
		this.telefones = new ArrayList<Telefone>();
		this.listaConsumo = new ArrayList<Consumo>();
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public CPF getCpf() {
		return cpf;
	}
	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
	public List<RG> getRgs() {
		return rgs;
	}
	public void setRgs(List<RG> rgs) {
		this.rgs = rgs;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTels(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Consumo> getListaConsumo() {
		return listaConsumo;
	}
	public void setConsumoTotal() {
		Double t = 0.0;
		for (Consumo consumo : listaConsumo) {
			t += consumo.getPrecoTotal();
		}
		this.consumoTotal = t;
	}
	public Double getConsumoTotal() {
		return consumoTotal;
	}
	public int compareTo(Cliente o) {
		if (this.consumoTotal > o.getConsumoTotal()) { 
  			return -1; 
  		} if (this.consumoTotal < o.getConsumoTotal()) {
			return 1;
		  } 
  		return 0; 
	}
}
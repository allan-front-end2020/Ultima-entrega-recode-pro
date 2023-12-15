package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Destino {
	
	@Id
	@GeneratedValue
	private long _id;
	
	@Column(name="destino_nome", length= 50, nullable = false)
	private String nome;
	
	private int valor;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="reserva", joinColumns=@JoinColumn(name="destino_id"), inverseJoinColumns=@JoinColumn(name="cliente_id"))
	private Set<Cliente> clientes = new HashSet<>();
	
	
	
	
  public long get_id() {
		return _id;
	}


	public void set_id(long _id) {
		this._id = _id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public Set<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}



	
	

}

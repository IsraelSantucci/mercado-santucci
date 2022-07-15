package br.com.santucci.mercado.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "clienteId", cascade = CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	public Cliente() {

	}

	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void adicionarPedido(Pedido pedido) {
		pedidos.add(pedido);
	
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setVendas(List<Pedido> pedido) {
		this.pedidos = pedido;
	}
	
	

}

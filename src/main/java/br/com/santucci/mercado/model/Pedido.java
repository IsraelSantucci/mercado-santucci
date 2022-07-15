package br.com.santucci.mercado.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendas")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "data_venda")
	private LocalDate dataVenda;
	@ManyToOne
	private Cliente clienteId;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Item> itens;

	public Pedido() {

	}

	public Pedido(Cliente cliente) {
		this.dataVenda = LocalDate.now();
		this.clienteId = cliente;
	}
	
	public void adicionarItem(Item item) {
		itens.add(item);
		item.setPedido(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente cliente) {
		this.clienteId = cliente;
	}

	
}

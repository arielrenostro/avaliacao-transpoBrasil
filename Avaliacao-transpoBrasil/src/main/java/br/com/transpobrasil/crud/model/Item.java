package br.com.transpobrasil.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="item", schema="avaliacao")
@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pk_seq_item",sequenceName="seq_item")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_seq_item")
	@Column(name="oid", unique = true, nullable = false)
	private int id;
	
	@Column(name="descricao", length=255)
	private String descricao;
	
	@Column(name="valor")
	private double valor;
	
	public Item() {
		super();
	}

	public Item(int id, String descricao, double valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}

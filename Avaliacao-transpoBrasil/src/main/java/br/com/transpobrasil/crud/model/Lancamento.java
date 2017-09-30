package br.com.transpobrasil.crud.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="lancamento", schema="desafio")
@Entity
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_lancamento")
	@Column(name="oid", unique = true, nullable = false)
	private int id;
	
	@Column(name="dt_inicial")
	@Temporal(TemporalType.DATE)
	private Date dt_inicial;
	
	@Column(name="dt_final")
	@Temporal(TemporalType.DATE)
	private Date dt_final;
	
	@Column(name="vlr_total")
	private double vlr_total;
	
	@Column(name="observacao", length=1000)
	private String observacao;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name				  ="lancamentoitem", 
               joinColumns 		  = { @JoinColumn(name = "oid_lancamento") }, 
               inverseJoinColumns = { @JoinColumn(name = "oid_item") })
	private Set<Item> itens = new HashSet<Item>();
	
	public Lancamento() {
		super();
	}
	
	public Lancamento(int id, Date dt_inicial, Date dt_final, double vlr_total, String observacao,	Set<Item> itens) {
		super();
		this.id = id;
		this.dt_inicial = dt_inicial;
		this.dt_final = dt_final;
		this.vlr_total = vlr_total;
		this.observacao = observacao;
		this.itens = itens;
	}	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDt_inicial() {
		return this.dt_inicial;
	}
	
	public void setDt_inicial(Date dt_inicial) {
		this.dt_inicial = dt_inicial;
	}
	
	public Date getDt_final() {
		return this.dt_final;
	}
	
	public void setDt_final(Date dt_final) {
		this.dt_final = dt_final;
	}
	
	public double getVlr_total() {
		return this.vlr_total;
	}
	
	public void setVlr_total(double vlr_total) {
		this.vlr_total = vlr_total;
	}
	
	public String getObservacao() {
		return this.observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Set<Item> getItens() {
		return this.itens;
	}
	
	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}
	
}

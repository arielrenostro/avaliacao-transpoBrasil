package br.com.transpobrasil.crud.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="lancamento", schema="avaliacao")
@Entity
public class Lancamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_seq_lancamento", sequenceName="seq_lancamento", schema="avaliacao", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_seq_lancamento")
	@Column(name="oid", unique = true, nullable = false)
	private int id;
	
	@Column(name="dt_inicial")
	@Temporal(TemporalType.DATE)
	private Date dt_inicial;
	
	@Column(name="dt_final")
	@Temporal(TemporalType.DATE)
	private Date dt_final;
	
	@Column(name="vl_total")
	private double vl_total;
	
	@Column(name="observacao", length=1000)
	private String observacao;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name				  = "lancamentoitem", schema = "avaliacao",
               joinColumns 		  = { @JoinColumn(name = "oid_lancamento") }, 
               inverseJoinColumns = { @JoinColumn(name = "oid_item") })
	private List<Item> itens = new ArrayList<Item>();
	
	public Lancamento() {
		super();
	}
	
	public Lancamento(int id, Date dt_inicial, Date dt_final, double vlr_total, String observacao,	List<Item> itens) {
		super();
		this.id = id;
		this.dt_inicial = dt_inicial;
		this.dt_final = dt_final;
		this.vl_total = vlr_total;
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
	
	public double getVl_total() {
		return this.vl_total;
	}
	
	public void setVl_total(double vl_total) {
		this.vl_total = vl_total;
	}
	
	public String getObservacao() {
		return this.observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public List<Item> getItens() {
		return this.itens;
	}
	
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
}

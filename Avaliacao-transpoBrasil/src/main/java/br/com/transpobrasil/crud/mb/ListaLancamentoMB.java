package br.com.transpobrasil.crud.mb;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.transpobrasil.crud.model.Item;
import br.com.transpobrasil.crud.model.Lancamento;
import br.com.transpobrasil.crud.service.LancamentoService;

@Named
@ViewScoped
public class ListaLancamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LancamentoService lancamentoService;
	
	private List<Lancamento> lancamentos 				= new ArrayList<Lancamento>();
	private List<Lancamento> lancamentosSelecionados 	= new ArrayList<Lancamento>();

	@PostConstruct
	public void init() {
		lancamentos = lancamentoService.listarTodos();		
	}
	
	public void excluirSelecionados() {
		try {
			for (Lancamento lancamento : lancamentosSelecionados) {
				lancamentoService.excluir(lancamento);
				lancamentos.remove(lancamento);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage(), ""));
		}
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public List<Lancamento> getLancamentosSelecionados() {
		return lancamentosSelecionados;
	}

	public void setLancamentosSelecionados(List<Lancamento> lancamentosSelecionados) {
		this.lancamentosSelecionados = lancamentosSelecionados;
	}

}

package br.com.transpobrasil.crud.mb;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.transpobrasil.crud.model.Item;
import br.com.transpobrasil.crud.service.ItemService;

@Named
@ViewScoped
public class ListaItemMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ItemService itemService;
	
	private List<Item> itens 				= new ArrayList<Item>();
	private List<Item> itensSelecionados 	= new ArrayList<Item>();
	
	@PostConstruct
	public void init() {
		itens = itemService.listarTodos();		
	}
	
	public void excluirSelecionados() {
		try {
			for (Item item : itensSelecionados) {
				itemService.excluir(item);
				itens.remove(item);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage(), ""));
		}
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public List<Item> getItensSelecionados() {
		return itensSelecionados;
	}
	
	public void setItensSelecionados(List<Item> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}
}

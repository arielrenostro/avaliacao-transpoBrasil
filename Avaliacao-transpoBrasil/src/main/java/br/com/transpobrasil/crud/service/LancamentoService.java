package br.com.transpobrasil.crud.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.transpobrasil.crud.dao.LancamentoDAO;
import br.com.transpobrasil.crud.model.Item;
import br.com.transpobrasil.crud.model.Lancamento;

public class LancamentoService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	LancamentoDAO lancamentoDAO;
	
	public void salvar(Lancamento l) {
		if(l.getId() > 0)
			lancamentoDAO.update(l);
		else
			lancamentoDAO.salvar(l);
	}
	
	public void excluir(Lancamento l) {
		lancamentoDAO.excluir(l);
	}
	
	public void updateValorItens(Lancamento l) {
		
		double vl_total = 0;
		
		for(Item item:l.getItens())
			vl_total += item.getValor();
		
		l.setVl_total(vl_total);
	}
	
	public void adicionarItem(Lancamento l, Item item) {
		
		for(Item i:l.getItens()) // Verifica se o item já não foi adicionado
			if(i.getId() == item.getId())
				return;
		
		if(item.getId() > 0) {
			l.getItens().add(item);
			updateValorItens(l);
		}
	}
	
	public void excluirItem(Lancamento l, Item item) {
		l.getItens().remove(item);
		updateValorItens(l);
	}
	
	public List<Lancamento> listarTodos() {
		return lancamentoDAO.listarTodos();
	}
	
	public Lancamento porId(int id) {
		return lancamentoDAO.porId(id);
	}
}

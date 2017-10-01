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
	
	public void excluirItem(Lancamento l, Item item) {
		l.getItens().remove(item);
	}
	
	public List<Lancamento> listarTodos() {
		return lancamentoDAO.listarTodos();
	}
	
	public Lancamento porId(int id) {
		return lancamentoDAO.porId(id);
	}
}

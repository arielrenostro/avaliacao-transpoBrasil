package br.com.transpobrasil.crud.service;

import java.util.List;

import javax.inject.Inject;

import br.com.transpobrasil.crud.dao.LancamentoDAO;
import br.com.transpobrasil.crud.model.Lancamento;

public class LancamentoService {

	@Inject 
	LancamentoDAO lancamentoDAO;
	
	public Lancamento salvar(Lancamento l) {
		return lancamentoDAO.salvar(l);
	}
	
	public void excluir(Lancamento l) {
		lancamentoDAO.excluir(l);
	}
	
	public List<Lancamento> listarTodos() {
		return lancamentoDAO.listarTodos();
	}
	
	public Lancamento porId(int id) {
		return lancamentoDAO.porId(id);
	}
}

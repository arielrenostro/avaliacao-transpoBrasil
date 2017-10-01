package br.com.transpobrasil.crud.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.transpobrasil.crud.exception.AppException;
import br.com.transpobrasil.crud.model.Lancamento;

@RequestScoped
public class LancamentoDAO {

	@Inject
	private EntityManager manager;
	
	public Lancamento salvar(Lancamento l) {
		return manager.merge(l);
	}
	
	public void excluir(Lancamento l) {
		
		try {
			
			l = porId(l.getId());
			manager.remove(l);
			manager.flush();
			
		} catch (Exception e) {
			throw new AppException("Falha ao excluir lanšamento !");
		}
	}
	
	public Lancamento porId(int id) {
		return manager.find(Lancamento.class, id);
	}
	
	public List<Lancamento> listarTodos() {
		return manager.createQuery("FROM lancamento").getResultList();
	}
}

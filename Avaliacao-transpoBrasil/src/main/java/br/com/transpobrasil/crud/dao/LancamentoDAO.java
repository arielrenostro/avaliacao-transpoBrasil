package br.com.transpobrasil.crud.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.transpobrasil.crud.exception.AppException;
import br.com.transpobrasil.crud.model.Item;
import br.com.transpobrasil.crud.model.Lancamento;

public class LancamentoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(Lancamento l) {
		manager.getTransaction().begin();
		manager.persist(l);
		manager.getTransaction().commit();
	}
	
	public void update(Lancamento l) {
		manager.getTransaction().begin();
		manager.merge(l);
		manager.getTransaction().commit();
	}
	
	public void excluir(Lancamento l) {
		
		try {
			
			l = porId(l.getId());
			manager.getTransaction().begin();
			manager.remove(l);
			manager.flush();
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			throw new AppException("Falha ao excluir lançamento !");
		}
	}
	
	public Lancamento porId(int id) {
		return manager.find(Lancamento.class, id);
	}
	
	public List<Lancamento> listarTodos() {
		return manager.createQuery("FROM Lancamento").getResultList();
	}
}

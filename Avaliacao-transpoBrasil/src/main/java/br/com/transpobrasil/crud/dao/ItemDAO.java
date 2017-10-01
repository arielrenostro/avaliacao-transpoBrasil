package br.com.transpobrasil.crud.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.transpobrasil.crud.exception.AppException;
import br.com.transpobrasil.crud.model.Item;

public class ItemDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void update(Item i) {
		manager.getTransaction().begin();
		manager.merge(i);
		manager.getTransaction().commit();
	}
	
	public void salvar(Item i) {
		manager.getTransaction().begin();
		manager.persist(i);
		manager.getTransaction().commit();
	}

	public void excluir(Item i) {
		
		try {
			
			i = porId(i.getId());
			manager.getTransaction().begin();
			manager.remove(i);
			manager.flush();
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			throw new AppException("Falha ao excluir o item !");
		}
	}
	
	public Item porId(int id) {
		return manager.find(Item.class, id);
	}
	
	public List<Item> listarTodos() {
		return manager.createQuery("FROM Item").getResultList();
	}
}

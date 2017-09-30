package br.com.transpobrasil.crud.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.transpobrasil.crud.exception.AppException;
import br.com.transpobrasil.crud.model.Item;

public class ItemDAO {
	
	@Inject
	private EntityManager manager;
	
	public Item salvar(Item i) {
		return manager.merge(i);
	}

	public void excluir(Item i) {
		
		try {
			
			i = porId(i.getId());
			manager.remove(i);
			manager.flush();
			
		} catch (Exception e) {
			throw new AppException("Falha ao excluir o item !");
		}
	}
	
	public Item porId(int id) {
		return manager.find(Item.class, id);
	}
	
	public List<Item> listarTodos() {
		return manager.createQuery("FROM item").getResultList();
	}
}

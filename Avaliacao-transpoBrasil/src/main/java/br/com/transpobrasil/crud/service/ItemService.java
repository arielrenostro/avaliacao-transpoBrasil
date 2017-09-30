package br.com.transpobrasil.crud.service;

import java.util.List;

import javax.inject.Inject;

import br.com.transpobrasil.crud.dao.ItemDAO;
import br.com.transpobrasil.crud.model.Item;

public class ItemService {

	
	@Inject
	private ItemDAO itemDAO;
	
	public Item salvar(Item i) {
		return itemDAO.salvar(i);
	}
	
	public void excluir(Item i) {
		itemDAO.excluir(i);
	}
	
	public List<Item> listarTodos() {
		return itemDAO.listarTodos();
	}
	
	public Item porId(int id) {
		return itemDAO.porId(id);
	}
}
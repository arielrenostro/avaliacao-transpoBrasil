package br.com.transpobrasil.crud.mb;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.transpobrasil.crud.model.Item;
import br.com.transpobrasil.crud.service.ItemService;

@Named
@ViewScoped
public class ItemMB {
	
	private Item item = new Item();
	private int id;
	
	@Inject
	private ItemService itemService;
	
	public void init() {
		if (id != 0) {
			item = itemService.porId(id);
		}
	}
	
	public String salvar(Item i) {
		itemService.salvar(i);
		return "item.xhtml?faces-redirect=true";
	}
	
	public String excluir(Item i) {
		itemService.excluir(i);
		return "item.xhtml?faces-redirect=true";
	}
	
	public void setItem(Item i) {
		this.item = i;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public void setId(int i) {
		this.id = i;
	}
	
	public int getId() {
		return this.id;
	}
}

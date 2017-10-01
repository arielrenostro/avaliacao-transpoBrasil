package br.com.transpobrasil.crud.mb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.com.transpobrasil.crud.model.Item;
import br.com.transpobrasil.crud.model.Lancamento;
import br.com.transpobrasil.crud.service.ItemService;
import br.com.transpobrasil.crud.service.LancamentoService;

@Named
@ViewScoped
public class LancamentoMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Lancamento 	lancamento;
	private List<Item> 	itens; // Auto completar dos itens
	private int 		id;
	private int 		itemAdicionarId;
	
	@Inject 
	private LancamentoService 	lancamentoService;
	
	@Inject 
	private ItemService 		itemService;
	
	public void init() {
		
		if(this.lancamento == null) {
			if (id != 0)
				this.lancamento = this.lancamentoService.porId(id);
			else
				this.lancamento = new Lancamento();
		}
		
		if(this.itens == null) {
			updateItens();
		}
	}
	
	private void updateItens() {
		
		this.itens 			= this.itemService.listarTodos();
		List<Item> remover 	= new ArrayList<Item>(); 
		
		for(int i=0; i < this.lancamento.getItens().size(); i++) {
			
			Item item = this.lancamento.getItens().get(i);
			
			for(Item item2:this.itens) {
				if(item.getId() == item2.getId())
					remover.add(item2);
			}
		}
		
		if(remover.size() > 0)
			this.itens.removeAll(remover);
	}
	
	public String salvar() {
		this.lancamentoService.salvar(lancamento);
		return "lista-lancamento.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		try {
			this.lancamentoService.excluir(lancamento);
			return "lista-lancamento.xhtml?faces-redirect=true";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage(), ""));
			return null;
		}
	}
	
	public void setLancamento(Lancamento i) {
		this.lancamento = i;
	}
	
	public Lancamento getLancamento() {
		return this.lancamento;
	}
	
	public void setId(int i) {
		this.id = i;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void adicionarItem() {
		
		if(this.itemAdicionarId > 0) {
			Item item = this.itemService.porId(this.itemAdicionarId);
			adicionarItem(item);
		}
	}
	
	public void adicionarItem(Item item) {
		this.lancamentoService.adicionarItem(lancamento, item);
		updateItens();
	}
	
	public void excluirItem(Item item) {
		this.lancamentoService.excluirItem(lancamento, item);
		updateItens();
	}
	
	public int getItemAdicionarId() {
		return this.itemAdicionarId;
	}
	
	public void setItemAdicionarId(int itemAdicionarId) {
		this.itemAdicionarId = itemAdicionarId;
	}
	
	public List<String> completarItemAdicionar(String s) {
		
		List<String> results = new ArrayList<String>();
		
		for(Item item:this.itens) {
			
			String id = Integer.toString(item.getId());
			
			if(id.contains(s))
				results.add(id);
			
			if(results.size() >= 10) // Lista no máximo 10
				break;
		}
		
		return results;
	}

	public void onDateSelect(SelectEvent event) {
        FacesContext 		facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat 	format		 = new SimpleDateFormat("dd/MM/YYYY");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Selecionada", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    

}

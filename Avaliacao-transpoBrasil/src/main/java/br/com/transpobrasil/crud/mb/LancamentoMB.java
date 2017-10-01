package br.com.transpobrasil.crud.mb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.com.transpobrasil.crud.model.Item;
import br.com.transpobrasil.crud.model.Lancamento;
import br.com.transpobrasil.crud.service.LancamentoService;

@Named
@ViewScoped
public class LancamentoMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Lancamento 	lancamento 	= new Lancamento();
	private Set<Item> 	itens 		= new HashSet<Item>();
	private int id;
	
	@Inject
	private LancamentoService lancamentoService;
	
	public void init() {
		if (id != 0) {
			lancamento  = lancamentoService.porId(id);
			itens 		= lancamento.getItens();
		}
	}
	
	public String salvar() {
		lancamento.setItens(itens);
		lancamentoService.salvar(lancamento);
		return "lista-item.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		lancamentoService.excluir(lancamento);
		return "lista-item.xhtml?faces-redirect=true";
	}
	
	public void setLancamento(Lancamento i) {
		this.lancamento = i;
	}
	
	public Set<Item> getItens() {
		return itens;
	}
	
	public void setItens(Set<Item> itens) {
		this.itens = itens;
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
	
	public void excluirItem(Item item) {
		//lancamentoService.excluirItem(lancamento, item);
		itens.remove(item);
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

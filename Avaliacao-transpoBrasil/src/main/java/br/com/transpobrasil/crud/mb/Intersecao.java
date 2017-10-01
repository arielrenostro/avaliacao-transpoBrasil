package br.com.transpobrasil.crud.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Intersecao {
	
	private int faixa_1_1;
	private int faixa_1_2;
	private int faixa_2_1;
	private int faixa_2_2;
	
	public Intersecao() {
	}
	
	public void consultar() {
		
		String msg = "";
		
		if(((faixa_1_1 >= faixa_2_1) && (faixa_1_1 <= faixa_2_2)) || 
		   ((faixa_1_2 >= faixa_2_1) && (faixa_1_2 <= faixa_2_2)) || 
		   
		   ((faixa_2_1 >= faixa_1_1) && (faixa_2_1 <= faixa_1_2)) || 
		   ((faixa_2_2 >= faixa_1_1) && (faixa_2_2 <= faixa_1_2)))
			msg = "Existe interseção entre as faixas 1 e 2.";
		else
			msg = "Não há interseção entre as faixas 1 e 2.";
			
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg, ""));
	}
	
	public int getFaixa_1_1() {
		return this.faixa_1_1;
	}
	
	public void setFaixa_1_1(int faixa_1_1) {
		this.faixa_1_1 = faixa_1_1;
	}
	
	public int getFaixa_1_2() {
		return this.faixa_1_2;
	}
	
	public void setFaixa_1_2(int faixa_1_2) {
		this.faixa_1_2 = faixa_1_2;
	}
	
	public int getFaixa_2_1() {
		return this.faixa_2_1;
	}
	
	public void setFaixa_2_1(int faixa_2_1) {
		this.faixa_2_1 = faixa_2_1;
	}
	
	public int getFaixa_2_2() {
		return this.faixa_2_2;
	}
	
	public void setFaixa_2_2(int faixa_2_2) {
		this.faixa_2_2 = faixa_2_2;
	}
	
}

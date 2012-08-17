package br.teste;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SomaSessionScopedBean {

	private int numero1;
	private int numero2;
	private int resultado;
	
	
	
	public SomaSessionScopedBean() {
		super();
	}

	public String somar() {
		resultado = numero1 + numero2;
		return "resultadoSessionScoped";
	}
	
	public String voltar() {
		return "somaSessionScoped";
	}
	
	public int getNumero1() {
		return numero1;
	}
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	public int getNumero2() {
		return numero2;
	}
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	
	
	
	
}

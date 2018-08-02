package br.com.agabsistemas.jsptags;

public class empregado {
	private String nome;
	private String sobrenome;
	private String posto;
	private double salario;
	
	public empregado(String nome, String sobrenome, String posto, double salario) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.posto = posto;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}

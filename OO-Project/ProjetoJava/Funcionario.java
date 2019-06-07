package com.mateus;

public abstract class Funcionario implements payRoll {
	
	private String nome;
	private String endereco;
	private double salario;
	public int DtInicial;
	Caretaker ct;
	
	
	public Funcionario() {
		ct = new Caretaker();
		nome = new String();
		
	}
	
	public void setNome(String nome) {
		ct.addMemento(new Memento(nome));
		this.nome += nome;
	}
	
	public void undo() {
		this.nome = ct.getLastState().getState();
	}
	public void showName() {
		System.out.println(this.nome);
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
		

}

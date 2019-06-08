package com.payroll;

public abstract class Funcionario implements PayRoll {
	
	private String name;
	private String adress;
	private double salary;
	public int DtInicial;
	
	//Caretaker ct;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
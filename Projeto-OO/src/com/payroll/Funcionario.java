package com.payroll;

import java.util.Date;

public abstract class Funcionario implements PayRoll {
	
	protected String name;
	protected String adress;
	protected double salary;
	protected String payMode;
	protected String type;
	protected int DtInicial;
	protected boolean sindicaty;
	protected String code;
	protected String Scode;
	protected boolean saved = false;
	
	
	//Caretaker ct;
	public String toString() {
		return name + " - " + code +  " - " + salary + "RS";
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public boolean isSindicaty() {
		return sindicaty;
	}
	public void setSindicaty(boolean sindicaty) {
		this.sindicaty = sindicaty;
	}
	

	public void setCode(String code) {
		this.code = code;
		
	}

	public String getCode() {
		return this.code;
	}

	public void setSindicatycode(String Scode) {
		this.Scode = Scode;
	}


	public String getSindicatycode() {
		return this.Scode;
	}
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	public void listarFuncionarios() {
		System.out.println( this.getName() + " "+ this.getSalary() + " " + this.getType() + "\n");
	}

}
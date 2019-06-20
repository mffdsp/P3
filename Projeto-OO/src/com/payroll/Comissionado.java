package com.payroll;

import java.util.Date;

public class Comissionado extends Funcionario implements PayRoll {
	
	private double valordevendas;
	
	
	public boolean pagarFuncionario() {
		// TODO Auto-generated method stub
	return true;
		
	}

	public double getValordevendas() {
		return valordevendas;
	}

	public void setValordevendas(double valordevendas) {
		this.valordevendas = valordevendas;
	}

}

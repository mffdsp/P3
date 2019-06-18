package com.payroll;

import java.util.Date;

public class Comissionado extends Funcionario implements ManageCode, PayRoll {
	
	private double valordevendas;
	
	@Override
	public void listarFuncionarios() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean pagarFuncionario() {
		// TODO Auto-generated method stub
		return true;
		
	}

	@Override
	public int getDtInicial() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Date getDtFinal() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incluirDesconto(String hist, float val) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public double getValordevendas() {
		return valordevendas;
	}

	public void setValordevendas(double valordevendas) {
		this.valordevendas = valordevendas;
	}

}

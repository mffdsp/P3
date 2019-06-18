package com.payroll;

import java.util.Date;

public class Assalariado extends Funcionario implements ManageCode, PayRoll{

	
	private int payday;
	
	@Override
	public void listarFuncionarios() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean pagarFuncionario() {
		return true;
		// TODO Auto-generated method stub
		
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

	public int getPayday() {
		return payday;
	}

	public void setPayday(int payday) {
		this.payday = payday;
	}

}

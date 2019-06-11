package com.payroll;


import java.util.Date;

public class Horista extends Funcionario implements ManageCode{
	
	private String code;
	private String Scode;
	
	public void printalgo() {
		System.out.println("saoaossa");
	}

	@Override
	public void pagarFuncionario() {
		System.out.println("PAGOU OIA");
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDtInicial() throws Exception {
		// TODO Auto-generated method stub
		return super.DtInicial;
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

	@Override
	public void listarFuncionarios() {
		System.out.println( this.getName() + this.getSalary() + this.getType());
		// TODO Auto-generated method stub
		
	}
	
	
}
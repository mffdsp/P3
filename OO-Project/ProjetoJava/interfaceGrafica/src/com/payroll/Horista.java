package com.payroll;


import java.util.Date;

public class Horista extends Funcionario implements ManageCode, PayRoll{
	
	private int HoraExtra;
	private int HorasTrabalhadas;
	
	
	 public Horista(String teste) {
		    super.setName(teste) ;  // Set the initial value for the class attribute x
		  }

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
		System.out.println( this.getName() + " "+ this.getSalary() + " " + this.getType() + "\n");
		// TODO Auto-generated method stub
		
	}

	public int getHoraExtra() {
		return HoraExtra;
	}

	public void setHoraExtra(int horaExtra) {
		HoraExtra = horaExtra;
	}

	public int getHorasTrabalhadas() {
		return HorasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		HorasTrabalhadas = horasTrabalhadas;
	}
	
}
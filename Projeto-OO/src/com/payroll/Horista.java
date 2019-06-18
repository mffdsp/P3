package com.payroll;


import java.util.Calendar;
import java.util.Date;

public class Horista extends Funcionario implements ManageCode, PayRoll{
	
	Calendar c = Calendar.getInstance();
     // Getting the day of the week
 
     
	protected int HoraExtra;
	protected int HorasTrabalhadas;
	
	@Override
	public boolean pagarFuncionario() {
		
		if(c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			System.out.println("PAGO");
			return true;
		}
		return false;
		
		
	}

	@Override
	public int getDtInicial() throws Exception {
		return super.DtInicial;
	}
	

	@Override
	public void incluirDesconto(String hist, float val) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Date getDtFinal() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
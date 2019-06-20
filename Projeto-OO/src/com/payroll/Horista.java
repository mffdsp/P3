package com.payroll;


import java.util.Calendar;
import java.util.Date;

public class Horista extends Funcionario implements PayRoll{
	
	Calendar c = Calendar.getInstance();
     // Getting the day of the week
	protected double SalarioBase = super.getSalary();
	protected int tipo = 1;
	protected int diasTB = 0;
	protected String Pday = "Sexta-Feira";
	protected boolean pago = false;
	
	
	public boolean pagarFuncionario() {
		
		if(tipo == 1) {
			if(diasTB >= 7 && CalendarMT.weekday.equals(Pday)) {
				pago = true;
				return pago;
			}
		}else {
			if(diasTB > 12 && CalendarMT.weekday.equals(Pday)) {
				pago = true;
				return pago;
			}
			
		}
		return pago;
	
	}
	
	public void addSalary(int horas){
		if(horas <= 8) {
			salary += horas * SalarioBase;
		}else {
			salary += 8 * SalarioBase;
			horas -= 8;
			salary += horas * (SalarioBase*1.5);
		}
		
	}
	
	
}
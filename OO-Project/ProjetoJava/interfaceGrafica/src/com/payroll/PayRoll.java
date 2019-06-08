package com.payroll;
import java.util.Date;


public interface PayRoll {
	
	void pagarFuncionario();
	int getDtInicial() throws Exception;
	Date getDtFinal() throws Exception;
	void incluirDesconto (String hist, float val) throws Exception;
}

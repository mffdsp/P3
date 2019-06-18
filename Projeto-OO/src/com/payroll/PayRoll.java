package com.payroll;
import java.util.Date;


public interface PayRoll {
	
	void listarFuncionarios();
	boolean pagarFuncionario();
	int getDtInicial() throws Exception;
	Date getDtFinal() throws Exception;
	void incluirDesconto (String hist, float val) throws Exception;
}

package com.mateus;
import java.util.Date;

public interface payRoll {
	
	void pagarFuncionario();
	int getDtInicial() throws Exception;
	Date getDtFinal() throws Exception;
	void incluirDesconto (String hist, float val) throws Exception;

}

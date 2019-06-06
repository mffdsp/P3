package com.mateus;

import java.util.Date;

public class Horista extends Funcionario{
	
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
}

package br.com.loja.teste;

import org.junit.Test;

import br.com.loja.util.HibernateUtil;

public class GerarTabelasTeste {

	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
	
	
}

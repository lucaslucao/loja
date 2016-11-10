package br.com.loja.main;

import br.com.loja.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		//chamar fabrica de sessao para testar hibernate
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}

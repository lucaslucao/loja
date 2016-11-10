package br.com.loja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.loja.domain.Fabricante;
import br.com.loja.util.HibernateUtil;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit(); // comit para confirmar

		} catch (RuntimeException ex) {
			if (transacao != null) { // != diferente
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}

	}
	@SuppressWarnings("unchecked") //tira warning
	public List<Fabricante>listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Fabricante.listar");// Fabricante.listar, veio do Fabricante.java
			fabricantes = consulta.list();		
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return fabricantes;
	}
	
	public Fabricante buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");// Fabricante.listar, veio do Fabricante.java
			consulta.setLong("codigo", codigo); // da linha 16 do fabricante é o da direita, o da esquerda é a entidade
			
			fabricante = (Fabricante) consulta.uniqueResult();		
		}catch(RuntimeException ex){
			throw ex;
		}finally{
			sessao.close();
		}
		return fabricante;
	}
	
	public void excluir(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete (fabricante);
			transacao.commit(); // comit para confirmar

		} catch (RuntimeException ex) {
			if (transacao != null) { // != diferente
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	//repetir metodo desde que parametros diferentes.
//	public void excluir(Long codigo) { //mesmo do salvar, puxando o delete no lugar do save - linha 71
//		Session sessao = HibernateUtil.getSessionFactory().openSession();
//		Transaction transacao = null;
//
//		try {
//			transacao = sessao.beginTransaction();
//			Fabricante fabricante = buscarPorCodigo(codigo);
//			sessao.delete(fabricante);
//			transacao.commit(); // comit para confirmar
//
//		} catch (RuntimeException ex) {
//			if (transacao != null) { // != diferente
//				transacao.rollback();
//			}
//			throw ex;
//		} finally {
//			sessao.close();
//		}
//	}
	public void editar(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			//descricao antiga -> descricao nova
//			Fabricante fabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
//			fabricanteEditar.setDescricao(fabricante.getDescricao());
//			sessao.update(fabricanteEditar);
			
			sessao.update(fabricante);
			transacao.commit(); // comit para confirmar

		} catch (RuntimeException ex) {
			if (transacao != null) { // != diferente
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
}

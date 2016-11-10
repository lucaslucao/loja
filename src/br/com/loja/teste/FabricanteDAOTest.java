package br.com.loja.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.loja.dao.FabricanteDAO;
import br.com.loja.domain.Fabricante;

public class FabricanteDAOTest {

		@Test
		@Ignore
		public void salvar(){
			Fabricante f1 = new Fabricante();
			f1.setDescricao("PANELA");
			
			Fabricante f2 = new Fabricante();
			f2.setDescricao("LAVADEIRA");
			
			FabricanteDAO dao = new  FabricanteDAO();
			
			dao.salvar(f1);
			dao.salvar(f2);
			
		}
		@Test
		@Ignore
		public void listar(){
			FabricanteDAO dao = new FabricanteDAO();
			List<Fabricante> fabricantes = dao.listar();
		System.out.println(fabricantes);
//		for (Fabricante fabricante : fabricantes){
//			System.out.println(fabricante);
//		}
	}
		@Test
		@Ignore
		public void buscarPorCodigo(){
		 FabricanteDAO dao = new FabricanteDAO();
		
		 Fabricante f1 = dao.buscarPorCodigo(2L); //L de Long
		// Fabricante f2 = dao.buscarPorCodigo(7L);
		
		 System.out.println(f1);
		// System.out.println(f2);
			
		
		}
		@Test
		@Ignore
		public void excluir(){
			
			FabricanteDAO dao = new FabricanteDAO();
			Fabricante fabricante = dao.buscarPorCodigo(3L);
			dao.excluir(fabricante);
			
		// FabricanteDAO dao = new FabricanteDAO();
		// Fabricante fabricante = dao.buscarPorCodigo(2L);
		// if(fabricante!=null){
		// dao.excluir(fabricante);

		// Fabricante fabricante = new Fabricante(); --neste caso se nao
		// preencher tudo ele nao vai encontrar para excluir
		// fabricante.setCodigo(1L);
		// fabricante.setDescricao("DESCRICAOA");
		//
		// FabricanteDAO dao = new FabricanteDAO();
		// dao.excluir(fabricante);
		}
			
	
//		@Test
//		@Ignore
//		public void excluirPorCodigo(){
//			FabricanteDAO dao = new FabricanteDAO();
//		
//			dao.excluir(3L);
//		}
		@Test
		@Ignore
		public void editar(){
			FabricanteDAO dao = new FabricanteDAO();
			Fabricante fabricante = dao.buscarPorCodigo(3L);
			fabricante.setDescricao("MUDANCA");
			dao.editar(fabricante);
			
			
			
//			Fabricante fabricante = new Fabricante();
//			fabricante.setCodigo(1L);
//			fabricante.setDescricao("DESCRICAOX");
//			
//			FabricanteDAO dao = new FabricanteDAO();
//			dao.editar(fabricante);
		}
	
}

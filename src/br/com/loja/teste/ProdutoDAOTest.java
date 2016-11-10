package br.com.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.domain.Fabricante;
import br.com.loja.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar(){
		//pesquisa fabricante, devido fk
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(4L);
		//preenche
		Produto produto = new Produto();
		produto.setDescricao("descricaous");
		produto.setPreco(new BigDecimal(1.55D));
		produto.setQuantidade(11);
		produto.setFabricante(fabricante);
		//grava
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
	}
	
	
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(1L);
		
		System.out.println(produto);
		
	}
	@Test
	@Ignore
	public void listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		List<Produto> produtos = produtoDAO.listar();
		
		System.out.println(produtos);
	}
	@Test
	@Ignore
	public void excluir(){
		ProdutoDAO produtoDAO =  new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(2L); //se n tive no bco vai da erro
		
		produtoDAO.excluir(produto);
		
		
	}
	@Test
	@Ignore
	public void editar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscarPorCodigo(1L);
		produto.setDescricao("vejacomomudou");
		produto.setPreco(new BigDecimal(1.99D));
		produto.setQuantidade(6);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(1L);
		produto.setFabricante(fabricante);
		
		produtoDAO.editar(produto);
		/* caso queira mudar apenas alguma informacao em espefico,
		só setar oque vc quer mudar, resto fica igual*/
	}
	
}

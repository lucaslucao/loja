package br.com.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.ItemDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.dao.VendaDAO;
import br.com.loja.domain.Item;
import br.com.loja.domain.Produto;
import br.com.loja.domain.Venda;

public class ItemDAOTest {
	@Test
	@Ignore
	public void salvar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(1L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);
		
		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(9);
		item.setValor(new BigDecimal(100.00D));
		item.setVenda(venda);
		
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);
		
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		ItemDAO itemDAO = new ItemDAO();
		
		Item item = itemDAO.buscarPorCodigo(1L);
		
		System.out.println(item);
		
	}
	@Test
	@Ignore
	public void listar(){
		ItemDAO itemDAO = new ItemDAO();
		
		List<Item> produtos = itemDAO.listar();
		
		System.out.println(produtos);
	}
	@Test
	@Ignore
	public void excluir(){
		ItemDAO itemDAO = new ItemDAO();
		
		Item item = itemDAO.buscarPorCodigo(2L); //se n tive no bco vai da erro
		
		itemDAO.excluir(item);
		
		
	}
	@Test
	//@Ignore
	public void editar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(1L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);
		
		ItemDAO itemDAO = new ItemDAO();
		
		Item item = itemDAO.buscarPorCodigo(1L);
		
		item.setProduto(produto);
		item.setQuantidade(8);
		item.setValor(new BigDecimal(90.00D));
		item.setVenda(venda);
		
		
		itemDAO.editar(item);
	}
}

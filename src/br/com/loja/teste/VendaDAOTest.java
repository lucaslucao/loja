package br.com.loja.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Venda;
import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.dao.VendaDAO;

public class VendaDAOTest {
	@Test
	@Ignore
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);

		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(99.90D));

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);

	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();

		List<Venda> vendas = vendaDAO.listar();

		System.out.println(vendas);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendaDAO vendaDAO = new VendaDAO();

		Venda venda = vendaDAO.buscarPorCodigo(2L);
		System.out.println(venda);

	}

	public void exlcui() {
		VendaDAO vendaDAO = new VendaDAO();

		Venda venda = vendaDAO.buscarPorCodigo(2L);
	    vendaDAO.excluir(venda);
	    
	}
	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);
		
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(29.90D));
		venda.setFuncionario(funcionario);	
		
		vendaDAO.editar(venda);

	}
	
}

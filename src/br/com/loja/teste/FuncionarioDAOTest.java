package br.com.loja.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.domain.Funcionario;

public class FuncionarioDAOTest {
	@Test
	
	public void salvar() {
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("123.123.321-55");
		funcionario.setFuncao("Tecnico");
		funcionario.setNome("Roberto Sabino");
		funcionario.setSenha("123456");

		FuncionarioDAO dao = new FuncionarioDAO();
		dao.salvar(funcionario);
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		System.out.println(funcionarios);
	}

	@Test
	
	public void buscarPorCodigo() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(3L);
		System.out.println(funcionario);

	}

	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(3L);
		dao.excluir(funcionario);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(3L);
		funcionario.setCpf("666.666.666-55");
		funcionario.setFuncao("USUARIO");
		funcionario.setNome("JOSE BOND");
		funcionario.setSenha("123321");

		dao.editar(funcionario);

	}

}

package br.com.loja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.domain.Funcionario;
import br.com.loja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	private Funcionario funcionarioCadastro;
	private List<Funcionario> listaFuncionario;
	private List<Funcionario> listaFuncionarioFiltrados;
	
	private String acao;
	//private Long codigo;

	public Funcionario getFuncionarioCadastro() {
		if (funcionarioCadastro == null) {
			funcionarioCadastro = new Funcionario();
		}
		return funcionarioCadastro;
	}

	public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionarios(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public List<Funcionario> getListaFuncionarioFiltrados() {
		return listaFuncionarioFiltrados;
	}

	public void setListaFuncionarioFiltrados(List<Funcionario> listaFuncionarioFiltrados) {
		this.listaFuncionarioFiltrados = listaFuncionarioFiltrados;
	}
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

//	public Long getCodigo() {
//		return codigo;
//	}

//	public void setCodigo(Long codigo) {
//		this.codigo = codigo;
//	}

	public void novo() {
		funcionarioCadastro = new Funcionario();
	}

	public void salvar() {

		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.salvar(funcionarioCadastro);

			funcionarioCadastro = new Funcionario();

			FacesUtil.adicionarMsgInfo("Funcionario salvo com sucesso");
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao incluir funcionario: " + ex.getMessage());

		}
	}

	public void carregarPesquisa() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			listaFuncionario = funcionarioDAO.listar();
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao listar Funcionarios: " + ex.getMessage());

		}
	}

	public void carregarCadastro() {
		try {
			String valor = FacesUtil.getParam("funcod");
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				funcionarioCadastro = funcionarioDAO.buscarPorCodigo(codigo);

			}else{
				funcionarioCadastro = new Funcionario();
			}
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao obter funcionario: " + ex.getMessage());

		}
	}

	public void excluir() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionarioCadastro);

			FacesUtil.adicionarMsgInfo("Funcionario salvo com sucesso");
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao incluir funcionario: " + ex.getMessage());

		}
	}
	
	public void editar() {

		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionarioCadastro);

			funcionarioCadastro = new Funcionario();

			FacesUtil.adicionarMsgInfo("Funcionario editado com sucesso");
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao editar funcionario: " + ex.getMessage());

		}
	}

	
}

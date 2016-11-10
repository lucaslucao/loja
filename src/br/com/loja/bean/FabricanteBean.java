package br.com.loja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.domain.Fabricante;
import br.com.loja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricanteCadastro;
	private List<Fabricante> listaFabricantes;
	private List<Fabricante> listaFabricantesFiltrados;

	public Fabricante getFabricanteCadastro() {
		if (fabricanteCadastro == null) {
			fabricanteCadastro = new Fabricante();
		}
		return fabricanteCadastro;
	}

	public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
		this.fabricanteCadastro = fabricanteCadastro;
	}

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public List<Fabricante> getListaFabricantesFiltrados() {
		return listaFabricantesFiltrados;
	}

	public void setListaFabricantesFiltrados(List<Fabricante> listaFabricantesFiltrados) {
		this.listaFabricantesFiltrados = listaFabricantesFiltrados;
	}

	public void novo() {
		fabricanteCadastro = new Fabricante();
	}

	public void salvar() {

		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricanteCadastro);

			fabricanteCadastro = new Fabricante();

			FacesUtil.adicionarMsgInfo("Fabricante salvo com sucesso");
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao incluir fabricante: " + ex.getMessage());

		}
	}

	public void carregarPesquisa() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricantes = fabricanteDAO.listar();
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao listar fabricante: " + ex.getMessage());

		}
	}

	public void carregarCadastro() {
		try {
			String valor = FacesUtil.getParam("fabcod");
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				fabricanteCadastro = fabricanteDAO.buscarPorCodigo(codigo);

			}
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao obter fabricante: " + ex.getMessage());

		}
	}

	public void excluir() {

		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();					
			fabricanteDAO.excluir(fabricanteCadastro);
		
			FacesUtil.adicionarMsgInfo("Fabricante excluido com sucesso");
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao excluir fabricante: " + ex.getMessage());

		}
	}
	
	public void editar() {

		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.editar(fabricanteCadastro);

			fabricanteCadastro = new Fabricante();

			FacesUtil.adicionarMsgInfo("Fabricante editado com sucesso");
		} catch (RuntimeException ex) {

			FacesUtil.adicionarMsgError("Erro ao editar fabricante: " + ex.getMessage());

		}
	}
}

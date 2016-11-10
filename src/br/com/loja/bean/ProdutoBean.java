	package br.com.loja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.domain.Fabricante;
import br.com.loja.domain.Produto;
import br.com.loja.util.FacesUtil;

	@ManagedBean
	@ViewScoped
	public class ProdutoBean {
		private Produto produtoCadastro;
		private List<Produto> listaProduto;
		private List<Produto> listaProdutoFiltrados;
		
		private String acao;
		private Long codigo;
		
		private List<Fabricante> listaFabricantes;


		public Produto getProdutoCadastro() {
			if (produtoCadastro == null) {
				produtoCadastro = new Produto();
			}
			
			return produtoCadastro;
		}

		public void setProdutoCadastro(Produto produtoCadastro) {
			this.produtoCadastro = produtoCadastro;
		}

		public List<Produto> getListaProduto() {
			return listaProduto;
		}

		public void setListaProduto(List<Produto> listaProduto) {
			this.listaProduto = listaProduto;
		}

		public List<Produto> getListaProdutoFiltrados() {
			return listaProdutoFiltrados;
		}

		public void setListaProdutoFiltrados(List<Produto> listaProdutoFiltrados) {
			this.listaProdutoFiltrados = listaProdutoFiltrados;
		}

		public String getAcao() {
			return acao;
		}

		public void setAcao(String acao) {
			this.acao = acao;
		}

		public Long getCodigo() {
			return codigo;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		
		public List<Fabricante> getListaFabricantes() {
			return listaFabricantes;
		}
		
		public void setListaFabricantes(List<Fabricante> listaFabricantes) {
			this.listaFabricantes = listaFabricantes;
		}
		
		public void novo() {
			produtoCadastro = new Produto();
		}

		public void salvar() {

			try {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoDAO.salvar(produtoCadastro);

				produtoCadastro = new Produto();

				FacesUtil.adicionarMsgInfo("Produto adicionado com sucesso");
			} catch (RuntimeException ex) {

				FacesUtil.adicionarMsgError("Erro ao adicionar produto " + ex.getMessage());

			}
		}

		public void carregarPesquisa() {
			try {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				listaProduto = produtoDAO.listar();
			} catch (RuntimeException ex) {

				FacesUtil.adicionarMsgError("Erro ao listar produtos: " + ex.getMessage());

			}
		}

		public void carregarCadastro() {
			try {
			//	String valor = FacesUtil.getParam("procod");
				if (codigo != null) {
					//Long codigo = Long.parseLong(valor);
					ProdutoDAO produtoDAO = new ProdutoDAO();
					produtoCadastro = produtoDAO.buscarPorCodigo(codigo);

				}else{
					produtoCadastro = new Produto();
				}
				
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				listaFabricantes = fabricanteDAO.listar();
			} catch (RuntimeException ex) {

				FacesUtil.adicionarMsgError("Erro ao obter produto: " + ex.getMessage());

			}
		}

		public void excluir() {
			try {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoDAO.excluir(produtoCadastro);

				FacesUtil.adicionarMsgInfo("Produto salvo com sucesso");
			} catch (RuntimeException ex) {

				FacesUtil.adicionarMsgError("Erro ao incluir produto: " + ex.getMessage());

			}
		}
		
		public void editar() {

			try {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoDAO.excluir(produtoCadastro);

				produtoCadastro = new Produto();

				FacesUtil.adicionarMsgInfo("Produto editado com sucesso");
			} catch (RuntimeException ex) {

				FacesUtil.adicionarMsgError("Erro ao editar produto: " + ex.getMessage());

			}
		}
}

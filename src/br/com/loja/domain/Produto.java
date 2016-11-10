package br.com.loja.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_produtos")
@NamedQueries({
	@NamedQuery(name="Produto.listar", query="SELECT produto FROM Produto produto"),
	@NamedQuery(name="Produto.buscarPorCodigo", query="SELECT produto FROM Produto produto WHERE codigo = :codigo")//:codigo - valor do usuario	
})
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_codigo")
	private long codigo;
	
	@NotEmpty(message="Campo descrição é obrigatorio")
	@Size(min=2, max=30, message="tamanho invalido. (2-30)")
	@Column(name = "pro_descricao", length = 50, nullable = false)
	private String descricao;

	@NotNull(message="campo preco é obrigatorio")
	@DecimalMin(value="0.0", message="valor invalido")
	@DecimalMax(value="99999.99",message="valor invalido, campo estourado")
	@Column(name = "pro_preco", precision = 7, scale = 2, nullable = false) /* 7digitos 2 dps da virgula */																		
	private BigDecimal preco;

	@Column(name = "pro_quantidade", nullable = false)
	private Integer quantidade;

	// chave estrangeira
	@NotNull(message="campo fabricantes é obgatorio")
	@ManyToOne(fetch = FetchType.EAGER) // carregar fabricantes juntos	
	@JoinColumn(name = "tbl_fabricantes_fab_codigo", referencedColumnName = "fab_codigo", nullable = false)
	private Fabricante fabricante;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
				+ quantidade + ", fabricante=" + fabricante + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}

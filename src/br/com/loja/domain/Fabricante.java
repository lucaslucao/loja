package br.com.loja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fabricantes") // ->nome tabela, entidade ligada a tabela
@NamedQueries({
	@NamedQuery(name="Fabricante.listar",query="SELECT fabricante FROM Fabricante fabricante"),//	abre fecha chaves, como se fosse vetor
    @NamedQuery(name="Fabricante.buscarPorCodigo", query = "SELECT fabricante FROM Fabricante fabricante WHERE fabricante.codigo=:codigo")
 })

public class Fabricante {
	@Id // pk
	@GeneratedValue(strategy = GenerationType.AUTO) // autoincrement
	@Column(name = "fab_codigo")
	private Long codigo;

	@Column(name = "fab_descricao", length = 50, nullable = false) // nome,tamanho,pode
																	// ser nulo
																	// ou nao
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Fabricante other = (Fabricante) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

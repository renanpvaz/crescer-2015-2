package br.com.cwi.crescer.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = Produto.SEQUENCE_NAME, sequenceName = Produto.SEQUENCE_NAME)
public class Produto {
	
	protected final static String SEQUENCE_NAME = "seq_produto";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDProduto")
	private Long idProduto;
	
	@Column(name = "IDServico")
	@Basic(optional = false)
	private Long idServico;
	
	@Column(name = "IDMaterial")
	@Basic(optional = false)
	private Long idMaterial;
	
	@Column(name = "Valor", precision = 12, scale = 2)
	@Basic(optional = false)
	private BigDecimal valor;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	
}

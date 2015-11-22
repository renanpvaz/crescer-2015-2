package br.com.cwi.crescer.domain;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Pedido")
@SequenceGenerator(name = Pedido.SEQUENCE_NAME, sequenceName = Pedido.SEQUENCE_NAME)
public class Pedido {

	public static final String SEQUENCE_NAME = "seq_pedido";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IdPedido")
	private Long idPedido;
	
	@Column(name = "IdCliente")
	@Basic(optional = false)
	private Long idCliente;
	
	@Column(name = "DataInclusao")
	@Basic(optional = false)
	private Date dataInclusao;
	
	@Column(name = "DataEntrega")
	private Date dataEntrega;
	
	@Column(name = "Valor", precision = 12, scale = 2)
	@Basic(optional = false)
	private Double valor;

	@Column(name = "Situacao")
	private Character situacao;
	
	/* IDPedido INTEGER NOT NULL,
     * IDCliente INTEGER NOT NULL,
     * DataInclusao DATE NOT NULL,
     * DataEntrega DATE,
     * Valor NUMBER(12,2) NOT NULL,
     * Situacao VARCHAR2(1),
	 */

}

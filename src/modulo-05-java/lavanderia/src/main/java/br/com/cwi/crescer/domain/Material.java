package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Material")
@SequenceGenerator(name = Material.SEQUENCE_NAME, sequenceName = Material.SEQUENCE_NAME, allocationSize = 1)
public class Material {

    public static final String SEQUENCE_NAME = "SEQ_Material";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "IDMaterial")
    private Long idMaterial;

    @Column(name = "Descricao", length = 30)
    @Basic(optional = false)
    private String descricao;

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

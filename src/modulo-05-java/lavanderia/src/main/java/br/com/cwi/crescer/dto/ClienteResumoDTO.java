package br.com.cwi.crescer.dto;

import br.com.cwi.crescer.domain.Cliente;

public class ClienteResumoDTO {

    private String nome;
    private String cpf;
    private String email;
    private Long id;
    private String situacao;

    public ClienteResumoDTO() {
    }

    public ClienteResumoDTO(Long id, String nome, String cpf, String email, String situacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.situacao = situacao;
    }

    public ClienteResumoDTO(Cliente entity) {
        id = entity.getIdCliente();
        nome = entity.getNome();
        cpf = entity.getCpf();
        email = entity.getEmail();
        situacao = entity.getSituacao().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
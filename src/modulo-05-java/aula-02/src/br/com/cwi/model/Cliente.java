package br.com.cwi.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Long idCliente;

    private String nmCliente;

    private String nrCpf;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public List<Object> getAttributes() {
        List<Object> lista = new ArrayList<Object>();

        lista.add(this.idCliente);
        lista.add(this.nmCliente);
        lista.add(this.nrCpf);

        return lista;
    }

    public boolean equals(Cliente cliente) {
        return this.idCliente.toString() == cliente.idCliente.toString() &&
                this.nmCliente == cliente.nmCliente &&
                this.nrCpf == cliente.nrCpf;
    }

    @Override
    public String toString() {

        return this.idCliente.toString() + " "
                + this.nmCliente + " "
                + this.nrCpf;
    }

}

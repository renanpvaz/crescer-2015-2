package br.com.cwi.model;


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

    @Override
    public String toString() {

        return this.idCliente.toString() + " "
                + this.nmCliente + " "
                + this.nrCpf;
    }

}

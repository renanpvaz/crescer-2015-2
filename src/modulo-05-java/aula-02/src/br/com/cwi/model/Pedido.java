package br.com.cwi.model;


public class Pedido {

    private Long idPedido;

    private String dsPedido;

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getIdCliente() {
        return this.cliente.getIdCliente();
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDsPedido() {
        return dsPedido;
    }

    public void setDsPedido(String dsPedido) {
        this.dsPedido = dsPedido;
    }

    @Override
    public boolean equals(Object obj) {
        Pedido pedido = (Pedido) obj;

        return this.idPedido.equals(pedido.idPedido) &&
                this.dsPedido.equals(pedido.dsPedido) &&
                this.cliente.equals(pedido.cliente);
    }
}

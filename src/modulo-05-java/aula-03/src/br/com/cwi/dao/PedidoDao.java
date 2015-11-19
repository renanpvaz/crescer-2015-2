package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Cliente;
import br.com.cwi.model.Pedido;

public class PedidoDao {

    public Pedido load(Long idPedido) throws SQLException {

        Pedido pedido;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("select p.idPedido, p.dsPedido, c.idCliente, c.nmCliente, c.nrCpf "
                    + "from pedido p join cliente c on p.idCliente = c.idCliente where p.idPedido = ?");

            statement.setLong(1, idPedido);

            ResultSet result = statement.executeQuery();

            pedido = new Pedido();
            Cliente cliente = new Cliente();

            if (result.next()) {

                cliente.setIdCliente(result.getLong(3));
                cliente.setNmCliente(result.getString(4));
                cliente.setNrCpf(result.getString(5));

                pedido.setIdPedido(result.getLong(1));
                pedido.setDsPedido(result.getString(2));
                pedido.setCliente(cliente);

            } else {

                throw new RuntimeException("Registro não encontrado");
            }

        } catch (SQLException e) {
            throw e;
        }
        return pedido;
    }
    
    public int add(Pedido pedido) throws Exception {

        int affectedRows;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("insert into pedido (idPedido, dsPedido, idCliente) values (?, ?, ?)");

            statement.setLong(1, pedido.getIdPedido());
            statement.setString(2, pedido.getDsPedido());
            statement.setLong(3, pedido.getIdCliente());

            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
        return affectedRows;
    }

}

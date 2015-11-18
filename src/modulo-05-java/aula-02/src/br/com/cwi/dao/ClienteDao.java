package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Cliente;

public class ClienteDao {

    public Cliente load(Long idCliente) throws SQLException {

        Cliente cliente;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("select * from cliente where id = ?");

            statement.setLong(1, idCliente);

            ResultSet result = statement.executeQuery();

            cliente = new Cliente();

            if (result.next()) {

                cliente.setIdCliente(result.getLong(1));
                cliente.setNmCliente(result.getString(2));
                cliente.setNrCpf(result.getString(3));
            } else {

                throw new RuntimeException("Registro não encontrado");
            }

        } catch (SQLException e) {
            throw e;
        }
        return cliente;
    }

    public int add(Cliente cliente) throws Exception {

        int affectedRows;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("insert into cliente (idCliente, nmCliente, nrCpf) values (?, ?, ?)");

            statement.setLong(1, cliente.getIdCliente());
            statement.setString(2, cliente.getNmCliente());
            statement.setString(3, cliente.getNrCpf());

            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
        return affectedRows;
    }

    public List<Cliente> listAll() throws Exception {

        List<Cliente> clientes = new ArrayList<Cliente>();

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("select * from cliente");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Cliente cliente = new Cliente();

                cliente.setIdCliente(result.getLong(1));
                cliente.setNmCliente(result.getString(2));
                cliente.setNrCpf(result.getString(3));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            throw e;
        }
        return clientes;
    }

    public int delete(long idCliente) throws SQLException {

        int affectedRows;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("delete from cliente where idCliente = ?");

            statement.setLong(1, idCliente);

            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
        return affectedRows;
    }

    public int update(Cliente cliente) throws SQLException {

        int affectedRows;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("update cliente set nmCliente = ?, nrCpf = ? where idCliente = ?");

            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.setLong(3, cliente.getIdCliente());

            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
        return affectedRows;
    }

}

package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Servico;

public class ServicoDao {

    public Servico load(Long idServico) throws SQLException {

        Servico servico;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("select * from servico where id = ?");

            statement.setLong(1, idServico);

            ResultSet result = statement.executeQuery();

            servico = new Servico();

            if (result.next()) {

                servico.setIdServico(result.getLong(1));
                servico.setDsServico(result.getString(2));
            } else {

                throw new RuntimeException("Registro não encontrado");
            }

        } catch (SQLException e) {
            throw e;
        }
        return servico;
    }

    public int adicionar(Servico servico) throws Exception {

        int affectedRows;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("insert into servico (idServico, dsServico) values (?, ?)");

            statement.setLong(1, servico.getIdServico());
            statement.setString(2, servico.getDsServico());

            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
        return affectedRows;
    }

    public List<Servico> listAll() throws Exception {

        List<Servico> servicos = new ArrayList<Servico>();

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("select * from servico");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Servico servico = new Servico();

                servico.setIdServico(result.getLong(1));
                servico.setDsServico(result.getString(2));

                servicos.add(servico);
            }

        } catch (SQLException e) {
            throw e;
        }
        return servicos;
    }

    public int delete(long idServico) throws SQLException {

        int affectedRows;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("delete from servico where idServico = ?");

            statement.setLong(1, idServico);

            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
        return affectedRows;
    }

    public int update(Servico servico) throws SQLException {

        int affectedRows;

        try (Connection conexao = new ConnectionFactory().getConnection();) {

            PreparedStatement statement = conexao.prepareStatement("update servico set dsServico = ? where idServico = ?");

            statement.setString(2, servico.getDsServico());
            statement.setLong(1, servico.getIdServico());

            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
        return affectedRows;
    }

}

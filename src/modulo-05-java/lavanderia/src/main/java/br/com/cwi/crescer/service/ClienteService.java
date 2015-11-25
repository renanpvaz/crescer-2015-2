package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.ClienteResumoDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {

    private ClienteDAO clienteDAO;
    private CidadeDAO cidadeDAO;

    @Autowired
    public ClienteService(ClienteDAO clienteDAO, CidadeDAO cidadeDAO) {
        this.clienteDAO = clienteDAO;
        this.cidadeDAO = cidadeDAO;
    }

    public ClienteDTO buscarPorId(Long id) {
        return ClienteMapper.toDTO(clienteDAO.findById(id));
    }

    public void incluir(ClienteDTO dto) {

        Cliente cliente = ClienteMapper.getNewEntity(dto);

        cliente.setSituacao(SituacaoCliente.ATIVO);

        clienteDAO.save(cliente);
    }

    public List<ClienteResumoDTO> listarClientesAtivos() {

        List<Cliente> clientes = clienteDAO.findBySituacao(SituacaoCliente.ATIVO);

        List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(new ClienteResumoDTO(cliente));
        }

        return dtos;
    }

    public void atualizar(ClienteDTO dto) {
        Cliente entity = clienteDAO.findById(dto.getId());

        ClienteMapper.merge(dto, entity);

        entity.setCidade(cidadeDAO.findById(dto.getIdCidade()));

        clienteDAO.save(entity);
    }

    public void remover(Long id) {
        Cliente entity = clienteDAO.findById(id);

        entity.setSituacao(SituacaoCliente.INATIVO);

        clienteDAO.save(entity);
    }
}

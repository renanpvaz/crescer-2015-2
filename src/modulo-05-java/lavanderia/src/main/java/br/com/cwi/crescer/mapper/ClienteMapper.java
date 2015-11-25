package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.dto.ClienteDTO;

public class ClienteMapper {

    public static Cliente getNewEntity(ClienteDTO dto) {
        Cidade cidade = new Cidade();

        cidade.setIdCidade(dto.getIdCidade());

        return new Cliente(dto.getNome(),
                dto.getCpf(),
                dto.getEmail(),
                dto.getEndereco(),
                dto.getBairro(),
                cidade,
                dto.getCep());
    }

    public static ClienteDTO toDTO(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getIdCliente());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setIdCidade(entity.getCidade().getIdCidade());
        return dto;
    }

    public static Cliente merge(ClienteDTO dto, Cliente entity) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        return entity;
    }

}

package com.example.CadastroDeClientes.Clientes;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteModel map(ClienteDTO clienteDTO){
        ClienteModel clienteModel = new ClienteModel();

        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setEmail(clienteDTO.getEmail());
        clienteModel.setIdade(clienteDTO.getIdade());
        clienteModel.setImgUrl(clienteDTO.getImgUrl());
        clienteModel.setTipo_assinatura(clienteDTO.getTipo_assinatura());
        clienteModel.setPedidos(clienteDTO.getPedidos());

        return clienteModel;
    }

    public ClienteDTO map(ClienteModel clienteModel){

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setEmail(clienteModel.getEmail());
        clienteDTO.setIdade(clienteModel.getIdade());
        clienteDTO.setImgUrl(clienteModel.getImgUrl());
        clienteDTO.setTipo_assinatura(clienteModel.getTipo_assinatura());
        clienteDTO.setPedidos(clienteModel.getPedidos());

        return clienteDTO;

    }
}
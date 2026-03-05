package com.example.CadastroDeClientes.Pedidos;

import com.example.CadastroDeClientes.Clientes.ClienteModel;
import org.springframework.stereotype.Component;

@Component
public class PedidosMapper {

    public PedidosModel map(PedidosDTO dto) {
        PedidosModel model = new PedidosModel();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setStatusPagamento(dto.getStatusPagamento());

        if (dto.getClienteId() != null) {
            ClienteModel cliente = new ClienteModel();
            cliente.setId(dto.getClienteId());
            model.setCliente(cliente);
        }
        return model;
    }

    public PedidosDTO map(PedidosModel model) {
        PedidosDTO dto = new PedidosDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setStatusPagamento(model.getStatusPagamento());

        if (model.getCliente() != null) {
            dto.setClienteId(model.getCliente().getId());
        }
        return dto;
    }
}
package com.example.CadastroDeClientes.Pedidos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidosDTO {
    private Long id;
    private String nome;
    private String statusPagamento;
    private Long clienteId;
}
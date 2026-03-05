package com.example.CadastroDeClientes.Clientes;

import com.example.CadastroDeClientes.Pedidos.PedidosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDTO {


    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private String tipo_assinatura;
    private java.util.List<com.example.CadastroDeClientes.Pedidos.PedidosModel> pedidos;

}

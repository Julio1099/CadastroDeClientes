package com.example.CadastroDeClientes.Pedidos;

import com.example.CadastroDeClientes.Clientes.ClienteModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_pedidos")
public class PedidosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String statusPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;



}

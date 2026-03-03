package com.example.CadastroDeClientes.Pedidos;

import com.example.CadastroDeClientes.Clientes.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

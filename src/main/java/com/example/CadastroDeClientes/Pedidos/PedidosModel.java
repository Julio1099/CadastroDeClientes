package com.example.CadastroDeClientes.Pedidos;

import com.example.CadastroDeClientes.Clientes.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PedidosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "statusPagamento")
    private String statusPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;



}

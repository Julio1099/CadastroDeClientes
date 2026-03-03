package com.example.CadastroDeClientes.Clientes;

import java.util.List;
import com.example.CadastroDeClientes.Pedidos.PedidosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<PedidosModel> pedidos;

}

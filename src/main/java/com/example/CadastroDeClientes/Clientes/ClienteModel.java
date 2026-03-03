package com.example.CadastroDeClientes.Clientes;

import java.util.List;
import com.example.CadastroDeClientes.Pedidos.PedidosModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<PedidosModel> pedidos;

    public ClienteModel() {
    }

    public ClienteModel(String email, String nome, int idade) {
        this.email = email;
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}

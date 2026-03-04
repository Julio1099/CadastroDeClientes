package com.example.CadastroDeClientes.Clientes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClienteController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }


    @PostMapping("/Criar")
    public String criarCliente(){
        return "Cliente criado";
    }

    @GetMapping("/Todos")
    public String mostraTodosOsClientes(){
        return "Mostrar Cliente";
    }

    @GetMapping("/TodosID")
    public String mostraTodosOsClientesPorId(){
        return "Mostrar Cliente por id";
    }

    @PutMapping("/AlterarID")
    public String alterarClientePorId(){
        return "Alterar Cliente por id";
    }

    @DeleteMapping("/deletarID")
    public String deletarClientePorId(){
        return "Cliente deletado por id";
    }

}

package com.example.CadastroDeClientes.Clientes;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    public String criarCliente(){
        return "Cliente criado";
    }

    @GetMapping("/listar")
    public List<ClienteModel> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/todosID")
    public String mostraTodosOsClientesPorId(){
        return "Mostrar Cliente por id";
    }

    @PutMapping("/alterarID")
    public String alterarClientePorId(){
        return "Alterar Cliente por id";
    }

    @DeleteMapping("/deletarID")
    public String deletarClientePorId(){
        return "Cliente deletado por id";
    }

}

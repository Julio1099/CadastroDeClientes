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
    public ClienteModel criarCliente(@RequestBody ClienteModel cliente){
        return clienteService.cirarCliente(cliente);
    }

    @GetMapping("/listar")
    public List<ClienteModel> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/listar/{id}")
    public ClienteModel listarClientePorId(@PathVariable Long id) {
        return clienteService.listarClientesPorId(id);
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

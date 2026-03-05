package com.example.CadastroDeClientes.Clientes;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO cliente){
        ClienteDTO novoCliente = clienteService.cirarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cliente criado com sucesso: " + novoCliente.getNome() + " (ID): " + novoCliente.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ClienteDTO> listarClientePorId(@PathVariable Long id) {
        ClienteDTO cliente = clienteService.listarClientesPorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<ClienteDTO> alterarClientePorId(@PathVariable Long id, @RequestBody ClienteDTO clienteAtualizado) {
        ClienteDTO atualizado = clienteService.atualizarCliente(id, clienteAtualizado);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarClientePorId(@PathVariable Long id){
        if (clienteService.listarClientesPorId(id) != null){
            clienteService.deletarClientePorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + "deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID " + id + "não foi encontrado");
        }
    }

}

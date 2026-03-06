package com.example.CadastroDeClientes.Clientes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/boasVindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo cliente", description = "Rota cria um novo cliente e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criaçao do cliente")
    })
    public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO cliente){
        ClienteDTO novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cliente criado com sucesso: " + novoCliente.getNome() + " (ID): " + novoCliente.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o cliente por Id", description = "Rota lista um Cliente pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente nao encontrado")
    })
    public ResponseEntity<ClienteDTO> listarClientePorId(@PathVariable Long id) {
        ClienteDTO cliente = clienteService.listarClientesPorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o cliente por Id", description = "Rota altera um cliente pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado, não foi possível alterar")
    })
    public ResponseEntity<?> alterarClientePorId(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do cliente a ser atualizado no corpo da requisição")
            @RequestBody ClienteDTO clienteAtualizado) {

        ClienteDTO cliente = clienteService.atualizarCliente(id, clienteAtualizado);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com o id: " + id + " não existe nos nossos registros");
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

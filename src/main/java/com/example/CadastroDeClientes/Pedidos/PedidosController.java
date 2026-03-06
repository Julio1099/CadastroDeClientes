package com.example.CadastroDeClientes.Pedidos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private final PedidosService pedidosService;

    public PedidosController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todos os pedidos", description = "Retorna uma lista de todos os pedidos cadastrados em formato DTO")
    public ResponseEntity<List<PedidosDTO>> listarPedidos() {
        List<PedidosDTO> pedidos = pedidosService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Buscar pedido por ID", description = "Retorna os detalhes de um pedido específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    public ResponseEntity<PedidosDTO> buscarPorId(@PathVariable Long id) {
        PedidosDTO pedido = pedidosService.buscarPorId(id);
        return pedido != null ? ResponseEntity.ok(pedido) : ResponseEntity.notFound().build();
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar novo pedido", description = "Cria um pedido e o vincula a um cliente via clienteId")
    public ResponseEntity<String> criarPedido(@RequestBody PedidosDTO pedidoDTO) {
        PedidosDTO novoPedido = pedidosService.criarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pedido criado com sucesso! ID: " + novoPedido.getId());
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Atualizar pedido", description = "Altera os dados de um pedido existente")
    public ResponseEntity<?> alterarPedido(@PathVariable Long id, @RequestBody PedidosDTO pedidoAtualizadoDTO) {
        PedidosDTO pedido = pedidosService.atualizarPedido(id, pedidoAtualizadoDTO);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido com ID " + id + " não encontrado para alteração.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar pedido", description = "Remove um pedido permanentemente do banco de dados")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id) {
        if (pedidosService.buscarPorId(id) != null) {
            pedidosService.deletarPedido(id);
            return ResponseEntity.ok("Pedido com ID " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi possível deletar: Pedido ID " + id + " não encontrado.");
        }
    }
}
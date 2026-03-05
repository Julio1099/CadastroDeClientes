package com.example.CadastroDeClientes.Pedidos;

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
    public ResponseEntity<List<PedidosDTO>> listarPedidos() {
        List<PedidosDTO> pedidos = pedidosService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<PedidosDTO> buscarPorId(@PathVariable Long id) {
        PedidosDTO pedido = pedidosService.buscarPorId(id);
        return pedido != null ? ResponseEntity.ok(pedido) : ResponseEntity.notFound().build();
    }

    @PostMapping("/criar")
    public ResponseEntity<PedidosDTO> criarPedido(@RequestBody PedidosDTO pedidoDTO) {
        PedidosDTO novoPedido = pedidosService.criarPedido(pedidoDTO);
        return ResponseEntity.ok(novoPedido);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<PedidosDTO> alterarPedido(@PathVariable Long id, @RequestBody PedidosDTO pedidoAtualizadoDTO) {
        PedidosDTO pedidoAlterado = pedidosService.atualizarPedido(id, pedidoAtualizadoDTO);
        return pedidoAlterado != null ? ResponseEntity.ok(pedidoAlterado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidosService.deletarPedido(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
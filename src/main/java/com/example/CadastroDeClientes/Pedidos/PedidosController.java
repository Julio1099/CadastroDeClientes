package com.example.CadastroDeClientes.Pedidos;

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
    public List<PedidosModel> listarPedidos() {
        return pedidosService.listarPedidos();
    }

    @GetMapping("/listar/{id}") // Mudando para listar/id para seguir o padrão de clientes
    public PedidosModel buscarPorId(@PathVariable Long id) {
        return pedidosService.buscarPorId(id).orElse(null);
    }

    @PostMapping("/criar")
    public PedidosModel criarPedido(@RequestBody PedidosModel pedido) {
        return pedidosService.criarPedido(pedido);
    }

    // NOVO MÉTODO: Rota para atualizar
    @PutMapping("/alterar/{id}")
    public PedidosModel alterarPedido(@PathVariable Long id, @RequestBody PedidosModel pedidoAtualizado) {
        return pedidosService.atualizarPedido(id, pedidoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidosService.deletarPedido(id);
    }
}
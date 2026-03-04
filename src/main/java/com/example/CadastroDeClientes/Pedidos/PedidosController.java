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

    @PostMapping("/criar")
    public PedidosModel criarPedido(@RequestBody PedidosModel pedido) {
        return pedidosService.criarPedido(pedido);
    }

    @GetMapping("/detalhes/{id}")
    public PedidosModel buscarPorId(@PathVariable Long id) {
        return pedidosService.buscarPorId(id).orElse(null);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarPedido(@PathVariable Long id) {
        pedidosService.deletarPedido(id);
        return "Pedido " + id + " deletado com sucesso";
    }
}
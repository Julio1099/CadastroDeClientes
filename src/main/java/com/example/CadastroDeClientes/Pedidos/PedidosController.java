package com.example.CadastroDeClientes.Pedidos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
public class PedidosController {

    @GetMapping("/listar")
    public String listarPedido(){
        return "Pedido listada com sucesso";
    }

    @PostMapping("/criar")
    public String criarPedido(){
        return "Pedido criado com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarPedido(){
        return "Pedido alterado com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarPedido(){
        return "Pedido deletado com sucesso";
    }

}

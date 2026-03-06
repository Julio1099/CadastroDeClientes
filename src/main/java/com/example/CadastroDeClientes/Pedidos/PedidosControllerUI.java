package com.example.CadastroDeClientes.Pedidos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pedidos/ui")
public class PedidosControllerUI {

    private final PedidosService pedidosService;

    public PedidosControllerUI(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @GetMapping("/listar")
    public String listarPedidos(Model model) {
        List<PedidosDTO> pedidos = pedidosService.listarPedidos();
        model.addAttribute("pedidos", pedidos); // O nome aqui deve bater com o th:each no HTML
        return "listarPedidos";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionar(Model model) {
        model.addAttribute("pedido", new PedidosDTO());
        return "adicionarPedido";
    }

    @PostMapping("/salvar")
    public String salvarPedido(@ModelAttribute PedidosDTO pedido, RedirectAttributes ra) {
        pedidosService.criarPedido(pedido);
        ra.addFlashAttribute("mensagem", "Pedido cadastrado com sucesso!");
        return "redirect:/pedidos/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPedido(@PathVariable Long id) {
        pedidosService.deletarPedido(id);
        return "redirect:/pedidos/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterar(@PathVariable Long id, Model model) {
        PedidosDTO pedido = pedidosService.buscarPorId(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            return "alterarPedido";
        }
        return "redirect:/pedidos/ui/listar";
    }
}
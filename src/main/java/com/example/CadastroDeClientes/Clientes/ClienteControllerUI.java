package com.example.CadastroDeClientes.Clientes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/clientes/ui")

public class ClienteControllerUI {

    private final ClienteService clienteService;

    public ClienteControllerUI(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public String listarCliente(Model model) {
        List<ClienteDTO> clientes =  clienteService.listarClientes();
        model.addAttribute("cliente", clientes);
        return "listarClientes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarClientePorId(@PathVariable Long id) {
        clienteService.deletarClientePorId(id);
        return "redirect:/clientes/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarClientesPorId(@PathVariable Long id, Model model) {
        ClienteDTO cliente =  clienteService.listarClientesPorId(id);
        if (cliente !=null) {
            model.addAttribute("cliente", cliente);
            return "detalhescliente";
        } else {
            model.addAttribute("mensagem", "Cliente não encontrado");
            return "listarClientes";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarCliente(Model model) {
        model.addAttribute("cliente", new ClienteDTO());
        return "adicionarCliente";
    }

    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute ClienteDTO cliente, RedirectAttributes redirectAttributes) {
        clienteService.criarCliente(cliente);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
        return "redirect:/clientes/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterarCliente(@PathVariable Long id, Model model) {
        ClienteDTO cliente = clienteService.listarClientesPorId(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "alterarCliente";
        } else {
            return "redirect:/clientes/ui/listar";
        }
    }

}
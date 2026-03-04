package com.example.CadastroDeClientes.Pedidos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    private final PedidosRepository pedidosRepository;

    // Construtor para o Spring injetar o Repository
    public PedidosService(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    public List<PedidosModel> listarPedidos() {
        return pedidosRepository.findAll();
    }

    public PedidosModel criarPedido(PedidosModel pedido) {
        return pedidosRepository.save(pedido);
    }

    public Optional<PedidosModel> buscarPorId(Long id) {
        return pedidosRepository.findById(id);
    }

    public void deletarPedido(Long id) {
        pedidosRepository.deleteById(id);
    }
}
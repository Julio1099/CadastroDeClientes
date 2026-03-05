package com.example.CadastroDeClientes.Pedidos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidosService {

    private final PedidosRepository pedidosRepository;
    private final PedidosMapper pedidosMapper;

    public PedidosService(PedidosRepository pedidosRepository, PedidosMapper pedidosMapper) {
        this.pedidosRepository = pedidosRepository;
        this.pedidosMapper = pedidosMapper;
    }

    public List<PedidosDTO> listarPedidos() {
        List<PedidosModel> pedidos = pedidosRepository.findAll();
        return pedidos.stream()
                .map(pedidosMapper::map)
                .collect(Collectors.toList());
    }

    public PedidosDTO buscarPorId(Long id) {
        Optional<PedidosModel> pedido = pedidosRepository.findById(id);
        return pedido.map(pedidosMapper::map).orElse(null);
    }

    public PedidosDTO criarPedido(PedidosDTO pedidoDTO) {
        PedidosModel pedido = pedidosMapper.map(pedidoDTO);
        PedidosModel pedidoSalvo = pedidosRepository.save(pedido);
        return pedidosMapper.map(pedidoSalvo);
    }

    public PedidosDTO atualizarPedido(Long id, PedidosDTO pedidoAtualizadoDTO) {
        if (pedidosRepository.existsById(id)) {
            PedidosModel pedido = pedidosMapper.map(pedidoAtualizadoDTO);
            pedido.setId(id);
            PedidosModel pedidoSalvo = pedidosRepository.save(pedido);
            return pedidosMapper.map(pedidoSalvo);
        }
        return null;
    }

    public void deletarPedido(Long id) {
        pedidosRepository.deleteById(id);
    }
}
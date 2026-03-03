package com.example.CadastroDeClientes.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CadastroDeClientes.Pedidos.PedidosModel;

public interface ClienteRepository extends JpaRepository<PedidosModel, Long> {
}
package com.example.CadastroDeClientes.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> listarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteModel listarClientesPorId(Long id){
        Optional<ClienteModel> clientePorId = clienteRepository.findById(id);
        return clientePorId.orElse(null);
    }

    public ClienteModel cirarCliente(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public void deletarClientePorId(Long id){
        clienteRepository.deleteById(id);
    }






}

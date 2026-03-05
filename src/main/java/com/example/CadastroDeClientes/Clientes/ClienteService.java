package com.example.CadastroDeClientes.Clientes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public List<ClienteModel> listarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteModel listarClientesPorId(Long id){
        Optional<ClienteModel> clientePorId = clienteRepository.findById(id);
        return clientePorId.orElse(null);
    }

    public ClienteDTO cirarCliente(ClienteDTO clienteDTO){
        ClienteModel cliente = clienteMapper.map(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.map(cliente);
    }

    public void deletarClientePorId(Long id){
        clienteRepository.deleteById(id);
    }

    public ClienteModel atualizarCliente(Long id, ClienteModel clienteAtualizado){
        if (clienteRepository.existsById(id)){
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null;
    }






}

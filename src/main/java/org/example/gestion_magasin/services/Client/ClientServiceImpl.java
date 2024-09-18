package org.example.gestion_magasin.services.Client;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.gestion_magasin.dtos.ClientDto;
import org.example.gestion_magasin.entities.Client;
import org.example.gestion_magasin.mappers.ClientMapper;
import org.example.gestion_magasin.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientDto addClient(ClientDto clientDto) {
        Client client =clientMapper.clientDtoToClient(clientDto);
        return clientMapper.clientToClientDto(clientRepository.save(client));
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) {
        Client client =clientRepository.findById(id).orElseThrow();
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setEmail(clientDto.getEmail());
        client.setAdresse(clientDto.getAdresse());
        client.setTelephone(clientDto.getTelephone());
//        client.setAchats(clientDto.getAchats());
        return clientMapper.clientToClientDto(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDto> listClient(){
        List<Client> clients = clientRepository.findAll();
        return clientMapper.clientToClientDtoList(clients);
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        return clientMapper.clientToClientDto(client);
    }

    @Override
    public List<ClientDto> searchClient(String keyword) {
        List<Client> clients = clientRepository.searchClient(keyword);
        return clients.stream().map(clt -> clientMapper.clientToClientDto(clt)).collect(Collectors.toList());
    }
}

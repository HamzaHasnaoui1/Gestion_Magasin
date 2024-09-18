package org.example.gestion_magasin.services.Client;

import org.example.gestion_magasin.dtos.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto addClient(ClientDto clientDto);

    ClientDto updateClient(Long id, ClientDto clientDto);

    void deleteClient(Long id);

    List<ClientDto> listClient();

    ClientDto getClientById(Long id);

    List<ClientDto> searchClient(String keyword);
}

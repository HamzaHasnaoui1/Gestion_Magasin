package org.example.gestion_magasin.mappers;

import org.example.gestion_magasin.dtos.ClientDto;
import org.example.gestion_magasin.entities.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto clientToClientDto(Client client);
    Client clientDtoToClient(ClientDto clientDto);

    List<ClientDto> clientToClientDtoList(List<Client> clients);
}

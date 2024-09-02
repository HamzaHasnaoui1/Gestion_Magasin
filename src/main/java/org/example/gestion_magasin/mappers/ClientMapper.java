package org.example.gestion_magasin.mappers;

import org.example.gestion_magasin.dtos.ClientDto;
import org.example.gestion_magasin.entities.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    ClientDto clientToClientDto(Client client);
    Client clientDtoToClient(ClientDto clientDto);
}

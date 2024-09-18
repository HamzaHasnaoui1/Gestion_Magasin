package org.example.gestion_magasin.mappers;

import org.example.gestion_magasin.dtos.AchatDto;
import org.example.gestion_magasin.entities.Achat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AchatMapper {
    AchatDto achatToAchatDto(Achat achat);
    Achat achatDtoToAchat(AchatDto achatDto);
}

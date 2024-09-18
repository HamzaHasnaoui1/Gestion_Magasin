package org.example.gestion_magasin.mappers;

import org.example.gestion_magasin.dtos.PaiementDto;
import org.example.gestion_magasin.entities.Paiement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaiementMapper {
    PaiementDto paiementToPaiementDto(Paiement paiement);
    Paiement paiementDtoToPaiement(PaiementDto paiementDto);
    List<PaiementDto> paiementsToPaiementDtosList(List<Paiement> paiements);
}

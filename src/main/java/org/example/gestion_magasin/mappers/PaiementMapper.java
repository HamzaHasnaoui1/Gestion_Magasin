package org.example.gestion_magasin.mappers;

import org.example.gestion_magasin.dtos.PaiementDto;
import org.example.gestion_magasin.entities.Paiement;
import org.mapstruct.Mapper;

@Mapper
public interface PaiementMapper {
    PaiementDto paiementToPaiementDto(Paiement paiement);
    Paiement paiementDtoToPaiement(PaiementDto paiementDto);
}

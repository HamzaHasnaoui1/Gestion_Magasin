package org.example.gestion_magasin.services.Paiement;

import org.example.gestion_magasin.dtos.PaiementDto;
import org.example.gestion_magasin.entities.Paiement;

import java.util.List;

public interface PaiementService {


    PaiementDto addPaiement(Long clientId, Long achatId, double montantPaye);

    //void deletePaiement(Long id);

    List<PaiementDto> getAllPaiements();

    PaiementDto getPaiementById(Long id);
}

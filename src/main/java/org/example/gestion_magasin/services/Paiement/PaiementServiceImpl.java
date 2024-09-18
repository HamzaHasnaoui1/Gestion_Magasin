package org.example.gestion_magasin.services.Paiement;

import lombok.RequiredArgsConstructor;
import org.example.gestion_magasin.dtos.PaiementDto;
import org.example.gestion_magasin.dtos.ProduitsDto;
import org.example.gestion_magasin.entities.Achat;
import org.example.gestion_magasin.entities.Client;
import org.example.gestion_magasin.entities.Paiement;
import org.example.gestion_magasin.entities.Produits;
import org.example.gestion_magasin.mappers.PaiementMapper;
import org.example.gestion_magasin.repositories.AchatRepository;
import org.example.gestion_magasin.repositories.ClientRepository;
import org.example.gestion_magasin.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PaiementServiceImpl implements PaiementService {
    @Autowired
    private PaiementRepository paiementRepository;
    @Autowired
    private AchatRepository achatRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PaiementMapper paiementMapper;

    @Override
    public PaiementDto addPaiement(Long clientId, Long achatId, double montant) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Achat achat = achatRepository.findById(achatId)
                .orElseThrow(() -> new RuntimeException("Achat not found"));

        if (montant > achat.getSoldeRestant()) {
            throw new RuntimeException("Le montant payé dépasse le solde restant.");
        }

        Paiement paiement = Paiement.builder()
                .client(client)
                .achat(achat)
                .datePaiement(LocalDate.now())
                .montant(montant)
                .build();

        achat.setMontantPaye(achat.getMontantPaye() + montant);
        achat.setSoldeRestant(achat.getMontantTotal() - achat.getMontantPaye());
        achatRepository.save(achat);

        return paiementMapper.paiementToPaiementDto(paiementRepository.save(paiement));
    }


    /*@Override
    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }*/

    @Override
    public List<PaiementDto> getAllPaiements() {
        return paiementMapper.paiementsToPaiementDtosList(paiementRepository.findAll());
    }



    @Override
    public PaiementDto getPaiementById(Long id) {
        return paiementMapper.paiementToPaiementDto(paiementRepository.findById(id).orElseThrow());
    }


}


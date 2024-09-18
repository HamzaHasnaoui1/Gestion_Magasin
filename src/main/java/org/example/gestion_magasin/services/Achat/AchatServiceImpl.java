package org.example.gestion_magasin.services.Achat;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.gestion_magasin.dtos.AchatDto;
import org.example.gestion_magasin.entities.Achat;
import org.example.gestion_magasin.entities.Client;
import org.example.gestion_magasin.entities.Produits;
import org.example.gestion_magasin.mappers.AchatMapper;
import org.example.gestion_magasin.mappers.ClientMapper;
import org.example.gestion_magasin.mappers.ProduitsMapper;
import org.example.gestion_magasin.repositories.AchatRepository;
import org.example.gestion_magasin.repositories.ClientRepository;
import org.example.gestion_magasin.repositories.ProduitsRepository;
import org.example.gestion_magasin.services.Paiement.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AchatServiceImpl implements AchatService {
    @Autowired
    private  AchatRepository achatRepository;
    @Autowired
    private  ClientRepository ClientRepository;
    @Autowired
    private  ProduitsRepository ProduitsRepository;
    @Autowired
    private  AchatMapper achatMapper;
    @Autowired
    private  ClientMapper clientMapper;
    @Autowired
    private  ProduitsMapper produitsMapper;
    @Autowired
    private  ClientRepository clientRepository;
    @Autowired
    private  ProduitsRepository produitsRepository;
    @Autowired
    private PaiementService paiementService;

    @Override
    public AchatDto addAchat(AchatDto achatDto) {
        Client client = clientRepository.findById(achatDto.getClientId())
                .orElseThrow(()->new RuntimeException("Client not found"));

        List<Produits> produits = produitsRepository.findAllById(achatDto.getProduitsId());

        double montantTotal = produits.stream().mapToDouble(Produits::getPrix).sum();
        double montantPaye = achatDto.getMontantPaye();
        double soldeRestant = montantTotal - achatDto.getMontantPaye();

        Achat achat =Achat.builder()
                .client(client).produits(produits).dateAchat(LocalDate.now())
                .montantTotal(montantTotal).montantPaye(achatDto.getMontantPaye())
                .soldeRestant(soldeRestant).build();

        if (montantPaye > 0) {
            paiementService.addPaiement(client.getId(), achat.getId(), montantPaye);
        }

        return achatMapper.achatToAchatDto(achatRepository.save(achat));
    }
}

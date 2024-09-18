package org.example.gestion_magasin.dtos;

import lombok.Data;
import org.example.gestion_magasin.entities.Client;
import org.example.gestion_magasin.entities.Paiement;
import org.example.gestion_magasin.entities.Produits;

import java.time.LocalDate;
import java.util.List;

@Data
public class AchatDto {
    private Long id;
    private Long clientId;
   // private Client client;
    private List<Long> produitsId;
    //private List<Paiement> paiements;
    private double montantTotal;
    private double montantPaye;
    private double soldeRestant;
    private LocalDate dateAchat;


}

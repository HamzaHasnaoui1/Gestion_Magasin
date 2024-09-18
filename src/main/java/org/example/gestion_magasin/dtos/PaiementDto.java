package org.example.gestion_magasin.dtos;

import lombok.Data;
import org.example.gestion_magasin.entities.Achat;
import org.example.gestion_magasin.entities.Client;

import java.time.LocalDate;

@Data
public class PaiementDto {
    private Long id;
    private Client client;
    private Achat achat;
    private double montant;
    private LocalDate datePaiement;
}

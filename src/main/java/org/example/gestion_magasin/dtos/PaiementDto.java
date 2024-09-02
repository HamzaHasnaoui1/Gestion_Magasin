package org.example.gestion_magasin.dtos;

import lombok.Data;
import org.example.gestion_magasin.entities.Achat;

import java.time.LocalDate;

@Data
public class PaiementDto {
    private Long id;
    private Achat achat;
    private double montant;
    private LocalDate datePaiement;
}

package org.example.gestion_magasin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Achat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Produits> produits;

    @OneToMany(mappedBy = "achat")
    private List<Paiement> paiements;

    private double montantTotal;
    private double montantPaye;
    private double soldeRestant;


}

package org.example.gestion_magasin.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gestion_magasin.entities.Achat;
import org.example.gestion_magasin.entities.Paiement;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
//    private List<Achat> achats;
//private List<Paiement> paiements;

}

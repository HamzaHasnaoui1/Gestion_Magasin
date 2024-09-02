package org.example.gestion_magasin.dtos;

import lombok.Data;
import org.example.gestion_magasin.entities.Achat;

import java.util.List;

@Data
public class ClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private List<Achat> achats;
}

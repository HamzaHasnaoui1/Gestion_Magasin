package org.example.gestion_magasin.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gestion_magasin.entities.Achat;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProduitsDto {
    private Long id;
    private String nom;
    private String description;
    private double prix;
   // private List<Achat> achats;

}

package org.example.gestion_magasin.services.Produits;

import org.example.gestion_magasin.dtos.ProduitsDto;

import java.util.List;

public interface ProduitsService {
    ProduitsDto addProduit(ProduitsDto produitsDto);

    ProduitsDto updateProduit(Long id, ProduitsDto produitsDto);

    List<ProduitsDto> getAllProduits();

    void deleteProduit(Long id);

    ProduitsDto getProduitById(Long id);

    List<ProduitsDto> searchProduit(String keyword);

}

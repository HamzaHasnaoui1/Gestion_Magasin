package org.example.gestion_magasin.services.Produits;

import lombok.AllArgsConstructor;
import org.example.gestion_magasin.dtos.ProduitsDto;
import org.example.gestion_magasin.entities.Produits;
import org.example.gestion_magasin.mappers.ProduitsMapper;
import org.example.gestion_magasin.repositories.ProduitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProduitsServiceImpl implements ProduitsService {
    @Autowired
    private ProduitsRepository produitsRepository;
    @Autowired
    private ProduitsMapper produitsMapper;

    @Override
    public ProduitsDto addProduit(ProduitsDto produitsDto) {
        Produits produits=produitsMapper.produitsDtoToProduits(produitsDto);
        return produitsMapper.produitsToProduitsDto(produitsRepository.save(produits));
    }

    @Override
    public ProduitsDto updateProduit(Long id ,ProduitsDto produitsDto) {
        Produits produits=produitsRepository.findById(id).orElseThrow();
        produits.setNom(produitsDto.getNom());
        produits.setPrix(produitsDto.getPrix());
        produits.setDescription(produitsDto.getDescription());
        return produitsMapper.produitsToProduitsDto(produitsRepository.save(produits));
    }

    @Override
    public List<ProduitsDto> getAllProduits() {
        List<Produits> produits= produitsRepository.findAll();
        return produitsMapper.produitsToProduitsDtoList(produits);
    }

    @Override
    public void deleteProduit(Long id) {
        produitsRepository.deleteById(id);
    }

    @Override
    public ProduitsDto getProduitById(Long id) {
        Produits produits=produitsRepository.findById(id).orElseThrow();
        return produitsMapper.produitsToProduitsDto(produits);
    }

    @Override
    public List<ProduitsDto> searchProduit(String keyword) {
        List<Produits> produits = produitsRepository.searchProduit(keyword);
        return produits.stream().map(clt -> produitsMapper.produitsToProduitsDto(clt)).collect(Collectors.toList());
    }
}

package org.example.gestion_magasin.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.example.gestion_magasin.dtos.ClientDto;
import org.example.gestion_magasin.dtos.ProduitsDto;
import org.example.gestion_magasin.services.Produits.ProduitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitsController {
    @Autowired
    private ProduitsService produitsService;

    @PostMapping("/addPdt")
    public ProduitsDto addPdt(@RequestBody ProduitsDto produitsDto) {
        return produitsService.addProduit(produitsDto);
    }

    @GetMapping("/pdtList")
    public List<ProduitsDto> pdtList() {
        return produitsService.getAllProduits();
    }

    @GetMapping("/getPdtById/{id}")
    public ProduitsDto getPdtById(@PathVariable Long id) {
        return produitsService.getProduitById(id);
    }

    @PostMapping("/updatePdt/{id}")
    public ProduitsDto updatePdt(@PathVariable Long id, @RequestBody ProduitsDto produitsDto) {
        return produitsService.updateProduit(id, produitsDto);
    }

    @DeleteMapping("/deletePdt/{id}")
    public ResponseEntity<String> deletePdt(@PathVariable Long id) {
        try {
            produitsService.deleteProduit(id);
            return ResponseEntity.ok("Produit avec l'ID " + id + " a été supprimé avec succès.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produit avec l'ID " + id + " introuvable.");
        }
    }


    @GetMapping("/searchPdt")
    public List<ProduitsDto> searchClt(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return produitsService.searchProduit("%" + keyword + "%");
    }

}

package org.example.gestion_magasin.controllers;

import org.example.gestion_magasin.dtos.PaiementDto;
import org.example.gestion_magasin.dtos.ProduitsDto;
import org.example.gestion_magasin.services.Paiement.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    @PostMapping("/addPaiement")
    public PaiementDto addPaimenet (@RequestParam Long clientId,@RequestParam  Long achatId,@RequestParam  double montant) {
        return paiementService.addPaiement(clientId,achatId,montant);
    }

    @GetMapping("/paiementList")
    public List<PaiementDto> paiementList() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/getPaiementById/{id}")
    public PaiementDto getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id);
    }
}

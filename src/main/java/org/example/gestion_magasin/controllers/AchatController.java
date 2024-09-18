package org.example.gestion_magasin.controllers;

import org.example.gestion_magasin.dtos.AchatDto;
import org.example.gestion_magasin.services.Achat.AchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achat")
public class AchatController {
    @Autowired
    private AchatService achatService;

    @PostMapping("addAchat")
    public AchatDto addAchat(@RequestBody AchatDto achatDto) {
        return achatService.addAchat(achatDto);
    }

   /* @PostMapping("/add")
    public ResponseEntity<AchatDto> addAchats(@RequestBody AchatDto achatDto) {
        AchatDto savedAchat = achatService.addAchat(achatDto);
        return ResponseEntity.ok(savedAchat);
    }*/
}

package org.example.gestion_magasin;

import org.example.gestion_magasin.dtos.ClientDto;
import org.example.gestion_magasin.dtos.ProduitsDto;
import org.example.gestion_magasin.entities.Client;
import org.example.gestion_magasin.services.Client.ClientService;
import org.example.gestion_magasin.services.Produits.ProduitsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class GestionMagasinApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionMagasinApplication.class, args);
    }

  /*  @Bean
    CommandLineRunner saveClients(ClientService clientService) {
        return args -> {
                for (int i = 1; i <= 20; i++) {
                    clientService.addClient(ClientDto.builder()
                            .nom("Client" + i)
                            .prenom("Prenom" + i)
                            .adresse("Adresse " + i)
                            .email("client" + i + "@mail.com")
                            .telephone("0600000" + i)
                            .build());
                }
            };
    }*/
     /*   @Bean
    CommandLineRunner savePdt(ProduitsService produitsService) {
        return args -> {
                for (int i = 1; i <= 20; i++) {
                    produitsService.addProduit(ProduitsDto.builder()
                            .nom("Pdt" + i)
                            .description("Description " + i)
                            .prix(1000+i)
                            .build());
                }
            };
    }*/
}

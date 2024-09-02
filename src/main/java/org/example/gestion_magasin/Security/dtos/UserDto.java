package org.example.gestion_magasin.Security.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @NoArgsConstructor @AllArgsConstructor @Data
public class UserDto {
    private Long id;
    private String nom;
    private String mail;

}

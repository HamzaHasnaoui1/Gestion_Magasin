package org.example.gestion_magasin.Security.services;


import org.example.gestion_magasin.Security.dtos.UserDto;

public interface UserService {
    UserDto saveNewUser(String nom, String mail, String password) throws RuntimeException;
}

package org.example.gestion_magasin.Security.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.gestion_magasin.Security.dtos.UserDto;
import org.example.gestion_magasin.Security.entities.User;
import org.example.gestion_magasin.Security.mappers.UserMapper;
import org.example.gestion_magasin.Security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDto saveNewUser(String nom, String mail, String password) throws RuntimeException {
        String hashedPWD = passwordEncoder.encode(password);// hasher le mdp

        User user = new User();
       // user.setId(Long.valueOf(UUID.randomUUID().toString())); //pour generer un id
        //UUID => genere des chaines de caractere aleatoire qui depend de la date systeme
        user.setNom(nom);
        user.setMail(mail);
        user.setPassword(hashedPWD);
        try {
            User savedUser = userRepository.save(user);
            return userMapper.ToUserDto(savedUser);
        }
        catch (Exception e) {
            log.error("Erreur lors de la création de l'utilisateur : {}", e.getMessage(), e);
            throw new RuntimeException("Erreur lors de la création de l'utilisateur : " + e.getMessage());

        }
    }
}

package org.example.gestion_magasin.Security.repositories;

import org.example.gestion_magasin.Security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}

package org.example.gestion_magasin.repositories;

import org.example.gestion_magasin.entities.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatRepository extends JpaRepository<Achat, Long> {
}

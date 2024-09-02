package org.example.gestion_magasin.repositories;

import org.example.gestion_magasin.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}

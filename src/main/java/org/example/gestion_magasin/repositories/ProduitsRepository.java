package org.example.gestion_magasin.repositories;

import org.example.gestion_magasin.entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitsRepository extends JpaRepository<Produits, Long> {
}

package org.example.gestion_magasin.repositories;

import org.example.gestion_magasin.entities.Client;
import org.example.gestion_magasin.entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduitsRepository extends JpaRepository<Produits, Long> {
    @Query("select p from Produits p where p.nom like :kw")
    List<Produits> searchProduit(@Param("kw") String keyword);

    List<Produits> findAllById(Iterable<Long> ids);
}

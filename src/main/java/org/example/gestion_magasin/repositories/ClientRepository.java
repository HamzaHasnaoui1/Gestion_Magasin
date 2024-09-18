package org.example.gestion_magasin.repositories;

import org.example.gestion_magasin.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select c from Client c where c.nom like :kw")
    List<Client> searchClient(@Param("kw") String keyword);
}

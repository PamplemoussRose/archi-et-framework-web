package com.capgemini.polytech.repository;

import com.capgemini.polytech.entite.TerrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de gestion des opérations CRUD pour l'entité {@link TerrainEntity}.
 * Ce repository étend l'interface {@link JpaRepository}, qui fournit des méthodes standard
 * pour effectuer des opérations de persistance sur l'entité {@link TerrainEntity}.
 * Il est annoté avec {@link Repository} pour indiquer que c'est une couche de persistance.
 *
 * @see JpaRepository
 * @see TerrainEntity
 */
@Repository
public interface TerrainRepository extends JpaRepository<TerrainEntity, Integer> {

    // Aucune méthode spécifique n'est nécessaire ici, car JpaRepository fournit déjà les méthodes CRUD de base.
}

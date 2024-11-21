package com.capgemini.polytech.repository;

import com.capgemini.polytech.entite.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de gestion des opérations CRUD pour l'entité {@link UtilisateurEntity}.
 * Ce repository étend l'interface {@link JpaRepository}, ce qui permet d'effectuer des opérations de persistance
 * standard sur l'entité {@link UtilisateurEntity}.
 * L'annotation {@link Repository} permet à Spring de la traiter comme une couche d'accès aux données.
 *
 * @see JpaRepository
 * @see UtilisateurEntity
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer> {

    // Aucune méthode spécifique n'est nécessaire ici, car JpaRepository fournit déjà les méthodes CRUD de base.
}

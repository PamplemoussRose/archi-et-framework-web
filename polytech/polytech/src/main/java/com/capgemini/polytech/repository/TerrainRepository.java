package com.capgemini.polytech.repository;

import com.capgemini.polytech.entite.TerrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<TerrainEntity, Integer> {

}

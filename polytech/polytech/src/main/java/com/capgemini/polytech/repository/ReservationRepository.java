package com.capgemini.polytech.repository;

import com.capgemini.polytech.entite.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {

}

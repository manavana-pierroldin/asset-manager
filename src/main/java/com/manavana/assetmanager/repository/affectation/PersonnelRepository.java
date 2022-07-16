package com.manavana.assetmanager.repository.affectation;

import com.manavana.assetmanager.entity.affectation.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    Optional<Personnel> findByNom(String username);
}
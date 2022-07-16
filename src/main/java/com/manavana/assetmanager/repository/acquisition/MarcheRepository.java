package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.Marche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcheRepository extends JpaRepository<Marche, Long> {
}
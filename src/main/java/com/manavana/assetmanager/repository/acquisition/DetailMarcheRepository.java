package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.DetailMarche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailMarcheRepository extends JpaRepository<DetailMarche, Long> {
}
package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.Bien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BienRepository extends JpaRepository<Bien, Long> {
}
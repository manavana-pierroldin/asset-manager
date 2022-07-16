package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {
}
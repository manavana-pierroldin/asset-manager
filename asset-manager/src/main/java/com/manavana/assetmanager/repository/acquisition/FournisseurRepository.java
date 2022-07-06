package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
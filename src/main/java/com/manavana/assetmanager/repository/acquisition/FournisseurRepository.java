package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
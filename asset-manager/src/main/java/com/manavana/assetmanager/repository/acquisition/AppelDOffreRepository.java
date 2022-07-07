package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.AppelDOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppelDOffreRepository extends JpaRepository<AppelDOffre, String> {
    AppelDOffre findByReference(String reference);
}
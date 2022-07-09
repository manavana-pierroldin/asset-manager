package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.AppelDOffre;
import com.manavana.assetmanager.repository.common.SearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppelDOffreRepository extends SearchRepository<AppelDOffre, String>  {
    AppelDOffre findByReference(String reference);
    void deleteByReference(String reference);
}
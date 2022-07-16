package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.AppelDOffre;
import com.manavana.assetmanager.repository.common.SearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppelDOffreRepository extends SearchRepository<AppelDOffre, String>  {
    void deleteByReference(String reference);
    AppelDOffre findByReference(String reference);

    List<AppelDOffre> findByOrderByDateDesc();

    List<AppelDOffre> findByOrderByBudgetAsc();


}
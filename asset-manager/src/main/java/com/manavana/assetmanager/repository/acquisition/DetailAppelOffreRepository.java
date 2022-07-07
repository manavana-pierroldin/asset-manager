package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.DetailAppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailAppelOffreRepository extends JpaRepository<DetailAppelOffre, Long> {
}
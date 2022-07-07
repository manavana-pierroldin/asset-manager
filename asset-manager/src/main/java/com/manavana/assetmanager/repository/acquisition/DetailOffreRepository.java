package com.manavana.assetmanager.repository.acquisition;

import com.manavana.assetmanager.entity.acquisition.DetailOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailOffreRepository extends JpaRepository<DetailOffre, Long> {
}
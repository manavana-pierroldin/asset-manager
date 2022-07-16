package com.manavana.assetmanager.repository.common;

import com.manavana.assetmanager.entity.common.ArticleGenerique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleGeneriqueRepository extends JpaRepository<ArticleGenerique, Long> {
}
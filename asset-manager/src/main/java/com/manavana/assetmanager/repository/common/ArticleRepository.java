package com.manavana.assetmanager.repository.common;

import com.manavana.assetmanager.entity.common.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {
}
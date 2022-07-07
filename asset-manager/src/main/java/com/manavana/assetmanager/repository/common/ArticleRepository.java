package com.manavana.assetmanager.repository.common;
import com.manavana.assetmanager.entity.common.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {
}
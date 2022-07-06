package com.manavana.assetmanager.entity.common;

import javax.persistence.*;

@Entity
@Table(name = "article_generique")
public class ArticleGenerique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
package com.manavana.assetmanager.entity.common;

import com.manavana.assetmanager.entity.acquisition.DetailMarche;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "article_generique")
public class ArticleGenerique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "marque")
    private String marque;

    @OneToMany(mappedBy = "articleGenerique", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "articleGenerique", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailMarche> detailMarches = new ArrayList<>();

    public List<DetailMarche> getDetailMarches() {
        return detailMarches;
    }

    public void setDetailMarches(List<DetailMarche> detailMarches) {
        this.detailMarches = detailMarches;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;

    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
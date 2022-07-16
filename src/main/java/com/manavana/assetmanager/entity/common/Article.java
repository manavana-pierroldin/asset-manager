package com.manavana.assetmanager.entity.common;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @Column(name = "code_article", nullable = false)
    private String code_article;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prix_unitaire")
    private Double prix_unitaire;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "conditionnement")
    private String conditionnement;

    @Column(name = "marque")
    private String marque;

    @Column(name = "poids")
    private Double poids;

    @Column(name = "photo")
    private String photo;

    @Column(name = "etat")
    private String etat;

    @ManyToOne
    @JoinColumn(name = "article_generique_id")
    private ArticleGenerique articleGenerique;

    public ArticleGenerique getArticleGenerique() {
        return articleGenerique;
    }

    public void setArticleGenerique(ArticleGenerique articleGenerique) {
        this.articleGenerique = articleGenerique;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(String conditionnement) {
        this.conditionnement = conditionnement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCode_article() {
        return code_article;
    }
    public void setCode_article(String code_article) {
        this.code_article = code_article;
    }
}
package com.manavana.assetmanager.entity.acquisition;

import com.manavana.assetmanager.entity.common.ArticleGenerique;

import javax.persistence.*;

@Entity
@Table(name = "detail_marche")
public class DetailMarche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "quantite")
    private Double quantite;

    @Column(name = "prix_unitaire")
    private Double prix_unitaire;

    @ManyToOne
    @JoinColumn(name = "article_generique_id")
    private ArticleGenerique articleGenerique;

    public ArticleGenerique getArticleGenerique() {
        return articleGenerique;
    }

    public void setArticleGenerique(ArticleGenerique articleGenerique) {
        this.articleGenerique = articleGenerique;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
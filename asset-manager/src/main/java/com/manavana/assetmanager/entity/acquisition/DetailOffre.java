package com.manavana.assetmanager.entity.acquisition;

import javax.persistence.*;

@Entity
@Table(name = "detail_offre")
public class DetailOffre {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "prix_unitaire")
    private Double prix_unitaire;

    @Column(name = "quantite")
    private Double quantite;

    @Column(name = "marque")
    private String marque;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bien_id")
    private Bien bien;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
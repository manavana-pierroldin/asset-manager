package com.manavana.assetmanager.entity.acquisition;

import javax.persistence.*;

@Entity
@Table(name = "detail_appel_offre")
public class DetailAppelOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "quantite")
    private Double quantite;

    @ManyToOne
    @JoinColumn(name = "appel_d_offre_reference")
    private AppelDOffre appelDOffre;

    @ManyToOne
    @JoinColumn(name = "bien_id")
    private Bien bien;

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public AppelDOffre getAppelDOffre() {
        return appelDOffre;
    }

    public void setAppelDOffre(AppelDOffre appelDOffre) {
        this.appelDOffre = appelDOffre;
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
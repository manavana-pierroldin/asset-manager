package com.manavana.assetmanager.entity.acquisition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bien")
public class Bien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "unite")
    private String unite;

    @OneToMany(mappedBy = "bien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailAppelOffre> detailAppelOffres = new ArrayList<>();

    @OneToMany(mappedBy = "bien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailOffre> detailOffres = new ArrayList<>();

    public List<DetailOffre> getDetailOffres() {
        return detailOffres;
    }

    public void setDetailOffres(List<DetailOffre> detailOffres) {
        this.detailOffres = detailOffres;
    }

    public List<DetailAppelOffre> getDetailAppelOffres() {
        return detailAppelOffres;
    }

    public void setDetailAppelOffres(List<DetailAppelOffre> detailAppelOffres) {
        this.detailAppelOffres = detailAppelOffres;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
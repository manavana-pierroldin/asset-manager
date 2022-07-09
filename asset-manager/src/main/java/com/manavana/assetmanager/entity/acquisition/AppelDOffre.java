package com.manavana.assetmanager.entity.acquisition;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Indexed
@Entity
@Table(name = "appel_d_offre")
public class AppelDOffre {
    @FullTextField()
    @Id
    @Column(name = "reference", nullable = false)
    private String reference;

    @Column(name = "date")
    private Date date;

    @Column(name = "budget")
    private Double budget;
    @FullTextField()
    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "date_limite")
    private Date date_limite;
    @FullTextField()
    @Column(name = "objet")
    private String objet;

    @Column(name = "eligibilite")
    private String eligibilite;

    @OneToMany(mappedBy = "appelDOffre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailAppelOffre> detailAppelOffres = new ArrayList<>();

    @OneToMany(mappedBy = "appelDOffre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offre> offres = new ArrayList<>();

    public List<Offre> getOffres() {
        return offres;
    }

    public void setOffres(List<Offre> offres) {
        this.offres = offres;
    }

    public List<DetailAppelOffre> getDetailAppelOffres() {
        return detailAppelOffres;
    }

    public void setDetailAppelOffres(List<DetailAppelOffre> detailAppelOffres) {
        this.detailAppelOffres = detailAppelOffres;
    }

    public String getEligibilite() {
        return eligibilite;
    }

    public void setEligibilite(String eligibilite) {
        this.eligibilite = eligibilite;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Date getDate_limite() {
        return date_limite;
    }

    public void setDate_limite(Date date_limite) {
        this.date_limite = date_limite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
}
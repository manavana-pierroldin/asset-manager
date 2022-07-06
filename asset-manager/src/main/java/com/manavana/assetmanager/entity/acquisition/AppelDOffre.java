package com.manavana.assetmanager.entity.acquisition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "appel_d_offre")
public class AppelDOffre {
    @Id
    @Column(name = "reference", nullable = false)
    private String reference;

    @Column(name = "date")
    private Date date;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "date_limite")
    private Date date_limite;

    @Column(name = "objet")
    private String objet;

    @Column(name = "eligibilite")
    private String eligibilite;

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
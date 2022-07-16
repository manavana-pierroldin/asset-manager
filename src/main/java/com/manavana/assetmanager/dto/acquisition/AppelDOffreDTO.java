package com.manavana.assetmanager.dto.acquisition;

import java.sql.Date;
import java.util.List;

public class AppelDOffreDTO {
    private String reference;
    private String Objet;
    private String description;
    private String eligibilite;
    private Double budget;
    private Date date_limite;
    private List<Bien> biens;

    public String getReference() {
        return reference;
    }

    public String getEligibilite() {
        return eligibilite;
    }

    public void setEligibilite(String eligibilite) {
        this.eligibilite = eligibilite;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getObjet() {
        return Objet;
    }

    public void setObjet(String objet) {
        Objet = objet;
    }

    public String getDescritpion() {
        return description;
    }

    public void setDescritpion(String descritpion) {
        this.description = descritpion;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Date getDate_limite() {
        return date_limite;
    }

    public void setDate_limite(Date date_limite) {
        this.date_limite = date_limite;
    }

    public List<Bien> getBiens() {
        return biens;
    }

    public void setBiens(List<Bien> biens) {
        this.biens = biens;
    }

    private static class Bien{
        private String designation;
        private String description;
        private Double quantite;
        private String unite;

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Double getQuantite() {
            return quantite;
        }

        public void setQuantite(Double quantite) {
            this.quantite = quantite;
        }

        public String getUnite() {
            return unite;
        }

        public void setUnite(String unite) {
            this.unite = unite;
        }
    }

}

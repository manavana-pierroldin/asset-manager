package com.manavana.assetmanager.dto;

import com.manavana.assetmanager.entity.affectation.Role;

import java.util.List;

public class ProfileDTO {
    private String token;
    private Personnel personnel=new Personnel();

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private static class Personnel{
         String nom;
         String prenom;
         String fonction;
         List<Role> roles;

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getFonction() {
            return fonction;
        }

        public void setFonction(String fonction) {
            this.fonction = fonction;
        }

        public List<Role> getRoles() {
            return roles;
        }

        public void setRoles(List<Role> roles) {
            this.roles = roles;
        }
    }
}

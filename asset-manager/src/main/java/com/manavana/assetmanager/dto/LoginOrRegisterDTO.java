package com.manavana.assetmanager.dto;

import com.manavana.assetmanager.entity.affectation.Role;

import java.util.List;

public class LoginOrRegisterDTO {
    private String token;
    private Personnel personnel=new Personnel();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Personnel getPersonnel() {
        return this.personnel;
    }

    private static class Personnel{
        private String nom;
        private String prenom;
        private String fonction;
        private List<Role> roles;

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

    public void setNom(String nom) {
        this.personnel.setNom(nom);
    }

    public void setPrenom(String prenom) {
        this.personnel.setPrenom(prenom);
    }

    public void setFonction(String fonction) {
        this.personnel.setFonction( fonction );
    }

    public void setRoles(List<Role> roles) {
        this.personnel.setRoles( roles );
    }
}

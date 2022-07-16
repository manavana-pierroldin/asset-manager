package com.manavana.assetmanager.entity.affectation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    public  static  final  String RESPONSABLE_ACQUISITION="ROLE_Acquisition";
    public  static  final  String RESPONSABLE_STOCK="ROLE_Stock";
    public  static  final  String RESPONSABLE_AFFECTATION="ROLE_Affrectation";
    public  static  final  String RESPONSABLE_TICKET="ROLE_Ticket";
    public  static  final  String RESPONSABLE_REBUT="ROLE_Rebut";

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
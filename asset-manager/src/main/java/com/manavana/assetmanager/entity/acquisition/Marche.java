package com.manavana.assetmanager.entity.acquisition;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "marche")
public class Marche {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "date_limite")
    private Date date_limite;

    @OneToOne(mappedBy = "marche", orphanRemoval = true)
    private Offre offre;

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Date getDate_limite() {
        return date_limite;
    }

    public void setDate_limite(Date date_limite) {
        this.date_limite = date_limite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
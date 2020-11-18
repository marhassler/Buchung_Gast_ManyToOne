package com.hassler.BuchungPOS.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Gast")
public class Gast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @OneToMany(
            mappedBy = "gast",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Buchung> buchungen = new ArrayList<>();

    public Gast(String name) {
        this.name = name;
    }

    public Gast()
    {

    }

    public void setBuchungen(List<Buchung> buchungen) {
        this.buchungen = buchungen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Buchung> getBuchungen() {
        return buchungen;
    }

    public Long getId()
    {
        return id;
    }
}

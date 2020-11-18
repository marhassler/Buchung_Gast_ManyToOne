package com.hassler.BuchungPOS.domain;

import javax.persistence.*;

@Entity
@Table(name = "Buchung")
public class Buchung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String buchungsNummer;
    @ManyToOne
    @JoinColumn(name = "gast_id")
    private Gast gast;

    public Buchung(String buchungsNummer, Gast gast) {
        this.buchungsNummer = buchungsNummer;
        this.gast = gast;
    }

    public Buchung()
    {

    }
}

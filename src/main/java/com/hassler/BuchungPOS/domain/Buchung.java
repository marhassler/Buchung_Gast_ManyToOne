package com.hassler.BuchungPOS.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Buchung")
public class Buchung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 2,max = 20)
    @NotBlank
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

    public String getBuchungsNummer() {
        return buchungsNummer;
    }

    public void setBuchungsNummer(String buchungsNummer) {
        this.buchungsNummer = buchungsNummer;
    }

    public Gast getGast() {
        return gast;
    }

    public void setGast(Gast gast) {
        this.gast = gast;
    }
}

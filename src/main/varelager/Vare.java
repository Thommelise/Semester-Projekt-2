package main.varelager;

import java.util.Objects;

public class Vare {

    private String varenavn;
    private String enhed;
    private int pris;

    public Vare(String varenavn, String enhed, int pris) {
        this.varenavn = varenavn;
        this.enhed = enhed;
        this.pris = pris;
    }

    public String getVarenavn() {
        return varenavn;
    }

    public String getEnhed() {
        return enhed;
    }

    public int getPris() {
        return pris;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vare vare = (Vare) o;
        return                pris == vare.pris &&
                Objects.equals(varenavn, vare.varenavn) &&
                Objects.equals(enhed, vare.enhed);
    }


    @Override
    public String toString() {
        return "Vare" +
                "varenavn='" + varenavn + '\'' +
                ", enhed='" + enhed + '\'' +
                ", pris=" + pris;
    }
}

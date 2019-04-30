package main.varelager;

import java.util.Objects;

public class Vare {

    private String varenavn;
    private int antal;
    private String enhed;
    private int pris;

    public Vare(String varenavn, int antal, String enhed, int pris) {
        this.varenavn = varenavn;
        this.antal = antal;
        this.enhed = enhed;
        this.pris = pris;
    }

    public String getVarenavn() {
        return varenavn;
    }

    public int getAntal() {
        return antal;
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
        return antal == vare.antal &&
                pris == vare.pris &&
                Objects.equals(varenavn, vare.varenavn) &&
                Objects.equals(enhed, vare.enhed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(varenavn, antal, enhed, pris);
    }

    @Override
    public String toString() {
        return "Vare" +
                "varenavn='" + varenavn + '\'' +
                ", antal=" + antal +
                ", enhed='" + enhed + '\'' +
                ", pris=" + pris;
    }
}

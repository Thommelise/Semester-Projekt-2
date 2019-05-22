package main.varelager;

import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Spild {

    private SimpleStringProperty varenavn;
    private int antal;

    public Spild(String varenavn, int antal) {
        this.varenavn = new SimpleStringProperty(varenavn);
        this.antal = antal;
    }

    public String getVarenavn() {
        return varenavn.get();
    }

    public int getAntal() {
        return antal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spild spild = (Spild) o;
        return antal == spild.antal &&
                Objects.equals(varenavn, spild.varenavn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(varenavn, antal);
    }

    @Override
    public String toString() {
        return "Spild" +
                "varenavn =" + varenavn + '\'' +
                ", antal =" + antal;
    }
}

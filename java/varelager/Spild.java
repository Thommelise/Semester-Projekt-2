package varelager;

import java.util.Objects;

public class Spild {

    private String varenavn;
    private int antal;

    public Spild(String varenavn, int antal) {
        this.varenavn = varenavn;
        this.antal = antal;
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
        return "varelager.Spild" +
                "varenavn =" + varenavn + '\'' +
                ", antal =" + antal;
    }
}

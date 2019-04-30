package main.medarbejder;

public class Kok extends Ansat {

    private String varenavn;
    private int antal;


    public Kok(String navn, String cpr, int id, String stilling, String varenavn, int antal) {
        super(navn, cpr, id, stilling);
        this.varenavn = varenavn;
        this.antal = antal;
    }

    public void registrereSpild(String varenavn, int antal) {

    }

    public void registrereBestilteVare(String varenavn, int antal) {

    }
}

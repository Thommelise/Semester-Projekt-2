public class Vare {

    private String varenavn;
    private int antal;
    private enum enhed{}
    private int pris;

    public Vare(String varenavn, int antal, int pris) {
        this.varenavn = varenavn;
        this.antal = antal;
        this.pris = pris;
    }


}

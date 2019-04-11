package varelager;

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
    public String toString() {
        return "Vare" +
                "varenavn='" + varenavn + '\'' +
                ", antal=" + antal +
                ", enhed='" + enhed + '\'' +
                ", pris=" + pris;
    }
}

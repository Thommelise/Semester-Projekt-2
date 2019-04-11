package Medarbejder;


public class Ansat {

    private String navn;
    private String cpr;
    private int id;
    private String stilling;

    public Ansat(String navn, String cpr, int id, String stilling) {
        this.navn = navn;
        this.cpr = cpr;
        this.id = id;
        this.stilling = stilling;
    }

    public void bestilRet(String drink, String sideOrdre, String hovederet) {

    }

    public String getNavn() {
        return navn;
    }

    public String getCpr() {
        return cpr;
    }

    public int getId() {
        return id;
    }

    public String getStilling() {
        return stilling;
    }

    @Override
    public String toString() {
        return "Ansat{" +
                "navn='" + navn + '\'' +
                ", cpr='" + cpr + '\'' +
                ", id=" + id +
                ", stilling='" + stilling + '\'' +
                '}';
    }
}

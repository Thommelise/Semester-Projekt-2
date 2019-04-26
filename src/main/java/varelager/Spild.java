package varelager;

public class Spild {

    private String varenavn;
    private int antal;

    public Spild(String varenavn, int antal) {
        this.varenavn = varenavn;
        this.antal = antal;
    }

    @Override
    public String toString() {
        return "varelager.Spild" +
                "varenavn =" + varenavn + '\'' +
                ", antal =" + antal;
    }
}

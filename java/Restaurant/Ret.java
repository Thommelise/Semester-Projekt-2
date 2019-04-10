package Restaurant;

import Varelager.Vare;
import java.util.HashMap;

public class Ret {

    private String varenavn;
    private HashMap<Integer, Vare> ret;

    public Ret() {
    }

    public String getVarenavn() {
        return varenavn;
    }

    public void setVarenavn(String varenavne) {
        varenavn = varenavne;
    }
}

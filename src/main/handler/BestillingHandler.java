package main.handler;

import java.util.ArrayList;
import java.util.Random;

public class BestillingHandler {

    public BestillingHandler() {

    }

    public ArrayList<String> ret = new ArrayList<>();
    private static BestillingHandler bestilling = null;

    public synchronized void tilføjRet(String madvare) {
        ret.add(madvare);
    }

    public synchronized ArrayList<String> getRet() {
        return ret;
    }

    public synchronized void sletRet() {
        ret.clear();
    }

    public static BestillingHandler bestilMad(){
        if(bestilling == null) {
            bestilling = new BestillingHandler();
        }
        return bestilling;
    }

    @Override
    public String toString() {
        return "BestillingHandler{" +
                "ret=" + ret +
                '}';
    }
}

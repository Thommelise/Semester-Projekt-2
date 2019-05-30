package main.restaurant;

import java.sql.*;
import java.util.ArrayList;

public class Menukort {

    private static Menukort menukort = null;

    public Menukort() {
    }

    public static Menukort menu(){
        if(menukort == null) {
            menukort = new Menukort();
        }
        return menukort;
    }

    public ArrayList<String> findVare(String retnavn) {
        Connection c = null;
        Statement stmt = null;
        ArrayList<String> vareListe = new ArrayList<String>();
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".ret join \"varelager\".indeholder i on ret.navn = i.Retnavn;" );
            while ( rs.next() ) {
                if (retnavn.equals(rs.getString("navn"))) {
                    String varenavne = rs.getString("varenavn");
                    System.out.println("varenavn = " + varenavne);
                    vareListe.add(varenavne);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vareListe;
    }

    public double findAntal(String retnavn) {
        Connection c = null;
        Statement stmt = null;
        double antal = 0.0;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".indeholder;" );
            while ( rs.next() ) {
                if (retnavn.equals(rs.getString("Varenavn"))) {
                    antal = rs.getDouble("antal");

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return antal;
    }
}


package main.restaurant;

import main.varelager.Vare;

import java.sql.*;
import java.util.ArrayList;

public class Menukort {

    private ArrayList<Ret> hovederet;
    private ArrayList<Ret> sideOrdre;
    private ArrayList<Ret> drink;

    public Menukort() {
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
            System.out.println("Opened database successfully");

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

    public Vare tilObjekt(String vare) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".vare;" );
            while ( rs.next() ) {
                if (vare.equals(rs.getString("varenavn"))) {
                    String varenavne = rs.getString("varenavn");
                    int antals = rs.getInt("antal");
                    String enhed = rs.getString("enhed");
                    int pris = rs.getInt("pris");
                    System.out.println( "varenavn = " + varenavne );
                    System.out.println( "antal = " + antals );
                    System.out.println( "enhed = " + enhed );
                    System.out.println( "pris = " + pris );
                    Vare varer = new Vare(varenavne, antals, enhed, pris);
                    return varer;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


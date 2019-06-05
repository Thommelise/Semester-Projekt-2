package main.medarbejder;

import java.sql.*;
import java.util.ArrayList;

public class MedarbejderListe {


    private ArrayList<Ansat> medarbejder = new ArrayList<Ansat>();
    /**/
    public MedarbejderListe() {

    }
    //Denne metode henter en liste med alle medarbejdere som obejekter
    public ArrayList seMearbejder() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".medarbejder;" );
            while ( rs.next() ) {
                String navn = rs.getString("navn");
                String cpr = rs.getString("cpr");
                int id = rs.getInt("id");
                String stilling = rs.getString("Stilling");
                Ansat ansat = new Ansat(navn, cpr, id, stilling);
                medarbejder.add(ansat);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound");
        } catch (SQLException e) {
            System.out.println("SQL");
        }
        return medarbejder;
    }
    //denne metode henter en enkel medarbejder ud som et ansat objekt
    public Ansat seEnkelMearbejder(String forspørgelse) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".medarbejder;" );
            while ( rs.next() ) {
                if (forspørgelse.equals(rs.getString("cpr"))) {
                    String navn = rs.getString("navn");
                    String cpr = rs.getString("cpr");
                    int id = rs.getInt("id");
                    String stilling = rs.getString("Stilling");
                    System.out.println("navn = " + navn);
                    System.out.println("cpr = " + cpr);
                    System.out.println("id = " + id);
                    System.out.println("stilling = " + stilling);
                    Ansat ansat = new Ansat(navn, cpr, id, stilling);
                    return ansat;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound");
        } catch (SQLException e) {
            System.out.println("SQL");
        }
        return null;
    }

    //Denne metode laver en ny medarbejder. Hvis det fejler returnes der en false så GUI'en kan opdateres
    public boolean opretMedarbejder(Ansat ansat) {
        if (ansat != null) {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "sfp86nbb");
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                stmt = c.createStatement();
                String sql0 = "insert into \"varelager\".medarbejder values ('" + ansat.getNavn() + "','" + ansat.getCpr() + "','" + ansat.getId() + "','" + ansat.getStilling() + "');";
                stmt.executeUpdate(sql0);
                return true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    //Denne metode sletter en medarbejder. Hvis det er et ugyldigt cpr returneres den false og GUI'en opdateres
    public boolean sletMedarbejder(String cpr) {
        if (cpr.matches("[a-zA-Z]+") == false && cpr.length() == 10) {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "sfp86nbb");
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql0 = "delete from \"varelager\".medarbejder where cpr = '" + cpr + "'; ";
                stmt.executeUpdate(sql0);
                return true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

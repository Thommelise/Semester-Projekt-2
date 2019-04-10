package Medarbejder;

import java.sql.*;
import java.util.ArrayList;

public class MedarbejderListe {


    private ArrayList<Ansat> medarbejder = new ArrayList<Ansat>();

    public MedarbejderListe() {

    }

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
                System.out.println( "navn = " + navn );
                System.out.println( "cpr = " + cpr );
                System.out.println( "id = " + id );
                System.out.println( "stilling = " + stilling );
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

    public void opretMedarbejder(Ansat ansat) {
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
                    String sql0 = "insert into \"varelager\".medarbejder values ('"+ansat.getNavn()+"','"+ansat.getCpr()+"','"+ansat.getId()+"','"+ansat.getStilling()+"');";
                    stmt.executeUpdate(sql0);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sletMedarbejder(String cpr) {
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
            String sql0 = "delete from \"varelager\".medarbejder where cpr = '"+cpr+"'; ";
            stmt.executeUpdate(sql0);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

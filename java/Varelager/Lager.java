package Varelager;

import sun.security.provider.ConfigFile;

import java.sql.*;
import java.util.ArrayList;

public class Lager {

    private ArrayList<Vare> vare;
    private ArrayList<Spild> spilds = new ArrayList<Spild>();

    public Lager() {
    }

    public ArrayList getSpild() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".spild;" );
            while ( rs.next() ) {
                String varenavn = rs.getString("varenavn");
                int antal = rs.getInt("antal");
                System.out.println( "varenavn = " + varenavn );
                System.out.println( "antal = " + antal );
                Spild spild = new Spild(varenavn, antal);
                spilds.add(spild);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spilds;
    }
}

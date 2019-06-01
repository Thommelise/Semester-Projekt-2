package main.varelager;


import main.handler.DatabaseHandler;
import org.omg.DynamicAny.DynAny;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Lager {

    private ArrayList<Vare> varer = new ArrayList<Vare>();
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

    public double seVare(String vare) {
        double antal = 0.0;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".lager;" );
            while ( rs.next() ) {
                if (vare.equals(rs.getString("varenavn"))) {
                    String varenavne = rs.getString("varenavn");
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

    public void hentVare(String fjernes, double antal) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".lager;" );
            while ( rs.next() ) {
                if (fjernes.equals(rs.getString("varenavn"))) {
                    String varenavne = rs.getString("varenavn");
                    System.out.println( "varenavn = " + varenavne );
                    System.out.println( "antal = " + antal );
                    stmt = c.createStatement();
                    String sql = "UPDATE \"varelager\".lager set antal = antal - '"+antal+"' where varenavn = '"+varenavne+"';";
                    stmt.executeUpdate(sql);
                    System.out.println(rs.getInt("antal"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrereSpild(String vare, int mængde) {
        if (vare.matches("[a-zA-Z]+") == true) {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "sfp86nbb");
                System.out.println("Opened database successfully - registrere spild");

                stmt = c.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT * FROM \"varelager\".spild;");
                String sql0 = "INSERT INTO \"varelager\".spild VALUES ('" + vare + "', '" + mængde + "');";
                while (rs.next()) {
                    if (vare.equals(rs.getString("varenavn"))) {

                        String sql = "UPDATE \"varelager\".vare set antal = antal - '" + mængde + "' where varenavn = '" + vare + "';";
                        sql0 = "UPDATE \"varelager\".spild set antal = antal + '" + mængde + "' where varenavn = '" + vare + "';";
                        stmt.executeUpdate(sql);
                        break;
                    }
                }
                stmt.executeUpdate(sql0);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void registrereBestilteVare(String vare, int mængde) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM \"varelager\".lager;");
            while (rs.next()) {
                if (vare.equals(rs.getString("varenavn"))) {
                    String varenavne = rs.getString("varenavn");
                    int antals = rs.getInt("antal");
                    System.out.println("varenavn = " + varenavne);
                    System.out.println("antal = " + antals);
                    stmt = c.createStatement();
                    String sql0 = "UPDATE \"varelager\".lager set antal = antal + '" + mængde + "' where varenavn = '" + varenavne + "';";
                    stmt.executeUpdate(sql0);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean opretVare(Vare vare, int antal) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");
                    stmt = c.createStatement();
                    String sql = "insert into \"varelager\".fødevare values ('"+vare.getVarenavn()+"','"+vare.getEnhed()+"','"+vare.getPris()+"');";
                    String sql1 = "insert into \"varelager\".lager values ('"+vare.getVarenavn()+"','"+antal+"');";
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql1);
                    return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sletVare(String vare) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "delete from \"varelager\".lager where varenavn = '"+vare+"';";
            stmt.executeUpdate(sql);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

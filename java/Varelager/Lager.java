package Varelager;

import Restaurant.Ret;
import sun.security.provider.ConfigFile;
import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList hentVare(Vare fjernes) {
        String forspørgelse = fjernes.getVarenavn();
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
                if (forspørgelse.equals(rs.getString("varenavn"))) {
                    String varenavne = rs.getString("varenavn");
                    int antals = rs.getInt("antal");
                    String enhed = rs.getString("enhed");
                    int pris = rs.getInt("pris");
                    System.out.println( "varenavn = " + varenavne );
                    System.out.println( "antal = " + antals );
                    System.out.println( "enhed = " + enhed );
                    System.out.println( "pris = " + pris );
                    Vare vare = new Vare(varenavne, antals, enhed, pris);
                    varer.add(vare);
                    stmt = c.createStatement();
                    String sql = "UPDATE \"varelager\".vare set antal = antal - 1 where varenavn = '"+varenavne+"';";
                    stmt.executeUpdate(sql);
                    System.out.println(rs.getInt("antal"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return varer;
    }

    public ArrayList registrereSpild(Vare vare, int mængde) {
        String forspørgelse = vare.getVarenavn();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".spild;" );
            while ( rs.next() ) {
                if (forspørgelse.equals(rs.getString("varenavn"))) {
                    String varenavne = rs.getString("varenavn");
                    int antals = rs.getInt("antal");
                    System.out.println( "varenavn = " + varenavne );
                    System.out.println( "antal = " + antals );
                    stmt = c.createStatement();
                    String sql = "UPDATE \"varelager\".vare set antal = antal - '"+mængde+"' where varenavn = '"+varenavne+"';";
                    String sql0 = "UPDATE \"varelager\".spild set antal = antal + '"+mængde+"' where varenavn = '"+varenavne+"';";
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql0);
                    System.out.println(rs.getInt("antal"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return varer;
    }
    public ArrayList registrereBestilteVare(Vare vare, int mængde) {
        String forspørgelse = vare.getVarenavn();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM \"varelager\".vare;");
            while (rs.next()) {
                if (forspørgelse.equals(rs.getString("varenavn"))) {
                    String varenavne = rs.getString("varenavn");
                    int antals = rs.getInt("antal");
                    System.out.println("varenavn = " + varenavne);
                    System.out.println("antal = " + antals);
                    stmt = c.createStatement();
                    String sql0 = "UPDATE \"varelager\".vare set antal = antal + '" + mængde + "' where varenavn = '" + varenavne + "';";
                    stmt.executeUpdate(sql0);
                    System.out.println(rs.getInt("antal"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return varer;
    }

    public void opretVare(Vare vare) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");
                    stmt = c.createStatement();
                    String sql = "insert into \"varelager\".vare values ('"+vare.getVarenavn()+"','"+vare.getAntal()+"','"+vare.getEnhed()+"','"+vare.getPris()+"');";
                    stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sletVare(Vare vare) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sfp86nbb");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "delete from \"varelager\".vare where varenavn = '"+vare.getVarenavn()+"';";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

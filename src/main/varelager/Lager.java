package main.varelager;


import main.handler.DatabaseHandler;
import org.omg.DynamicAny.DynAny;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Lager {

    private ArrayList<Vare> varer = new ArrayList<Vare>();
    private ArrayList<Spild> spilds = new ArrayList<Spild>();
    Connection c = null;
    Statement stmt = null;

    public Lager() {
    }

    private void openDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "sfp86nbb");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
    }

//denne metode henter spild tablen fra databasen og gemmer den i en arrayliste
    public ArrayList getSpild() {
        try {
            openDatabase();
            //her bliver tabellen hentet
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".spild;" );
            //Dette loop laver et spild objekt for hver eneste linje i tabellen
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



    //Denne metode viser hvor mange af varen der er på lager
    public double seVare(String vare) {
        double antal = 0.0;
        try {
       openDatabase();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".lager;" );
            //Dette loop kigger tabellen igennem. Hvis der er et match gemmer den det tal der står i antal columnen
            while ( rs.next() ) {
                if (vare.equals(rs.getString("varenavn"))) {
                    String varenavne = rs.getString("varenavn");
                    antal = rs.getDouble("antal");
                    return antal;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return antal;
    }

    //Denne metode fjerner en mængde af en vare fra lager tabellen
    public void hentVare(String fjernes, double antal) {
        try {
            openDatabase();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM \"varelager\".lager;" );
            while ( rs.next() ) {
                if (fjernes.equals(rs.getString("varenavn"))) {
                    String varenavne = rs.getString("varenavn");
                    System.out.println( "varenavn = " + varenavne );
                    System.out.println( "antal = " + antal );
                    stmt = c.createStatement();
                    String sql = "UPDATE \"varelager\".lager set antal = antal - '"+antal+"' where varenavn = '"+varenavne+"';";
                    stmt.executeUpdate(sql);
                    System.out.println("Fjernet " + antal + "fra " + fjernes);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Denne metode laver en ny linje mi spild tabellen med mindre varen allerede findes, for så updaterer metode en linje i stedet.
    public void registrereSpild(String vare, int mængde) {
        if (vare.matches("[a-zA-Z]+") == true) {
            try {
                openDatabase();

                ResultSet rs = stmt.executeQuery("SELECT * FROM \"varelager\".spild;");
                //Denne sql kode bliver kun kørt hvis metode ikke går ind i while loops if sætning.
                String sql0 = "INSERT INTO \"varelager\".spild VALUES ('" + vare + "', '" + mængde + "');";
                while (rs.next()) {
                    if (vare.equals(rs.getString("varenavn"))) {
                        //Hvis varen allerede findes i tabellen ændres insert til update
                        String sql = "UPDATE \"varelager\".lager set antal = antal - '" + mængde + "' where varenavn = '" + vare + "';";
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
    // Denne metode updater lager tabellen med en bestemt mængde
    public void registrereBestilteVare(String vare, int mængde) {

        try {
          openDatabase();
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
    //Denne metode laver en ny fødevare og en ny vare i lageret
    public boolean opretVare(Vare vare, int antal) {

        try {
           openDatabase();

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
    //Denne metode sletter en vare fra lageret.
    public boolean sletVare(String vare) {

        try {
            openDatabase();
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

package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Koneksi {
    Connection con;
    Statement stm;

    public void config(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/donasi-tubes-pbo", "root","");
            stm = con.createStatement();
        } catch (Exception e) {
            System.err.println("Koneksi Gagal");
        }
    }
}

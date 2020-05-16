package sample;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class koneksi {

    public static Connection con; // drive connection
    public static Statement stm; // con.createStatement();

    //message
    boolean isMessageCreateUser = false;

    // drive connection setup
    public static void driveConnection() throws SQLException {

        // Data setup to Database
        String url  = "jdbc:mysql://localhost/donasi-tubes-pbo";
        String user = "root";
        String pass = "";

        if(con == null) {
            new Driver();
            con = DriverManager.getConnection(url, user, pass);
        }
    }

    public static void main(String args[]){
        try {
            driveConnection();
            stm = con.createStatement();
            System.out.println("koneksi Berhasil");

        } catch (Exception e) {
            System.err.println("koneksi gagal : " +e.getMessage());
        }
    }

    public void createUser(String name, String username, String email, String pass) {
        try {
            driveConnection();

            stm = con.createStatement();
            stm.executeUpdate("INSERT INTO user(nama, username, email, password) VALUES ('"+ name +"', '"+ username +"', '"+ email +"', '"+ pass +"')");
            stm.close();

            this.isMessageCreateUser = true;
            System.out.println(messageCreateUser());

        } catch (Exception e) {
            System.out.println( messageCreateUser() + e.getMessage());;
        }
    }

    //message
    public String messageCreateUser() {
        if(this.isMessageCreateUser){
            return "Data Berhasil ditambahakan, Silakan lakukan login...";
        } else {
            return "Terjadi Kesalahan pada Pendataan User : ";
        }
    }

}
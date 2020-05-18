package sample;

import com.mysql.jdbc.Driver;

import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.sql.ResultSet;

public class koneksi {

    public static Connection con; // drive connection
    public static Statement stm; // con.createStatement();
    public static ResultSet result;

    //message
    boolean isMessageCreateUser = false;
    boolean isMessageCreateDonation = false;

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

    public void createDonation(String title, String penyelenggara, int targetDonasi, LocalDate targetHari, String deskripsi){
        try {
            driveConnection();

            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO dataDonasi(title, id_user, targetDonasi, masaBerakhir, deskripsi) VALUES" +
                    "('"+ title +"', '"+ penyelenggara +"', '"+ targetDonasi +"', '"+ targetHari +"', '"+ deskripsi+"')");
            stm.close();

            this.isMessageCreateDonation = true;
            System.out.println(messageCreateDonation());

        } catch (Exception e) {
            System.out.println( messageCreateDonation() + e.getMessage());;
        }
    }

    public void dataDonasi() throws SQLException {
        try {
            driveConnection();
            stm = con.createStatement();
            result = stm.executeQuery("select * from dataDonasi");
            while (result.next()){
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getString(4));
            }
            System.out.println("berhasil");
            stm.close();
        } catch (Exception e){
            System.err.println("Error : " + e.getMessage());
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

    public String messageCreateDonation(){
        if(this.isMessageCreateDonation){
            return "Data Donasi Berhasil Ditambahkan";
        } else {
            return "Terjadi Kesalahan ";
        }
    }

    public void config() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/donasi-tubes-pbo", "root","");
            stm = con.createStatement();
        } catch (Exception e) {
            System.err.println("Koneksi Gagal");
        }
    }
}
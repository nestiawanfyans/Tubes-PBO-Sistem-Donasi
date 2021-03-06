package sample;

import com.mysql.jdbc.Driver;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;


public class HalamanUtama extends Application{

    public int id_user = 1;

//    HalamanUtama(int id_user){
//        this.id_user = id_user;
//    }

    public static void main(String[] args) {
        launch(args);
    }
    public static Connection con; // drive connection
    public static Statement stm; // con.createStatement();
    public static ResultSet result;
    FormDonasi formDonasi = new FormDonasi();

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

    public void start(Stage primaryStage) throws SQLException, IOException {
        primaryStage.setTitle("Donasi Berkah");
        final Label label = new Label();

        System.out.println("Usern ID : " + this.id_user);

//        GridPane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
//        End of Gridpane

//        Media Content
//        Header
        label.setText("Donasi Berkah\n\n");
        label.setFont(Font.font("Quicksand", FontWeight.BOLD, 24));
        label.setTextFill(Color.GREEN);
        grid.add(label,0,0);
//        End of Header

        Hyperlink link = new Hyperlink("Buat Donasi");
        grid.add(link,0,1);
        link.setOnAction(actionEvent -> formDonasi.start(primaryStage));


        try {
            driveConnection();
            stm = con.createStatement();
            result = stm.executeQuery("select * from dataDonasi");
            int numberLeft = 0;
            int cekBerapaDataYangSudahTampil = 0;
            int i=2;
            int[] arr = {2,3,4,5,6,7};
            while (result.next()){
                //        Donasi satu
                DataDonasi donasiSatu = new DataDonasi();
                final ImageView selectedImage = new ImageView();
                Image image1 = new Image(new FileInputStream("/home/dhannypramana/Downloads/pemulung.jpg")); //IMG
                Label donasiSatuJudul = new Label();
                Text donasiSatuPenyelenggara = new Text();
                Text donasiSatuDana = new Text();
                Text donasiSatuHari = new Text();
                Button donasiSatuBtn = new Button();


                cekBerapaDataYangSudahTampil++;
                if (cekBerapaDataYangSudahTampil > 5){
                    for (i=0; i<arr.length; i++){
                        cekBerapaDataYangSudahTampil=0;
                        numberLeft=0;
                        arr[i] += 8;
                    }
                }


////                <HARUSNYA DATA>

                selectedImage.setImage(image1);
                selectedImage.setFitHeight(150);
                selectedImage.setFitWidth(200);
                grid.add(selectedImage, numberLeft,arr[0]);
//
                donasiSatuJudul.setText(result.getString(2));
                donasiSatuJudul.setFont(Font.font("Quicksand", FontWeight.LIGHT, 15));
                donasiSatuJudul.setTextFill(Color.GREEN);
                grid.add(donasiSatuJudul,numberLeft,arr[1]);
//
                donasiSatuPenyelenggara.setText(result.getString(3));
                donasiSatuPenyelenggara.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
                grid.add(donasiSatuPenyelenggara,numberLeft,arr[2]);
//
                donasiSatuDana.setText("Rp. " + donasiSatu.getDanaTerkumpul().toString() + " target " + result.getString(4).toString());
                donasiSatuDana.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
                grid.add(donasiSatuDana, numberLeft,arr[3]);
//
                donasiSatuBtn.setFont(Font.font("Quicksand",FontWeight.BOLD,12));
                donasiSatuBtn.setText("Donasi");
                grid.add(donasiSatuBtn,numberLeft,arr[4]);
//
                donasiSatuHari.setText("\t\t\t\t" + result.getString(5));
                donasiSatuHari.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
                grid.add(donasiSatuHari,numberLeft,arr[5]);
////                </HARUSNYA DATA>

                int id_donasi =  Integer.parseInt(result.getString(1));
                donasiSatuBtn.setOnAction(actionEvent -> {
                    this.id_user = 1;
                    DetailDonasi dDonasi = new DetailDonasi(id_donasi, this.id_user, false);
                    try {
                        dDonasi.start(primaryStage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                });

                numberLeft+=8;

//        End of Donasi Satu
            }

            System.out.println("berhasil");
            stm.close();

        } catch (Exception e) {
            System.err.println("koneksi gagal : " +e.getMessage());
        }

        Scene scene = new Scene(grid, 1360,720);
        primaryStage.setScene(scene);
        primaryStage.show();

//        koneksi connect = new koneksi();
//        connect.dataDonasi();
    }
}

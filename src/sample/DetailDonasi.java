package sample;

import com.mysql.jdbc.Driver;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class DetailDonasi extends Application {

    int id_donasi;
    int id_user;
    boolean success;
    Stage window;

    DetailDonasi(int id_donasi, int id_user, boolean success){
        this.id_donasi  = id_donasi;
        this.id_user    = id_user;
        this.success    = success;
    }

    HalamanUtama hUtama = new HalamanUtama();
    koneksi connect = new koneksi();


    public static Connection con; // drive connection
    public static Statement stm; // con.createStatement();
    public static ResultSet result;

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

    public static void main(String[] args) { launch(args);}

    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;
        window.setTitle("Donasi Berkah");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Hyperlink link = new Hyperlink("Halaman Utama");
        grid.add(link,0,15);
        link.setOnAction(actionEvent -> {
            try {
                hUtama.start(primaryStage);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        if(this.success != false){
            Text alertBerhasilDOnasi = new Text();
            alertBerhasilDOnasi.setText("Berhasil Berdonasi");
            alertBerhasilDOnasi.setFont(Font.font("Quicksand", FontWeight.MEDIUM, 24));
            grid.add(alertBerhasilDOnasi, 0, 16);
            this.success = false;
        }

        try {

            driveConnection();
            stm = con.createStatement();
            result = stm.executeQuery("select * from dataDonasi where id='" + this.id_donasi + "'");

            Button bayardonasi = null;
            while (result.next()) {
                DataDonasi dataDonasi = new DataDonasi();
                ImageView imageView = new ImageView();
                Image img = new Image(new FileInputStream("/home/dhannypramana/Downloads/pemulung.jpg"));

                Label label = new Label();
                label.setText("Donasi Berkah");
                label.setFont(Font.font("Quicksand", FontWeight.MEDIUM, 25));
                label.setTextFill(Color.GREEN);
                label.setAlignment(Pos.TOP_LEFT);
                label.setTextAlignment(TextAlignment.LEFT);
                grid.add(label, 0, 0);

                imageView.setImage(img);
                imageView.setFitWidth(350);
                imageView.setFitHeight(255);
                grid.add(imageView, 0, 2, 1, 1);

                Label donasiTitle = new Label();
                donasiTitle.setText(result.getString(2));
                donasiTitle.setFont(Font.font("Quicksand", FontWeight.MEDIUM, 24));
                grid.add(donasiTitle, 0, 3);

                Label donasiPenyelenggara = new Label();
                donasiPenyelenggara.setText(result.getString(3));
                donasiPenyelenggara.setTextFill(Color.SILVER);
                donasiPenyelenggara.setFont(Font.font("Quicksand", FontWeight.LIGHT, 16));
                grid.add(donasiPenyelenggara, 0, 4);


                Text donasiDana = new Text();
                donasiDana.setText("Rp. " + dataDonasi.getDanaTerkumpul().toString() + "\t Target\t" + result.getString(4).toString());
                grid.add(donasiDana, 0, 5);

                Text DeadlineDonasi = new Text();
                DeadlineDonasi.setText(result.getString(5));
                grid.add(DeadlineDonasi, 0, 7);

                bayardonasi = new Button("Donasi Sekarang");
                bayardonasi.setAlignment(Pos.CENTER);
                bayardonasi.setMaxWidth(300);
                bayardonasi.setStyle("-fx-background-color: #00FF00; ");
                grid.add(bayardonasi, 0, 6);

                Text Deskripsi = new Text();
                Deskripsi.setText("Deskripsi");
                Deskripsi.setFont(Font.font("Quicksand", FontWeight.MEDIUM, 24));
                grid.add(Deskripsi, 0, 10);

                Label textArea = new Label();
                textArea.setWrapText(true);
                textArea.setFont(Font.font("Quicksand", FontWeight.LIGHT, 16));
                textArea.setLineSpacing(1.5);
                textArea.setAlignment(Pos.CENTER);
                textArea.setText(result.getString(6));
                grid.add(textArea, 0, 12);
            }

            bayardonasi.setOnAction(actionEvent -> {
                JumlahDonasi bayarDonasi = new JumlahDonasi(this.id_donasi, this.id_user);
                bayarDonasi.start(primaryStage);
            });


        }catch (Exception e) {
            System.err.println("Error Detail Donasi : " + e.getMessage());
        }

        Scene scene = new Scene(grid, 960,1024);
        window.setScene(scene);
        window.show();

    }
}

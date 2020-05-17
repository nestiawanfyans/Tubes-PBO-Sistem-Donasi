package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import java.io.IOException;

public class HalamanUtama extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Donasi Berkah");
        final Label label = new Label();

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
        grid.add(label,1,0);
//        End of Header

//        Donasi satu
        DataDonasi donasiSatu = new DataDonasi();
        final ImageView selectedImage = new ImageView();
        Image image1 = new Image(new FileInputStream("/home/dhannypramana/Downloads/pemulung.jpg"));
        Label donasiSatuJudul = new Label();
        Text donasiSatuPenyelenggara = new Text();
        Text donasiSatuDana = new Text();
        Text donasiSatuHari = new Text();
        Button donasiSatuBtn = new Button("Donasi");

        selectedImage.setImage(image1);
        selectedImage.setFitHeight(150);
        selectedImage.setFitWidth(200);
        grid.add(selectedImage, 1,1);

        donasiSatuJudul.setText(donasiSatu.getJudulDonasi());
        donasiSatuJudul.setFont(Font.font("Quicksand", FontWeight.LIGHT, 15));
        donasiSatuJudul.setTextFill(Color.GREEN);
        grid.add(donasiSatuJudul,1,2);

        donasiSatuPenyelenggara.setText(donasiSatu.getPenyelenggara());
        donasiSatuPenyelenggara.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
        grid.add(donasiSatuPenyelenggara,1,3);

        donasiSatuDana.setText("Rp. " + donasiSatu.getDanaTerkumpul().toString() + " target " + donasiSatu.getDanaTarget().toString());
        donasiSatuDana.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
        grid.add(donasiSatuDana, 1,4);

        donasiSatuBtn.setFont(Font.font("Quicksand",FontWeight.BOLD,12));
        grid.add(donasiSatuBtn,1,5);

        donasiSatuHari.setText("\t\t\t\t" + donasiSatu.getTargethari() + " Hari lagi");
        donasiSatuHari.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
        grid.add(donasiSatuHari,1,5);
//        End of Donasi Satu

//        Donasi Dua
        DataDonasi donasiDua = new DataDonasi();
        final ImageView selectedImage2 = new ImageView();
        Image image2 = new Image(new FileInputStream("/home/dhannypramana/Downloads/pemulung.jpg"));
        Label donasiDuaJudul = new Label();
        Text donasiDuaPenyelenggara = new Text();
        Text donasiDuaDana = new Text();
        Text donasiDuaHari = new Text();
        Button donasiDuaBtn = new Button("Donasi");

        selectedImage2.setImage(image2);
        selectedImage2.setFitHeight(150);
        selectedImage2.setFitWidth(200);
        grid.add(selectedImage2, 20,1);

        donasiDuaJudul.setText(donasiDua.getJudulDonasi());
        donasiDuaJudul.setFont(Font.font("Quicksand", FontWeight.LIGHT, 15));
        donasiDuaJudul.setTextFill(Color.GREEN);
        grid.add(donasiDuaJudul,20,2);

        donasiDuaPenyelenggara.setText(donasiDua.getPenyelenggara());
        donasiDuaPenyelenggara.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
        grid.add(donasiDuaPenyelenggara,20,3);

        donasiDuaDana.setText("Rp. " + donasiDua.getDanaTerkumpul().toString() + " target " + donasiDua.getDanaTarget().toString());
        donasiDuaDana.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
        grid.add(donasiDuaDana, 20,4);

        donasiDuaBtn.setFont(Font.font("Quicksand",FontWeight.BOLD,12));
        grid.add(donasiDuaBtn,20,5);

        donasiDuaHari.setText("\t\t\t\t" + donasiDua.getTargethari() + " Hari lagi");
        donasiDuaHari.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
        grid.add(donasiDuaHari,20,5);
//        End of Donasi Dua

//        Donasi Tiga
//        End of donasi Tiga

//        Donasi Empat
//        End of Donasi Empat

//        End of media Content

//        Back End Start
//        End of Back End

        Scene scene = new Scene(grid, 800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

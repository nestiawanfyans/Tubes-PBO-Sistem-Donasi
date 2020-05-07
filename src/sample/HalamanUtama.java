package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.Button;
=======
>>>>>>> 999b7e932caaf81748d8fef5248ef67fe8e52a88
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
<<<<<<< HEAD
import javafx.scene.layout.VBox;
=======
>>>>>>> 999b7e932caaf81748d8fef5248ef67fe8e52a88
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class HalamanUtama extends Application{

    public static void main(String[] args) {
        launch(args);
    }
<<<<<<< HEAD

=======
>>>>>>> 999b7e932caaf81748d8fef5248ef67fe8e52a88
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Donasi Berkah");
        final Label label = new Label();

//        GridPane
        GridPane grid = new GridPane();
<<<<<<< HEAD
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
=======
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setPadding(new Insets(20));
//        End of Gridpane

//        Media Content
        label.setText("Donasi Berkah");
        label.setFont(Font.font("Quicksand", FontWeight.MEDIUM, 25));
        label.setTextFill(Color.GREEN);
        label.setAlignment(Pos.TOP_LEFT);
        label.setTextAlignment(TextAlignment.LEFT);
        grid.add(label,0,0);

//        Donasi satu
        final ImageView selectedImage = new ImageView();
        Image image1 = new Image(new FileInputStream("/home/dhannypramana/Downloads/pemulung.jpg"));
        selectedImage.setImage(image1);
        selectedImage.setFitHeight(150);
        selectedImage.setFitWidth(200);
        grid.add(selectedImage, 0,1);

        Label donasiSatuLabel = new Label();
        donasiSatuLabel.setText("Anak yang Terlantar");
        grid.add(donasiSatuLabel,0,2);

        Text donasiSatuPenyelenggara = new Text("Rumah Yatim");
        donasiSatuPenyelenggara.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
        grid.add(donasiSatuPenyelenggara,0,3);
//        End of Donasi Satu

//        Donasi Dua
        final ImageView selectedImage2 = new ImageView();
        Image image2 = new Image(new FileInputStream("/home/dhannypramana/Downloads/pemulung.jpg"));
        selectedImage2.setImage(image2);
        selectedImage2.setFitHeight(150);
        selectedImage2.setFitWidth(200);
        grid.add(selectedImage2, 17,1);

        Label donasiDuaJudul = new Label();
        donasiDuaJudul.setText("Anak Yang terlantar");
        grid.add(donasiDuaJudul,17,2);

        Text donasiDuaPenyelenggara = new Text("Rumah Yatim");
        donasiDuaPenyelenggara.setFont(Font.font("Quicksand", FontWeight.LIGHT, 12));
        grid.add(donasiDuaPenyelenggara,17,3);
>>>>>>> 999b7e932caaf81748d8fef5248ef67fe8e52a88
//        End of Donasi Dua

//        Donasi Tiga
//        End of donasi Tiga

<<<<<<< HEAD
//        Donasi Empat
//        End of Donasi Empat

=======
>>>>>>> 999b7e932caaf81748d8fef5248ef67fe8e52a88
//        End of media Content

//        Back End Start
//        End of Back End

<<<<<<< HEAD
        Scene scene = new Scene(grid, 800,600);
=======
        Scene scene = new Scene(grid, 800,500);
>>>>>>> 999b7e932caaf81748d8fef5248ef67fe8e52a88
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

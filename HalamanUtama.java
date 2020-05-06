package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

import java.awt.*;
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
//        End of Donasi Dua

//        Donasi Tiga
//        End of donasi Tiga

//        End of media Content

//        Back End Start
//        End of Back End

        Scene scene = new Scene(grid, 800,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

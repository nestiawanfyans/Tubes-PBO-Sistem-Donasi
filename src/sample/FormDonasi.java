package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.text.FontWeight.LIGHT;
import static javafx.scene.text.FontWeight.MEDIUM;

public class FormDonasi extends Application {
    Stage window;
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("Donasi Berkah");

//        GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setVgap(10);
        grid.setVgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
//        End of Gridpane

//        Media Content
        Text headingtext = new Text("\t\t  Donasi Berkah");
        headingtext.setFont(Font.font("Tahoma", MEDIUM, 25));
        headingtext.setFill(Color.GREEN);
        grid.add(headingtext, 0,0);

        Text text = new Text("\t\t\tMasukkan Data Donasi Anda");
        text.setFont(Font.font("Tahoma", LIGHT, 16));
        text.setFill(Color.GREEN);
        grid.add(text, 0,3);

        TextField txtJudul = new TextField();
        txtJudul.setPromptText("Judul Donasi ");
        grid.add(txtJudul,0,5);

        TextField penyelenggara = new TextField();
        penyelenggara.setPromptText("Penyelenggara");
        grid.add(penyelenggara, 0, 6);

        TextField targetDonasi = new TextField();
        targetDonasi.setPromptText("Target Donasi");
        grid.add(targetDonasi, 0, 7);

        TextField targetHari = new TextField();
        targetHari.setPromptText("Lama Mencari Donasi (Dalam Hari)");
        grid.add(targetHari, 0, 8);

        TextArea deskripsi = new TextArea();
        deskripsi.setPromptText("Deskripsi Donasi");
        deskripsi.setWrapText(true);
        grid.add(deskripsi,0,9);

        Button nextBtn = new Button("Lanjut Berdonasi");
        nextBtn.setMaxHeight(200);
        nextBtn.setMaxWidth(500);
        nextBtn.setStyle("-fx-background-color: #00FF00; ");
        grid.add(nextBtn, 0,10);

        Scene scene = new Scene(grid,800,600);
        window.setScene(scene);
        window.show();
    }

}

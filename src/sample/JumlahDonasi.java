package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


//import java.awt.event.ActionEvent;
//import java.beans.EventHandler;

public class JumlahDonasi extends Application {

    public int id_donasi;
    public int id_user;
    int jmlhDonasi = 0;
    Stage window;
    String userInput;
    koneksi connect = new koneksi();

    JumlahDonasi(int id_donasi, int id_user){
        this.id_donasi  = id_donasi;
        this.id_user    = id_user;
    }

    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("Donasi Berkah");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        DetailDonasi detailDonasi = new DetailDonasi(this.id_donasi, this.id_user);
        Hyperlink link = new Hyperlink("Kembali");
        grid.add(link,0,15);
        link.setOnAction(actionEvent -> {
            try {
                detailDonasi.start(primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        Text headingText = new Text("Masukkan Nominal Donasi");
        headingText.setFill(Color.GREEN);
        headingText.setFont(Font.font("Quicksand", FontWeight.BOLD,24));
        grid.add(headingText,1,0);

        Button nominalButton1=new Button("Rp. 10.000");
        Button nominalButton2=new Button("Rp. 50.000");
        Button nominalButton3=new Button("Rp. 100.000");
        Button nominalButton4=new Button("Rp. 250.000");
        Button nominalButton5=new Button("Rp. 500.000");
        Button nominalButton6=new Button("Rp. 1.000.000");

        grid.add(nominalButton1,0,2,1,1);
        grid.add(nominalButton2,1,2,1,1);
        grid.add(nominalButton3,2,2,1,1);
        grid.add(nominalButton4,0,3,1,1);
        grid.add(nominalButton5,1,3,1,1);
        grid.add(nominalButton6,2,3,1,1);

        nominalButton1.setMaxWidth(200);
        nominalButton2.setMaxWidth(400);
        nominalButton3.setMaxWidth(200);
        nominalButton4.setMaxWidth(200);
        nominalButton5.setMaxWidth(400);
        nominalButton6.setMaxWidth(200);

        //Start of Back-End Button
        Alert alertBtn =new Alert(AlertType.NONE,"",ButtonType.OK);
        nominalButton1.setOnAction(actionEvent -> {
            jmlhDonasi = 0000;
            connect.insertJumlahDonasi(this.id_donasi, this.id_user, this.jmlhDonasi);
        });
        nominalButton2.setOnAction(actionEvent -> {
            jmlhDonasi = 50000;
            connect.insertJumlahDonasi(this.id_donasi, this.id_user, this.jmlhDonasi);
        });
        nominalButton3.setOnAction(actionEvent -> {
            jmlhDonasi = 100000;
            connect.insertJumlahDonasi(this.id_donasi, this.id_user, this.jmlhDonasi);
        });
        nominalButton4.setOnAction(actionEvent -> {
            jmlhDonasi = 250000;
            connect.insertJumlahDonasi(this.id_donasi, this.id_user, this.jmlhDonasi);
        });
        nominalButton5.setOnAction(actionEvent -> {
            jmlhDonasi = 500000;
            connect.insertJumlahDonasi(this.id_donasi, this.id_user, this.jmlhDonasi);
        });
        nominalButton6.setOnAction(actionEvent -> {
            jmlhDonasi = 1000000;
            connect.insertJumlahDonasi(this.id_donasi, this.id_user, this.jmlhDonasi);
        });
        //End of Back-End Button

        Text text =new Text("Masukkan Nominal Donasi Lain :");
        text.setFont(Font.font("Quicksand",FontWeight.LIGHT,14));
        grid.add(text,0,8,2,1);

        Label rupiah = new Label("Rp");
        rupiah.setFont(Font.font("Quicksand",FontWeight.BOLD,14));
        grid.add(rupiah,0,10);

        TextField nominalInput = new TextField();
        nominalInput.setPromptText("0");
        grid.add(nominalInput,1,10,2,1);
        nominalInput.setMaxWidth(600);
        userInput = nominalInput.getText().toString();

        Button donasiBtn = new Button("Donasi");
        donasiBtn.setFont(Font.font("Quicksand",FontWeight.BOLD,14));
        donasiBtn.setMaxHeight(400);
        donasiBtn.setMaxWidth(500);
        donasiBtn.setStyle("-fx-background-color: #00FF00; ");
        grid.add(donasiBtn, 0,12,3,2);

        //Start Back-End Donasi Button
//        donasiBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                userInput = nominalInput.getText().toString();
//                Alert alert = new Alert(Alert.AlertType.NONE, " ",ButtonType.OK);
//                alert.setTitle("Informasi");
//                alert.setContentText("Donasi Sejumlah Rp. "+ userInput+ " Berhasil");
//                alert.show();
//            }
//        });
        //End Back-End Donasi Button

//        donasiBtn.setOnAction(actionEvent -> {
//            connect.insertJumlahDonasi(this.id_donasi, this.id_user, this.jmlhDonasi);
//            DetailDonasi dDonasi = new DetailDonasi(this.id_donasi, this.id_user);
//            try {
//                dDonasi.start(primaryStage);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        });


        Scene scene = new Scene(grid, 800,400);
        window.setScene(scene);
        window.show();

    }

}
package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javafx.scene.text.FontWeight.*;

class Login{
    private String checkUser, checkPW;
    private String nama,username,password;

    public void sendData(String nama, String username,String password){
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public void start(Stage primaryStage){
        primaryStage.setTitle("Login");
        Daftar daftar = new Daftar();
//        GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
//        End of Gridpane

//        Media Content
        Text headingtext = new Text("\tDonasi Berkah");
        headingtext.setFont(Font.font("Tahoma", MEDIUM, 25));
        grid.add(headingtext, 0,0);

        Text text = new Text("Masukkan Data diri anda terlebih dahulu untuk berdonasi");
        text.setFont(Font.font("Tahoma", LIGHT, 12));
        grid.add(text, 0,1);

        TextField txtUser = new TextField();
        txtUser.setPromptText("Username");
        grid.add(txtUser, 0, 5);

        PasswordField passUser = new PasswordField();
        passUser.setPromptText("Password");
        grid.add(passUser, 0,6);

        Button nextBtn = new Button("Lanjut Berdonasi");
        nextBtn.setMaxHeight(200);
        nextBtn.setMaxWidth(500);
        nextBtn.setStyle("-fx-background-color: #00FF00; ");
        grid.add(nextBtn, 0,7);

        Hyperlink link = new Hyperlink("Daftar");
        grid.add(link, 0,10);
//        End of Media Content
        Label label = new Label();

//        Back-End Start
        nextBtn.setOnAction(actionEvent -> {
            checkUser = txtUser.getText();
            checkPW = passUser.getText();

            if(checkUser.equals(username) && checkPW.equals(password)){
                label.setText("Login Sukses!");
                label.setTextFill(Color.GREEN);
            }else{
                label.setText("Login Gagal!");
                label.setTextFill(Color.RED);
            }
            grid.add(label,0,12);
        });

        link.setOnAction(actionEvent -> daftar.start(primaryStage));
//        End of Back-End

        Scene scene = new Scene(grid,600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
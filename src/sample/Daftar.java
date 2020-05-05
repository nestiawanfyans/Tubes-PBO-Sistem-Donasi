package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import static javafx.scene.text.FontWeight.*;

public class Daftar extends Application{
    private String nama;
    private String username;
    private String password;

    public static void main(String[] args) {
        launch(args);
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getNama(){
        return this.nama;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    public void start(Stage primaryStage){
        primaryStage.setTitle("Daftar");
        final Label label = new Label();

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

        Text text = new Text("Tambahkan Data diri anda terlebih dahulu untuk berdonasi");
        text.setFont(Font.font("Tahoma", LIGHT, 12));
        grid.add(text, 0,1);

        TextField txtNama = new TextField();
        txtNama.setPromptText("Nama Lengkap");
        grid.add(txtNama,0,5);

        TextField txtUser = new TextField();
        txtUser.setPromptText("Username");
        grid.add(txtUser, 0, 6);

        PasswordField passUser = new PasswordField();
        passUser.setPromptText("Password");
        grid.add(passUser, 0,7);

        Button nextBtn = new Button("Lanjut Berdonasi");
        nextBtn.setMaxHeight(200);
        nextBtn.setMaxWidth(500);
        nextBtn.setStyle("-fx-background-color: #00FF00; ");
        grid.add(nextBtn, 0,8);

        Hyperlink link = new Hyperlink("Login");
        grid.add(link,0,10);
//        End of media Content

//        Back-End Start
        Login login = new Login();

        nextBtn.setOnAction(actionEvent -> {
            setNama(txtNama.getText());
            setUsername(txtUser.getText());
            setPassword(passUser.getText());

            login.sendData(getNama(),getUsername(),getPassword());

            label.setText("Data Sudah terisi, Silahkan Login!");
            label.setTextFill(Color.GREEN);
            grid.add(label,0,11);
        });

        link.setOnAction(actionEvent -> login.start(primaryStage));
//        End of back-End

        Scene scene = new Scene(grid, 600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

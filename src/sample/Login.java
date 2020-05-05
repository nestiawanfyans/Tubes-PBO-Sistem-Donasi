package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.scene.text.FontWeight.*;

public class Login extends Application{
    Stage window;
    String user = "Dhanny";
    String pw = "password";
    String checkUser, checkPW;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Daftar daftar = new Daftar();

        window = primaryStage;
        window.setTitle("Login");

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
        nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                checkUser = txtUser.getText().toString();
                checkPW = passUser.getText().toString();

                if (checkUser.equals(user) && checkPW.equals(pw)){
                    label.setText("Login Sukses!");
                    label.setTextFill(Color.GREEN);
                    grid.add(label,0,12);
                }else{
                    label.setText("Login Gagal!");
                    label.setTextFill(Color.RED);
                    grid.add(label,0,12);
                }
            }
        });

        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                daftar.p(primaryStage);
            }
        });
//        End of Back-End

        Scene scene = new Scene(grid,600, 400);
        window.setScene(scene);
        window.show();
    }
}
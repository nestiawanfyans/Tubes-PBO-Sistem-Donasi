package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.scene.text.FontWeight.*;

public class Daftar extends Login{
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public void p(Stage primaryStage){
        Login login = new Login();

        window = primaryStage;
        window.setTitle("Daftar");

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
        txtUser.setPromptText("Email");
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
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                login.start(primaryStage);
            }
        });
//        End of back-End

        Scene scene = new Scene(grid, 600,400);
        window.setScene(scene);
        window.show();
    }
}

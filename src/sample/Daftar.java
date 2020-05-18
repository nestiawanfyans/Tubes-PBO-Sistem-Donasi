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
        primaryStage.setTitle("Donasi B erkah");

        final Label label = new Label();
//        GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setVgap(10);
        grid.setVgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
//        End of Gridpane

//        Media Content
        Text headingtext = new Text("\tDonasi Berkah");
        headingtext.setFont(Font.font("Tahoma", MEDIUM, 25));
        headingtext.setFill(Color.GREEN);
        grid.add(headingtext, 0,0);

        Text text = new Text("Tambahkan Data diri anda terlebih dahulu untuk berdonasi");
        text.setFont(Font.font("Tahoma", LIGHT, 12));
        text.setFill(Color.GREEN);
        grid.add(text, 0,1);

        TextField txtNama = new TextField();
        txtNama.setPromptText("Nama Lengkap");
        grid.add(txtNama,0,5);

        TextField txtUser = new TextField();
        txtUser.setPromptText("Username");
        grid.add(txtUser, 0, 6);

        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Emil");
        grid.add(txtEmail, 0, 7);

        PasswordField passUser = new PasswordField();
        passUser.setPromptText("Password");
        grid.add(passUser, 0,8);

        Button nextBtn = new Button("Lanjut Berdonasi");
        nextBtn.setMaxHeight(200);
        nextBtn.setMaxWidth(500);
        nextBtn.setStyle("-fx-background-color: #00FF00; ");
        grid.add(nextBtn, 0,10);

        Hyperlink link = new Hyperlink("Sudah Punya Akun? Login");
        grid.add(link,0,11);
//        End of media Content

//        Back-End Start
        Login login = new Login();
        Alert alertBtn =new Alert(Alert.AlertType.NONE,"",ButtonType.OK);

        nextBtn.setOnAction(actionEvent -> {
            //data
            String nama         = txtNama.getText();
            String username     = txtUser.getText();
            String email        = txtEmail.getText();
            String pass         = passUser.getText();

            // insert data in database. DriverCOnnection - stm;
            koneksi koneksiQuery = new koneksi();
            koneksiQuery.createUser(nama, username, email, pass);

            // get Message success or fail in insert data.
            alertBtn.setTitle("Informasi");
            alertBtn.setContentText(koneksiQuery.messageCreateUser());
            alertBtn.show();
        });

        link.setOnAction(actionEvent -> login.start(primaryStage));
//        End of back-End
        Scene scene = new Scene(grid, 800,400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

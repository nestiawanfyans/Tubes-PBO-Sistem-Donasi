package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DetailDonasi extends Application {
    Stage window;

    public static void main(String[] args) { launch(args);}

    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;
        window.setTitle("Donasi Berkah");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(10));

        ImageView imageView = new ImageView();
        Image img = new Image(new FileInputStream("/home/dhannypramana/Downloads/pemulung.jpg"));

        Label label = new Label();
        label.setText("Donasi Berkah");
        label.setFont(Font.font("Quicksand", FontWeight.MEDIUM, 25));
        label.setTextFill(Color.GREEN);
        label.setAlignment(Pos.TOP_LEFT);
        label.setTextAlignment(TextAlignment.LEFT);
        grid.add(label,0,0);

        imageView.setImage(img);
        imageView.setFitWidth(720);
        imageView.setFitHeight(405);
        grid.add(imageView,0,2,1,1);

        Label donasiTitle = new Label();
        donasiTitle.setText("Anak yang Terlantar");
        donasiTitle.setFont(Font.font("Quicksand",FontWeight.MEDIUM,24));
        grid.add(donasiTitle,0,3);

        Label donasiLoc = new Label();
        donasiLoc.setText("Rumah Yatim");
        donasiLoc.setTextFill(Color.SILVER);
        donasiLoc.setFont(Font.font("Quicksand",FontWeight.LIGHT,16));
        grid.add(donasiLoc,0,4);

        Button donasiBtn = new Button("Donasi Sekarang");
        donasiBtn.setAlignment(Pos.CENTER);
        donasiBtn.setMaxWidth(300);
        donasiBtn.setStyle("-fx-background-color: #00FF00; ");
        grid.addRow(6,donasiBtn);

        Text Deskripsi = new Text();
        Deskripsi.setText("Deskripsi");
        Deskripsi.setFont(Font.font("Quicksand",FontWeight.MEDIUM,24));
        grid.add(Deskripsi,0,10);

        Label textArea = new Label();
        textArea.setWrapText(true);
        textArea.setFont(Font.font("Quicksand",FontWeight.LIGHT,16));
        textArea.setLineSpacing(1.5);
        textArea.setAlignment(Pos.CENTER);
        textArea.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                "It has survived not only five centuries, but also the leap into electronic typesetting," +
                "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        grid.add(textArea,0,12);

        Label textArea2 = new Label();
        textArea2.setWrapText(true);
        textArea2.setFont(Font.font("Quicksand",FontWeight.LIGHT,16));
        textArea2.setLineSpacing(1.5);
        textArea2.setAlignment(Pos.CENTER);
        textArea2.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                "It has survived not only five centuries, but also the leap into electronic typesetting," +
                "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        grid.add(textArea2,0,14);


        Scene scene = new Scene(grid, 960,1024);
        window.setScene(scene);
        window.show();

    }
}

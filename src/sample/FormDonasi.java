package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;

import static javafx.scene.text.FontWeight.LIGHT;
import static javafx.scene.text.FontWeight.MEDIUM;

public class FormDonasi extends Application {
    Stage window;
    private String title;
    private String penyelenggara;
    private int targetDonasi;
    private int targetHari;
    private String deskripsi;

    public static void main(String[] args){launch();}
    public void setTitle(String title){
        this.title=title;
    }
    public void setPenyelenggara(String penyelenggara){
        this.penyelenggara = penyelenggara;
    }
    public void setTargetDonasi(int targetDonasi){
        this.targetDonasi = targetDonasi;
    }
    public void  setTargetHari(int targetHari){
        this.targetHari = targetHari;
    }
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }

    public String getTitle(){
        return this.title;
    }
    public String getPenyelenggara(){
        return this.penyelenggara;
    }
    public int getTargetDonasi(){
        return this.targetDonasi;
    }
    public int getTargetHari(){
        return this.targetHari;
    }
    public String getDeskripsi(){
        return this.deskripsi;
    }

    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("Donasi Berkah");

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

        TextField txtPenyelenggara = new TextField();
        txtPenyelenggara.setPromptText("Penyelenggara");
        grid.add(txtPenyelenggara, 0, 6);

        TextField txtTargetDonasi = new TextField();
        txtTargetDonasi.setPromptText("Target Donasi");
        grid.add(txtTargetDonasi, 0, 7);
//        int tgtDonasi   = Integer.parseInt(String.valueOf(txtTargetDonasi));

        DatePicker picker =new DatePicker();
        HBox hBox = new HBox(picker);
        picker.setPromptText("Lama Mencari Donasi");

        grid.add(hBox,0,8);

        TextArea txtDeskripsi = new TextArea();
        txtDeskripsi.setPromptText("Deskripsi Donasi");
        txtDeskripsi.setWrapText(true);
        grid.add(txtDeskripsi,0,10);

        Button nextBtn = new Button("Lanjut Berdonasi");
        nextBtn.setMaxHeight(200);
        nextBtn.setMaxWidth(500);
        nextBtn.setStyle("-fx-background-color: #00FF00; ");
        grid.add(nextBtn, 0,11);
//        End of Media content

//      Back-End Start
        nextBtn.setOnAction(actionEvent ->{
//            tgtDonasi               = tgtDonasi.get
            int tgtDonasi           = Integer.parseInt(txtTargetDonasi.getText());
            LocalDate value         = picker.getValue();
            String title            = txtJudul.getText();
            String penyelenggara    = txtPenyelenggara.getText();
            String deskripsi        = txtDeskripsi.getText();

//            System.out.println(tgtDonasi);
//            System.out.println(value);
//            System.out.println(title);
//            System.out.println(penyelenggara);
//            System.out.println(deskripsi);
            koneksi koneksiDonasi = new koneksi();
            koneksiDonasi.createDonation(title,penyelenggara, tgtDonasi, value,deskripsi);

            label.setText(koneksiDonasi.messageCreateDonation());
            label.setTextFill(Color.GREEN);
            grid.add(label,0,12);
        });

//        End of Back-end


        Scene scene = new Scene(grid,800,600);
        window.setScene(scene);
        window.show();
    }

}

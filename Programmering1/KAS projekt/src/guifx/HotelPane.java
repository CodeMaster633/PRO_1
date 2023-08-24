package guifx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class HotelPane extends GridPane {

    public HotelPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblHotel = new Label("Opret Hotel");
        this.add(lblHotel, 0, 0);
        Label lblUdvikling = new Label("--Under Udvikling!--");
        this.add(lblUdvikling, 1, 0);

        Label lblNavn = new Label("Navn:");
        this.add(lblNavn, 0, 1);
        TextField txfNavn = new TextField();
        this.add(txfNavn, 1, 1);

        Label lblAdresse = new Label("Adresse:");
        this.add(lblAdresse, 0, 2);
        TextField txfAdresse = new TextField();
        this.add(txfAdresse, 1, 2);

        Label lblTlf = new Label("Tlf nr:");
        this.add(lblTlf, 0, 3);
        TextField txfTlf = new TextField();
        this.add(txfTlf, 1, 3);

        Label lblPrisEnkelt = new Label("Pris enkeltværelse:");
        this.add(lblPrisEnkelt, 0, 4);
        TextField txfPrisEnkelt = new TextField();
        this.add(txfPrisEnkelt, 1, 4);

        Label lblPrisDobbelt = new Label("Pris dobbeltværelse:");
        this.add(lblPrisDobbelt, 0, 5);
        TextField txfPrisDobbelt = new TextField();
        this.add(txfPrisDobbelt, 1, 5);

        Label lblTilvalg = new Label("Tilvalg:");
        this.add(lblTilvalg, 0, 6);
        ListView lvwTilvalg = new ListView();
        lvwTilvalg.setPrefHeight(80);
        this.add(lvwTilvalg, 1, 6);

        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 2, 7);
    }

    public void updateControls() {
    }
}

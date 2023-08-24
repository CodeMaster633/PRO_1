package guifx;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class KonferencePane extends GridPane {

    public KonferencePane(){
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
        this.setPrefSize(500,300);

        Label lblKonf = new Label("Opret Konference");
        this.add(lblKonf, 0, 0);
        Label lblUdvikling = new Label("--Under Udvikling!--");
        this.add(lblUdvikling, 1, 0);

        Label lblNavn = new Label("Navn:");
        this.add(lblNavn, 0, 1);
        TextField txfNavn = new TextField();
        this.add(txfNavn,1,1);

        Label lblStart = new Label("Startdato:");
        this.add(lblStart, 0, 2);
        TextField txfStart = new TextField();
        this.add(txfStart,1,2);

        Label lblSlut = new Label("Slutdato:");
        this.add(lblSlut, 0, 3);
        TextField txfSlut = new TextField();
        this.add(txfSlut,1,3);

        Label lblPris = new Label("Pris:");
        this.add(lblPris, 0, 4);
        TextField txfPris = new TextField();
        this.add(txfPris,1,4);

        Label lblHotel = new Label("Hoteller:");
        this.add(lblHotel, 0, 5);
        ListView lvwHotel = new ListView();

        lvwHotel.setPrefHeight(80);
        this.add(lvwHotel,1,5);

        Button btnOpret = new Button("Opret");
        this.add(btnOpret,2,6);
    }

    public void updateControls() {
    }
}

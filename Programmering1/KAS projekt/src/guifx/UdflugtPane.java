package guifx;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class UdflugtPane extends GridPane {

    public UdflugtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblUdflugt = new Label("Opret Udflugt");
        this.add(lblUdflugt, 0, 0);
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

        Label lblPris = new Label("Pris:");
        this.add(lblPris, 0, 3);
        TextField txfPris = new TextField();
        this.add(txfPris, 1, 3);

        Label lblKonference = new Label("Konference:");
        this.add(lblKonference, 0, 6);
        ListView lvwKonference = new ListView();
        lvwKonference.setPrefHeight(80);
        this.add(lvwKonference, 1, 6);

        Label lblFrokost = new Label("Frokost:");
        this.add(lblFrokost, 0, 7);
        CheckBox chbFrokost = new CheckBox();
        this.add(chbFrokost,1,7);

        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 2, 8);
    }
    public void updateControls() {
    }
}

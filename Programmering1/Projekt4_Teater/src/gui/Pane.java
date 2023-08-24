
package gui;

import application.controller.Controller;
import application.model.Bestilling;
import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pane extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Teater bestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------
    // LISTVIEWS
    private final ListView lvwForestillinger = new ListView();
    private final ListView lvwKunder = new ListView();
    private final ListView lvwPladser = new ListView();


    //---------------------------------------------------------------------------------
    // LABELS
    private final Label lblForestillinger = new Label("Forestillinger");
    private final Label lblKunder = new Label("Kunder");
    private final Label lblPladser = new Label("Pladser");


    private final Label lblFNavn = new Label("Navn");
    private final Label lblStartDato = new Label("Start dato");
    private final Label lblSlutDato = new Label("Slut dato");

    private final Label lblKundeNavn = new Label("Kunde navn");
    private final Label lblKundeMobil = new Label("Kunde mobil");

    private final Label lblDato = new Label("Dato");


    //--------------------------------------------------------------
    // TEXTFIELDS
    private final TextField txfFNavn = new TextField();
    private final TextField txfStartDato = new TextField();
    private final TextField txfSlutDato = new TextField();
    private final TextField txfKundeNavn = new TextField();
    private final TextField txfKundeMobil = new TextField();
    private final TextField txfDato = new TextField();


    //-------------------------------------------------------------
    //BUTTONS
    private final Button btnOpretForestilling = new Button();
    private final Button btnOpretKunde = new Button();
    private final Button btnOpretBestilling = new Button();


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);


        btnOpretForestilling.setText("Opret forestilling");
        btnOpretKunde.setText("Opret Kunde");
        btnOpretBestilling.setText("Opret Bestilling");

        pane.add(lblForestillinger, 0, 0);
        pane.add(lblKunder, 2, 0);
        pane.add(lblPladser, 4, 0);

        pane.add(lvwForestillinger, 0, 1, 2, 2);
        pane.add(lvwKunder, 2, 1, 2, 2);
        pane.add(lvwPladser, 4, 1, 2, 2);


        pane.add(lblFNavn, 0, 3);
        pane.add(lblStartDato, 0, 4);
        pane.add(lblSlutDato, 0, 5);
        pane.add(lblKundeNavn, 2, 3);
        pane.add(lblKundeMobil, 2, 4);
        pane.add(lblDato, 4, 3);


        pane.add(txfFNavn, 1, 3);
        pane.add(txfKundeNavn, 3, 3);
        pane.add(txfStartDato, 1, 4);
        pane.add(txfKundeMobil, 3, 4);
        pane.add(txfSlutDato, 1, 5);
        pane.add(txfDato, 5, 3);


        pane.add(btnOpretForestilling, 1, 6);
        pane.add(btnOpretKunde, 3, 5);
        pane.add(btnOpretBestilling, 5, 4);

        btnOpretForestilling.setOnAction(event -> btnOpretForestilling());
        btnOpretKunde.setOnAction(event -> btnOpretKunde());
        btnOpretBestilling.setOnAction(event -> btnOpretBestilling());

        lvwForestillinger.getItems().setAll(Controller.getForestillinger());
        lvwKunder.getItems().setAll(Controller.getKunder());
        lvwPladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwPladser.getItems().setAll(Controller.getPladser());

    }

    private void btnOpretBestilling() {
        if (txfDato.getText().equals("")) {
            System.out.println("jaja");
            popUpError();
        }

        LocalDate dato = LocalDate.parse(txfDato.getText());
        Forestilling forestilling = (Forestilling) lvwForestillinger.getSelectionModel().getSelectedItem();
        Kunde kunde = (Kunde) lvwKunder.getSelectionModel().getSelectedItem();
        ArrayList<Plads> pladser = new ArrayList<Plads>(lvwPladser.getSelectionModel().getSelectedItems());

        if (forestilling == null || kunde == null || pladser == null) {
            popUpError();
            return;
        }
        popUp(Controller.opretBestillingMedPladser(forestilling, kunde, dato, pladser));
        txfDato.clear();
    }


    public void btnOpretForestilling() {
        String navn = txfFNavn.getText();
        LocalDate dato = LocalDate.parse(txfStartDato.getText());
        LocalDate slutDato = LocalDate.parse(txfSlutDato.getText());
        Controller.createForestilling(navn, dato, slutDato);
        lvwForestillinger.getItems().setAll(Controller.getForestillinger());
        txfFNavn.clear();
        txfSlutDato.clear();
        txfStartDato.clear();

    }

    public void btnOpretKunde() {
        String navn = txfKundeNavn.getText();
        String mobilNummer = txfKundeMobil.getText();
        Controller.createKunde(navn, mobilNummer);
        lvwKunder.getItems().setAll(Controller.getKunder());
        txfKundeNavn.clear();
        txfKundeMobil.clear();
    }

    public static void popUp(Bestilling bestilling) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Bestilling oprettet");
        alert.setContentText("Bestilling oprettet for " + bestilling.getKunde().getNavn() + " til " + bestilling.getForestilling().getNavn() + " d. " + bestilling.getDate() + " med pladserne " + bestilling.getPladser().size());
        alert.showAndWait();
    }

    private void popUpError() {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Bestilling ikke oprettet");
        alert.setContentText("Der er opstået en fejl - Prøv igen.");
        alert.showAndWait();
    }


}

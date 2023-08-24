package guifx;

import application.controller.Controller;
import application.model.Frivillig;
import application.model.Job;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import storage.Storage;

import java.util.ArrayList;

public class TilmeldingsPane extends GridPane {
    private TextField txfNavn;
    private TextField txfAdresse;
    private TextField txfTlf;
    private TextField txfLand;
    private ListView<Job> lvwJob= new ListView();
    private CheckBox chbForedragsholder;
    private TextField txfNavnLedsager;
    private TextField txfTlfLedsager;
    private ListView<Frivillig> lvwFrivillig = new ListView();

    private CheckBox chbTilvalg1;
    private CheckBox chbTilvalg2;
    private CheckBox chbTilvalg3;

    private CheckBox chbUdflugt1;
    private CheckBox chbUdflugt2;
    private CheckBox chbUdflugt3;


    public TilmeldingsPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(15);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(35);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(16);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(34);
        this.getColumnConstraints().addAll(col1, col2, col3, col4);

        Label lblTilmelding = new Label("Opret Tilmelding");
        this.add(lblTilmelding, 0, 0, 2, 1);

        Label lblNavn = new Label("Navn:");
        this.add(lblNavn, 0, 1);
        txfNavn = new TextField();
        this.add(txfNavn, 1, 1);

        Label lblAdresse = new Label("Adresse:");
        this.add(lblAdresse, 0, 2);
        txfAdresse = new TextField();
        this.add(txfAdresse, 1, 2);

        Label lblTlf = new Label("Tlf nr:");
        this.add(lblTlf, 0, 3);
        txfTlf = new TextField();
        this.add(txfTlf, 1, 3);

        Label lblLand = new Label("Land:");
        this.add(lblLand, 0, 4);
        txfLand = new TextField();
        this.add(txfLand, 1, 4);

        Label lblKonference = new Label("Konference:");
        this.add(lblKonference, 0, 5);
        lvwJob = new ListView();
        lvwJob.setPrefHeight(80);
        this.add(lvwJob, 1, 5, 1, 3);
//        lvwKonference.getItems().setAll(Controller.getKonferencer());

        Label lblForedragsholder = new Label("Foredragsholder:");
        this.add(lblForedragsholder, 0, 8);
        chbForedragsholder = new CheckBox();
        this.add(chbForedragsholder, 1, 8);

        Label lblLedsager = new Label("---Ledsager---");
        this.add(lblLedsager, 2, 0, 2, 1);
        Label lblNavnLedsager = new Label("Navn:");
        this.add(lblNavnLedsager, 2, 1);
        txfNavnLedsager = new TextField();
        this.add(txfNavnLedsager, 3, 1);

        Label lblTlfLedsager = new Label("Tlf nr:");
        this.add(lblTlfLedsager, 2, 2);
        txfTlfLedsager = new TextField();
        this.add(txfTlfLedsager, 3, 2);

        Label lblHotel = new Label("---Hotel---");
        this.add(lblHotel, 2, 3, 2, 1);
        Label lblHoteller = new Label("Hoteller:");
        this.add(lblHoteller, 2, 4);
        lvwFrivillig = new ListView();
        lvwFrivillig.setPrefHeight(80);
//        lvwHoteller.getItems().setAll(Controller.getKonferencer().get(0).getHoteller());
        this.add(lvwFrivillig, 3, 4,1,2);


        Label lblTilvalg1 = new Label("WIFI / Bad / Mad");
        this.add(lblTilvalg1, 2, 6);
        HBox hBox = new HBox();
        chbTilvalg1 = new CheckBox();
        chbTilvalg2 = new CheckBox();
        chbTilvalg3 = new CheckBox();
        Label lblDeler = new Label("  /  ");
        Label lblDeler2 = new Label("  /  ");

        hBox.getChildren().add(chbTilvalg1);
        hBox.getChildren().add(lblDeler);
        hBox.getChildren().add(chbTilvalg2);
        hBox.getChildren().add(lblDeler2);
        hBox.getChildren().add(chbTilvalg3);
        this.add(hBox, 3, 6);


        Label lblUdflugter = new Label("---Udflugter---");
        this.add(lblUdflugter, 2, 7, 2, 1);
        Label lblUdflugt1 = new Label("Egeskov:");
        this.add(lblUdflugt1, 2, 8);
        chbUdflugt1 = new CheckBox();
        this.add(chbUdflugt1, 3, 8);

        Label lblUdflugt2 = new Label("Trapholt museum:");
        this.add(lblUdflugt2, 2, 9);
        chbUdflugt2 = new CheckBox();
        this.add(chbUdflugt2, 3, 9);

        Label lblUdflugt3 = new Label("Byrundtur:");
        this.add(lblUdflugt3, 2, 10);
        chbUdflugt3 = new CheckBox();
        this.add(chbUdflugt3, 3, 10);


        Button btnOpret = new Button("Opret");
        this.add(btnOpret, 3, 11);
//        btnOpret.setOnAction(event -> this.createAction());

    }

//    private void createAction() {
//        String navn = txfNavn.getText().trim();
//        String adresse = txfAdresse.getText().trim();
//        String tlfNr = txfTlf.getText().trim();
//        String land = txfLand.getText().trim();
//        boolean foredragsholder = chbForedragsholder.isSelected();
//        Konference konference = (Konference) lvwKonference.getSelectionModel().getSelectedItem();
//        String navnLedsager = txfNavnLedsager.getText().trim();
//        int tlfNrLedsager = 0;
//        if(txfTlfLedsager.getText().trim()==""){
//            tlfNrLedsager = Integer.parseInt(txfTlfLedsager.getText().trim());
//        }
//        Hotel hotel = (Hotel) lvwHoteller.getSelectionModel().getSelectedItem();
//        boolean tilvalg1 = chbTilvalg1.isSelected();
//        boolean tilvalg2 = chbTilvalg2.isSelected();
//        boolean tilvalg3 = chbTilvalg3.isSelected();
//
//        boolean udflugt1 = chbUdflugt1.isSelected();
//        boolean udflugt2 = chbUdflugt2.isSelected();
//        boolean udflugt3 = chbUdflugt3.isSelected();
//
//        ArrayList<Tilvalg> tilvalg = new ArrayList();
//        if(tilvalg1) {
//            tilvalg.add(hotel.getTilvalg().get(0));
//        }else if(tilvalg2){
//            tilvalg.add(hotel.getTilvalg().get(1));
//        }else if(tilvalg3){
//            tilvalg.add(hotel.getTilvalg().get(2));
//        }
//
//        ArrayList<Udflugt> udflugter = new ArrayList();
//        if(udflugt1) {
//            udflugter.add(konference.getUdflugter().get(0));
//        }else if(udflugt2){
//            udflugter.add(konference.getUdflugter().get(1));
//        }else if(udflugt3){
//            udflugter.add(konference.getUdflugter().get(2));
//    }
//
//
//        if (navn.length() == 0 || adresse.length()==0 || tlfNr.length()==0 || land.length()==0) {
//            popUpError();
//        } else {
//            Deltager deltager = Controller.createDeltager(navn,adresse,tlfNr,land,konference);
//
//            if(txfNavnLedsager.getText().equals("") && lvwHoteller.getSelectionModel().getSelectedItem()==null) {
//                Controller.createTilmelding(foredragsholder, konference, deltager);
//                popUp(Storage.getTilmeldinger().get(Storage.getTilmeldinger().size() - 1));
//
//            }else if(lvwHoteller.getSelectionModel().getSelectedItem()==null){
//                Controller.createTilmelding(foredragsholder, konference, deltager);
//                Controller.createLedsager(navnLedsager,tlfNrLedsager,udflugter,Storage.getTilmeldinger().get(Storage.getTilmeldinger().size() - 1));
//                popUp(Storage.getTilmeldinger().get(Storage.getTilmeldinger().size() - 1));
//
//            }else if(txfNavnLedsager.getText().equals("")){
//                Controller.createTilmelding(foredragsholder, konference,hotel, deltager,tilvalg);
//                popUp(Storage.getTilmeldinger().get(Storage.getTilmeldinger().size() - 1));
//            }else{
//                Controller.createTilmelding(konference.getStartDato(),konference.getSlutDato(),null,null,foredragsholder,konference,hotel,null,deltager,null,tilvalg);
//                Controller.createLedsager(navnLedsager,tlfNrLedsager,udflugter,Storage.getTilmeldinger().get(Storage.getTilmeldinger().size() - 1));
//                popUp(Storage.getTilmeldinger().get(Storage.getTilmeldinger().size() - 1));
//
//            }
//
//
//            txfNavn.clear();
//            txfAdresse.clear();
//            txfTlf.clear();
//            txfLand.clear();
//            txfNavnLedsager.clear();
//            txfTlfLedsager.clear();
//        }
//    }
//
//
//    private void popUpError() {
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//
//        alert.setTitle("Tilmelding ikke gennemført");
//        alert.setContentText("Der er opstået en fejl - Prøv igen.");
//        alert.showAndWait();
//    }
//
//    public static void popUp(Tilmelding tilmelding) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//
//        alert.setTitle("Tilmelding oprettet");
//        alert.setContentText("Tilmelding oprettet for " +tilmelding.getDeltager().getNavn()
//                +" Samlet Pris: "+ Controller.samletPris(tilmelding));
//        alert.showAndWait();
//    }
}

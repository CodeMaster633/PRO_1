package guifx;

import application.controller.Controller;
import application.model.Bane;
import application.model.Booking;
import application.model.Spiller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;


public class Gui extends Application {

    private ListView lvwBaner = new ListView<>();
    private ListView lvwSpillere = new ListView<>();

    private TextArea txaSpillere = new TextArea();
    private TextArea txaBookingerBane = new TextArea();

    private TextField txfDato;
    private TextField txfTid;

    private CheckBox chbSingle = new CheckBox();


    @Override
    public void start(Stage stage) {
        stage.setTitle("Bane booking");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setPrefSize(850, 500);
        pane.setPadding(new Insets(10));
        pane.setHgap(20);
        pane.setVgap(20);

        Label lblBaner = new Label("Baner");
        pane.add(lblBaner, 1, 0);

        lvwBaner = new ListView();
        lvwBaner.getItems().setAll(Controller.getBaner());
        pane.add(lvwBaner, 1, 1, 1, 2);

        Label lblSpillere = new Label("Spillere");
        pane.add(lblSpillere, 2, 0);

        lvwSpillere = new ListView();
        lvwSpillere.getItems().setAll(Controller.getSpillere());
        pane.add(lvwSpillere, 2, 1, 1, 2);

        Label lblSpillerBookinger = new Label("Spilleren bookinger");
        pane.add(lblSpillerBookinger, 3, 0);

        txaSpillere = new TextArea();
        pane.add(txaSpillere, 3, 1, 1, 2);
        lvwSpillere.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent arg0) {
                int index = lvwSpillere.getSelectionModel().getSelectedIndex();
                txaSpillere.setText(Controller.getSpillere().get(index).getBookinger().toString());
            }
        });

        Label lblBookingerBane = new Label("Antal bookinger på banen");
        pane.add(lblBookingerBane, 1, 3);


        txaBookingerBane = new TextArea();
        pane.add(txaBookingerBane, 1, 4, 1, 2);
        lvwBaner.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent arg0) {
                int index = lvwBaner.getSelectionModel().getSelectedIndex();
                txaBookingerBane.setText(Controller.getBaner().get(index).antalBookingerPrTimeStr());
            }
        });

        Label lblOpretBooking = new Label("Opret booking");
        pane.add(lblOpretBooking, 3, 3);

        HBox hBox = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        VBox vBox = new VBox();


        Label lblDato = new Label("Dato:");

        txfDato = new TextField();
//        pane.add(txfDato,4,4);
        hBox.getChildren().add(lblDato);
        hBox.getChildren().add(txfDato);


        Label lblTid = new Label("Tid:");
//        pane.add(lblTid, 3, 5);
        txfTid = new TextField();
//        pane.add(txfTid,4,5);
        hBox2.getChildren().add(lblTid);
        hBox2.getChildren().add(txfTid);

        CheckBox chbSingle = new CheckBox("Single");
        hBox3.getChildren().add(chbSingle);

        Button btnBookBane = new Button("Book bane til spiller");
        btnBookBane.setOnMouseClicked(event -> opretBooking());


        vBox.getChildren().add(hBox);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(hBox3);
        vBox.getChildren().add(btnBookBane);
        pane.add(vBox, 3, 4);
    }

    private void opretBooking() {
        if (txfDato.getText().equals("")||txfTid.getText().equals("")) {
            System.out.println("Booking ikke oprettet");
            popUpError();
        }

        LocalDate dato = LocalDate.parse(txfDato.getText());
        LocalTime tid = LocalTime.parse(txfTid.getText());
        Bane bane = (Bane) lvwBaner.getSelectionModel().getSelectedItem();
        Spiller spiller = (Spiller) lvwSpillere.getSelectionModel().getSelectedItem();
        Boolean single = chbSingle.isSelected();

        popUp(Controller.createBooking(dato, tid, single, spiller, bane));

        txfDato.clear();
        txfTid.clear();
    }

    public static void popUp(Booking booking) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Booking oprettet");
        alert.setContentText("Booking oprettet for " + booking.getSpiller().getNavn() + " på " + booking.getBane() + " d. " + booking.getDato() + " kl. " + booking.getTid());
        alert.showAndWait();
    }
    private void popUpError() {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Booking ikke oprettet");
        alert.setContentText("Der er opstået en fejl - Prøv igen.");
        alert.showAndWait();
    }


}

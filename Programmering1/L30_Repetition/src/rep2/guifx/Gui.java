package rep2.guifx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import rep2.application.controller.Controller;
import rep2.application.model.Salg;
import rep2.application.model.Salgsannonce;
import rep2.application.model.Sælger;
import rep2.application.model.Vare;

import java.util.ArrayList;


public class Gui extends Application {

    private ListView lvwAnnoncer = new ListView<>();
    private ListView lvwVarer = new ListView<>();

    private TextField txfKøber = new TextField();
    private TextField txfAftaltPris = new TextField();


    @Override
    public void start(Stage stage) {
        stage.setTitle("Salg");
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

        Label lblAnnoncer = new Label("Aktive annoncer");
        pane.add(lblAnnoncer, 1, 0);

        lvwAnnoncer = new ListView();
        lvwAnnoncer.getItems().setAll(Controller.getSalgsannoncer());
        pane.add(lvwAnnoncer, 1, 1, 1, 4);

        Label lblVarer = new Label("Varer");
        pane.add(lblVarer, 2, 0);

        lvwVarer = new ListView();
        lvwVarer.getItems().setAll(Controller.getSalgsannoncer().get(0).getVarer());
        pane.add(lvwVarer, 2, 1, 1, 4);
        lvwVarer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Label lblKøber = new Label("Køber");
        pane.add(lblKøber, 3, 1);
        TextField txfKøber = new TextField();
        pane.add(txfKøber, 4, 1);

        Label lblAftaltPris = new Label("Aftalt pris");
        pane.add(lblAftaltPris, 3, 2);
        TextField txfAftaltPris = new TextField();
        pane.add(txfAftaltPris, 4, 2);

        Button btnOpretSalg = new Button("Opret salg");
        pane.add(btnOpretSalg, 3, 3, 2, 1);
        btnOpretSalg.setOnMouseClicked(event -> opretSalgAction());

        initActions();

    }

    private void opretSalg() {
        String navn = "";
        double aftaltPris = -1;
        ArrayList<Vare> varer = new ArrayList<Vare>();

        navn = txfKøber.getText();
        aftaltPris = Integer.parseInt(txfAftaltPris.getText());
        varer.addAll(lvwVarer.getSelectionModel().getSelectedItems());

//        if (txfKøber.getText() != "" && txfAftaltPris.getText() != null && aftaltPris != -1) {
//        }

        if (txfKøber.equals("") || txfAftaltPris.getText().equals("") || lvwVarer.getSelectionModel().getSelectedItems().equals(null)) {
            popUpError();
        } else {
            int nyPris = (int) aftaltPris;
            Controller.createSalg(navn, nyPris, varer);
            System.out.println("Salg oprettet");

        }

    }

    public void opretSalgAction() {
        Salgsannonce salgsannonce = (Salgsannonce) lvwAnnoncer.getSelectionModel().getSelectedItem();
        ArrayList<Vare> varer = new ArrayList<>(lvwVarer.getSelectionModel().getSelectedItems());
        if (varer == null) {
            System.out.println("hej");
        }
        if (salgsannonce != null && varer != null) {
            String køber = txfKøber.getText();

            if (txfAftaltPris.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Fejl");
                alert.setHeaderText("Manglende beløb");
                alert.setContentText("Indtast venligst aftalt beløb");
                alert.showAndWait();
            }

            int aftaltPris = Integer.parseInt(txfAftaltPris.getText());

            if (køber.equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Fejl");
                alert.setHeaderText("Manglende navn");
                alert.setContentText("Indtast venligst dit navn");
                alert.showAndWait();
            }

            for (Vare v : varer) {
                if (v.getSolgt()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle(v.getNavn() + " er solgt");
                    alert.setHeaderText("Solgt");
                    alert.setContentText("Ønsket vare er solgt");
                    alert.showAndWait();
                }
            }

            Salg salg = Controller.createSalg(køber, aftaltPris, varer);

//            updateVare();
        }
    }

    public void initActions() {
        //Detecting mouse clicked
        lvwAnnoncer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                //Check wich list index is selected then set txtContent value for that index
                if (lvwAnnoncer.getSelectionModel().getSelectedIndex() == 0) {
                    System.out.println("Selected index: 0");
                    lvwVarer.getItems().setAll(Controller.getSalgsannoncer().get(0).getVarer());
                } else if (lvwAnnoncer.getSelectionModel().getSelectedIndex() == 1) {
                    System.out.println("Selected index: 1");
                    lvwVarer.getItems().setAll(Controller.getSalgsannoncer().get(1).getVarer());
                } else if (lvwAnnoncer.getSelectionModel().getSelectedIndex() == 2) {
                    System.out.println("Selected index: 2");
                    lvwVarer.getItems().setAll(Controller.getSalgsannoncer().get(2).getVarer());

                } else if (lvwAnnoncer.getSelectionModel().getSelectedIndex() == 3) {
                    System.out.println("Selected index: 3");
                    lvwVarer.getItems().setAll(Controller.getSalgsannoncer().get(3).getVarer());

                }
            }
        });
    }

    private void popUpError() {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Salg ikke oprettet");
        alert.setContentText("Der er opstået en fejl - Prøv igen.");
        alert.showAndWait();
    }
}

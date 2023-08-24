package guifx;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Tilmelding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelOversigtVindue extends Stage {

        public HotelOversigtVindue(String title) {
            this.initStyle(StageStyle.UTILITY);
            this.initModality(Modality.APPLICATION_MODAL);
            this.setResizable(false);

            this.setTitle(title);
            GridPane pane = new GridPane();
            this.initContent(pane);

            Scene scene = new Scene(pane);
            this.setScene(scene);
        }

        private ListView<Ledsager> lvwBookinger = new ListView<>();
        private ListView<Hotel> lvwHoteller= new ListView();
        private Label lblBookinger;


        public void initContent(GridPane pane) {
            pane.setGridLinesVisible(false);
            pane.setPadding(new Insets(10));
            pane.setHgap(10);
            pane.setVgap(10);


            Label lblDeltager = new Label("Konferencer og deltagere");
            pane.add(lblDeltager, 0, 0);

            Label lblKonference = new Label("Hoteller:");
            pane.add(lblKonference, 0, 1);
            lvwHoteller = new ListView();
            lvwHoteller.setPrefHeight(80);
            pane.add(lvwHoteller, 1, 1);
            lvwHoteller.getItems().setAll(Controller.getHoteller());
            Button btnVis = new Button("Vis");
            pane.add(btnVis,0,2,2,1);
            btnVis.setOnAction(event -> this.visDeltagere());

            lblDeltager = new Label("Bookinger:");
            pane.add(lblDeltager, 0, 3);
            lvwBookinger = new ListView<>();
            pane.add(lvwBookinger, 1, 3);

        }

    private void visDeltagere() {
        Hotel hotel = (Hotel) lvwHoteller.getSelectionModel().getSelectedItem();
        System.out.println("Test: "+hotel.getTilmeldinger().get(1).getLedsager());

        lvwBookinger.getItems().setAll(hotel.getBookinger());
    }
    public void updateControls() {}

    }


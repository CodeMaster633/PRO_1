package guifx;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Konference;
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
import storage.Storage;

import java.util.ArrayList;

public class KonferenceOversigtVindue extends Stage {

        public KonferenceOversigtVindue(String title) {
            this.initStyle(StageStyle.UTILITY);
            this.initModality(Modality.APPLICATION_MODAL);
            this.setResizable(false);

            this.setTitle(title);
            GridPane pane = new GridPane();
            this.initContent(pane);

            Scene scene = new Scene(pane);
            this.setScene(scene);
        }

        private ListView<Tilmelding> lvwTilmeldinger = new ListView<>();
        private ListView<Konference> lvwKonference= new ListView();
        private Label lblDeltager;


        public void initContent(GridPane pane) {
            pane.setGridLinesVisible(false);
            pane.setPadding(new Insets(10));
            pane.setHgap(10);
            pane.setVgap(10);


            Label lblDeltager = new Label("Konferencer og deltagere");
            pane.add(lblDeltager, 0, 0);

            Label lblKonference = new Label("Konference:");
            pane.add(lblKonference, 0, 1);
            lvwKonference = new ListView();
            lvwKonference.setPrefHeight(80);
            pane.add(lvwKonference, 1, 1);
            lvwKonference.getItems().setAll(Controller.getKonferencer());
            Button btnVis = new Button("Vis");
            pane.add(btnVis,0,2,2,1);
            btnVis.setOnAction(event -> this.visDeltagere());

            lblDeltager = new Label("Deltager:");
            pane.add(lblDeltager, 0, 3);
            lvwTilmeldinger = new ListView<>();
            pane.add(lvwTilmeldinger, 1, 3);

        }

    private void visDeltagere() {
        Konference konference = (Konference) lvwKonference.getSelectionModel().getSelectedItem();
        lvwTilmeldinger.getItems().setAll(konference.getTilmeldinger());
    }
    public void updateControls() {}

    }


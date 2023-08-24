package guifx;

import application.controller.Controller;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Tilmelding;
import application.model.Udflugt;
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

public class UdflugtOversigtVindue extends Stage {

        public UdflugtOversigtVindue(String title) {
            this.initStyle(StageStyle.UTILITY);
            this.initModality(Modality.APPLICATION_MODAL);
            this.setResizable(false);

            this.setTitle(title);
            GridPane pane = new GridPane();
            this.initContent(pane);

            Scene scene = new Scene(pane);
            this.setScene(scene);
        }

        private ListView<Ledsager> lvwLedsagere = new ListView<>();
        private ListView<Udflugt> lvwUdflugter= new ListView();
        private Label lblDLedsager;


        public void initContent(GridPane pane) {
            pane.setGridLinesVisible(false);
            pane.setPadding(new Insets(10));
            pane.setHgap(10);
            pane.setVgap(10);


            Label lblDeltager = new Label("Ledsagere");
            pane.add(lblDeltager, 0, 0);

            Label lblKonference = new Label("Udflugt:");
            pane.add(lblKonference, 0, 1);
            lvwUdflugter = new ListView();
            lvwUdflugter.setPrefHeight(80);
            pane.add(lvwUdflugter, 1, 1);
            lvwUdflugter.getItems().setAll(Controller.getUdflugter(Storage.getKonferencer().get(0)));
            Button btnVis = new Button("Vis");
            pane.add(btnVis,0,2,2,1);
            btnVis.setOnAction(event -> this.visDeltagere());

            lblDeltager = new Label("Deltager:");
            pane.add(lblDeltager, 0, 3);
            lvwLedsagere = new ListView<>();
            pane.add(lvwLedsagere, 1, 3);

        }

    private void visDeltagere() {
        Udflugt udflugt = (Udflugt) lvwUdflugter.getSelectionModel().getSelectedItem();
        lvwLedsagere.getItems().setAll(udflugt.getLedsager());
    }
    public void updateControls() {}

    }


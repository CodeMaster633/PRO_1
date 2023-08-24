
package guifx;

import application.model.Hotel;
import application.model.Konference;
import application.model.Udflugt;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class OversigtPane extends GridPane {
    private ListView<Hotel> lvwHoteller;
    private ListView<Udflugt> lvwUdflugter;
    private ListView<Konference> lvwKonferencer;

    public OversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
        this.setPrefSize(500, 300);

        Label lblOversigt = new Label("Oversigt");
        this.add(lblOversigt, 0, 0);
        Button btnKonference = new Button("Konferencer");
        Button btnHotel = new Button("Hoteller");
        Button btnUdflugt = new Button("Udflugter");
        HBox hBox = new HBox();
        hBox.getChildren().add(btnKonference);
        hBox.getChildren().add(btnHotel);
        hBox.getChildren().add(btnUdflugt);
        this.add(hBox, 0, 1);

        btnKonference.setOnAction(event -> this.konferenceOversigt());
        btnHotel.setOnAction(event -> this.hotellerOversigt());
        btnUdflugt.setOnAction(event -> this.udflugterOversigt());

//        Label lblKonference = new Label("Konference:");
//        this.add(lblKonference, 0, 2);
//        ListView lvwKonference = new ListView();
//        lvwKonference.setPrefHeight(80);
//        this.add(lvwKonference, 0, 3);
//        lvwKonference.getItems().setAll(Controller.getKonferencer());
//
//        Label lblInformation = new Label("Information:");
//        this.add(lblInformation, 1, 2);
//        ListView lvwInformation = new ListView();
//        lvwInformation.setPrefHeight(80);
//        this.add(lvwInformation, 1, 3);
    }

    private void konferenceOversigt() {
        KonferenceOversigtVindue dia = new KonferenceOversigtVindue("Konferencer");
        dia.showAndWait();
    }
    private void hotellerOversigt() {
        HotelOversigtVindue dia = new HotelOversigtVindue("Hoteller");
        dia.showAndWait();
    }
    private void udflugterOversigt() {
        UdflugtOversigtVindue dia = new UdflugtOversigtVindue("Udflugter");
        dia.showAndWait();
    }

    public void updateControls() {
    }
}


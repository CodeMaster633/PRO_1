package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage){
        stage.setTitle("Konference Administrations System");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
        pane.setPrefSize(700, 450);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabKonference = new Tab("Opret Konference");
        KonferencePane konferencePane = new KonferencePane();
        tabKonference.setContent(konferencePane);
        tabKonference.setOnSelectionChanged(event -> konferencePane.updateControls());

        Tab tabHotel = new Tab("Opret Hotel");
        HotelPane hotelPane = new HotelPane();
        tabHotel.setContent(hotelPane);
        tabHotel.setOnSelectionChanged(event -> hotelPane.updateControls());

        Tab tabUdflugt = new Tab("Opret Udflugt");
        UdflugtPane udflugtPane = new UdflugtPane();
        tabUdflugt.setContent(udflugtPane);
        tabUdflugt.setOnSelectionChanged(event -> udflugtPane.updateControls());

        Tab tabTilmelding = new Tab("Tilmelding");
        TilmeldingsPane tilmeldingsPane = new TilmeldingsPane();
        tabTilmelding.setContent(tilmeldingsPane);
//        tabTilmelding.setOnSelectionChanged(event -> tilmeldingsPane.updateControls());

        Tab tabOversigt = new Tab("Oversigter");
        OversigtPane oversigtPane = new OversigtPane();
        tabOversigt.setContent(oversigtPane);
        tabOversigt.setOnSelectionChanged(event -> oversigtPane.updateControls());

        tabPane.getTabs().add(tabTilmelding);
        tabPane.getTabs().add(tabOversigt);
        tabPane.getTabs().add(tabKonference);
        tabPane.getTabs().add(tabHotel);
        tabPane.getTabs().add(tabUdflugt);


    }

}

package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Valuta begregner");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void initContent(GridPane pane) {
        pane.setPrefSize(400, 300);
        Label beløb = new Label("Indtast beløb: ");
        pane.add(beløb,0,0);

        TextField txfBeløb = new TextField();
        pane.add(txfBeløb,1,0);


    }
}

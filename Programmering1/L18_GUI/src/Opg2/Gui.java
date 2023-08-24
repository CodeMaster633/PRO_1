package Opg2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    private TextField txfNumber;
    private int number = 0;

    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);

        stage.setTitle("Gui opgaver");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(5);
        pane.setVgap(5);

        Label lblName = new Label("Number:");
        pane.add(lblName, 0, 1);
        txfNumber = new TextField();
        pane.add(txfNumber, 1, 1, 1, 1);

        Button btnInc = new Button("Inc");
        pane.add(btnInc, 2, 0,2,1);
        GridPane.setMargin(btnInc, new Insets(10, 10, 0, 10));

        btnInc.setOnAction(event -> {increaseNumber();});

        Button btnDec = new Button("Dec");
        pane.add(btnDec, 2, 2);
        GridPane.setMargin(btnDec, new Insets(10, 10, 0, 10));

        btnDec.setOnAction(event -> {decreaseNumber();});

    }

    private void increaseNumber() {
        number++;
        txfNumber.setText(""+number);
       }

    private void decreaseNumber() {
        number--;
        txfNumber.setText(""+number);
    }
}
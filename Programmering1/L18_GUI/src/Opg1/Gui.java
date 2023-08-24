package Opg1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Gui extends Application {

    private TextField txfName;
    private TextField txfLastName;
    private TextField txfFullName;


    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("First name:");
        pane.add(lblName, 0, 0);
        txfName = new TextField();
        pane.add(txfName, 0, 1, 2, 1);

        Label lblLastName = new Label("Last name:");
        pane.add(lblLastName, 2, 0);
        txfLastName = new TextField();
        pane.add(txfLastName, 2, 1, 2, 1);

        Label lblFullName = new Label("Full name:");
        pane.add(lblFullName, 0, 3);
        txfFullName = new TextField();
        pane.add(txfFullName, 0, 4, 4, 1);

        Button btnCombine = new Button("Combine");
        pane.add(btnCombine, 2, 6);
        GridPane.setMargin(btnCombine, new Insets(10, 10, 0, 10));

        btnCombine.setOnAction(event -> {combineAction();});
    }

    private void combineAction() {
        txfFullName.setText(txfName.getText()+txfLastName.getText());
       }
}
package Opg5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    private TextField txfName;
    private final TextArea txaNameList = new TextArea();

    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);

        stage.setTitle("GUI opgaver");
        stage.setScene(scene);
        stage.show();
    }
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        txfName = new TextField();
        pane.add(txfName, 0, 1);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 0, 2);
        GridPane.setMargin(btnAdd, new Insets(10, 10, 0, 10));
        btnAdd.setOnAction(event -> {
            addNameAction();
        });

        Label lblNameList = new Label("All names:");
        pane.add(lblNameList, 0, 3);

        pane.add(txaNameList, 0, 4);
        txaNameList.setPrefRowCount(7);
        txaNameList.setPrefWidth(270);
        txaNameList.setEditable(false);
    }

    private void addNameAction() {
        txaNameList.setText(txaNameList.getText() + txfName.getText() + "\n");
    }
}
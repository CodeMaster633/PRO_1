package Opg3;

import demotwowindows.Movie;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersondataWindow extends Stage {

    public PersondataWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfTitle = new TextField();
    private final TextField txfName = new TextField();
    private boolean senior = false;
    private Person person;


    private void initContent(GridPane pane) {
//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Titel:");
        pane.add(lblTitle, 0, 1);

        pane.add(txfName, 1, 0);

        pane.add(txfTitle, 1, 1);

        // CheckBox to indicate senior
        CheckBox checkBox = new CheckBox();
        checkBox.setText("Senior");
        pane.add(checkBox, 1, 2);
        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {
                senior=true;
            } else {
                senior=false;
            }
        });

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3, 2, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void cancelAction() {
        txfTitle.clear();
        txfTitle.requestFocus();
        txfName.clear();
        PersondataWindow.this.hide();
    }

    private void okAction() {
        String title = txfTitle.getText().trim();
        String name = txfName.getText().trim();
        boolean senior = this.senior;

        if (title.length() > 0 && name.length() > 0) {
            person = new Person(name,title,senior);
            txfTitle.clear();
            txfName.clear();
            this.senior=false;
            txfTitle.requestFocus();
            PersondataWindow.this.hide();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add Person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type title and name");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------

    public Person getPersondata() {
        return person;
    }

    public void clearPersondata() {
        person = null;
    }
}

package Opg1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class GuiListView2 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Opg1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfTitle = new TextField();

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> names = new ArrayList<>();
    private boolean senior = false;

    private void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        // add a label to the pane (at col=0, row=0)
        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);

        // add a label to the pane (at col=0, row=1)
        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 3);
        GridPane.setValignment(lblNames, VPos.TOP);

        // add a text field to the pane (at col=1, row=0)
        pane.add(txfName, 1, 0);

        // add a text field to the pane (at col=1, row=0)
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


        // add a listView to the pane(at col=1, row=1)
        pane.add(lvwNames, 1, 3);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(this.initNames());

        ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwNames.getSelectionModel().clearSelection();

        // add a button to the pane (at col=4, row=0)
        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 4, 0);
       // btnAdd.setDefaultButton(true);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

        // add a button to the pane (at col=4, row=1)
        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 4, 3);

        // connect a method to the button
        btnDelete.setOnAction(event -> this.deleteAction());
    }

    // -------------------------------------------------------------------------

    private ArrayList<String> initNames() {
        Person p1 = new Person("Jens","Mekaniker",true);

        String s = String.valueOf(p1);

        names.add(s);

//        names.add(p1);
//        names.add("Eva");

        return names;
    }

    // -------------------------------------------------------------------------
    // Selection changed actions

    private void selectionChanged() {
        String selected = lvwNames.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txfName.setText(selected);
        } else {
            txfName.clear();
        }
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();

        Person person = new Person(name,title,senior);

        if (name.length() > 0 && title.length()>0) {
            names.add(String.valueOf(person));
            lvwNames.getItems().setAll(names);
        } else {
            Dialog dialog = new Dialog();
            dialog.setHeaderText("Wrong input - Try again");

            dialog.showAndWait();


        }
    }

    private void deleteAction() {
        int index = lvwNames.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            names.remove(index);
            txfName.clear();
            lvwNames.getItems().setAll(names);
        }
    }
}

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GuiTab2 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Opg");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> boyNames = new ArrayList<>();
    private final ArrayList<String> girlNames = new ArrayList<>();
    private final ToggleGroup group = new ToggleGroup();


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

        // add a label to the pane (at col=0, row=1)
        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 2);
        GridPane.setValignment(lblNames, VPos.TOP);

        // add a text field to the pane (at col=1, row=0)
        pane.add(txfName, 1, 0);

        //Radiobutton
        HBox box = new HBox();
        pane.add(box, 1, 1);

        //Dreng knap
        RadioButton rb1 = new RadioButton();
        box.getChildren().add(rb1);
        rb1.setText("Dreng");
        rb1.prefWidth(200);
        rb1.setUserData(boyNames);
        rb1.setToggleGroup(group);
        rb1.setOnAction(event->setListType());

        //Pige knap
        RadioButton rb2 = new RadioButton();
        box.getChildren().add(rb2);
        rb2.setText("Pige");
        rb2.prefWidth(100);
        rb2.setUserData(girlNames);
        rb2.setToggleGroup(group);
        rb2.setOnAction(event->setListType());

        //Knap markeret fra start
        RadioButton rb0 = (RadioButton) group.getToggles().get(0);
        rb0.setSelected(true);

        // add a listView to the pane(at col=1, row=1)
        initNames();
        pane.add(lvwNames, 1, 2);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(boyNames);

        ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwNames.getSelectionModel().clearSelection();

        // add a button to the pane (at col=4, row=0)
        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 4, 0);
        // btnAdd.setDefaultButton(true);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

    }

    // -------------------------------------------------------------------------

    private void initNames() {

        boyNames.add("Bob");
        boyNames.add("Mikkel");
        boyNames.add("Peter");

        girlNames.add("Julie");
        girlNames.add("Henriette");
        girlNames.add("Filippa");
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


        if (name.length() > 0) {

            RadioButton rb = (RadioButton) group.getSelectedToggle();

            if(rb.getUserData()==boyNames){
                boyNames.add(name);
                lvwNames.getItems().setAll(boyNames);
            }else if (rb.getUserData()==girlNames){
                girlNames.add(name);
                lvwNames.getItems().setAll(girlNames);
            }
//            ArrayList<String> list = (ArrayList) rb.getUserData();
//            lvwNames.getItems().setAll(list);

//            lvwNames.getItems().add(name);
//            lvwNames.getItems().setAll()

            //Ændringer TODO
//            boyNames.add(name);
//            lvwNames.getItems().setAll(boyNames);
        } else {
            Dialog dialog = new Dialog();
            dialog.setHeaderText("Wrong input - Try again");

            dialog.showAndWait();
        }
    }

    private void deleteAction() {
        int index = lvwNames.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            //Ændring TODO
            boyNames.remove(index);
            txfName.clear();
            lvwNames.getItems().setAll(boyNames);
        }
    }

    private void setListType(){

        RadioButton rb = (RadioButton) group.getSelectedToggle();
        ArrayList<String> list = (ArrayList) rb.getUserData();
        lvwNames.getItems().setAll(list);


//        Color color = (Color) rb.getUserData();
//        lblTxt.setTextFill(color);
    }
}

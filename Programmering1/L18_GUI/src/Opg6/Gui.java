package Opg6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.naming.Name;

public class Gui extends Application {

    private TextField txfName;
    private TextField txfAge;

    private final TextArea txaStudentInfo = new TextArea();
    private Student student = new Student();
    private int age;
    private boolean active;
    private CheckBox checkBox;

    private Button btnCreate;
    private Button btnUpdate;
    private Button btnDelete;


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

        Label lblStudentInfo = new Label("Student info:");
        pane.add(lblStudentInfo, 0, 0);

        pane.add(txaStudentInfo, 0, 1, 5, 1);
        txaStudentInfo.setPrefRowCount(7);
        txaStudentInfo.setPrefWidth(270);
        txaStudentInfo.setEditable(false);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 2);
        txfName = new TextField();
        pane.add(txfName, 1, 2);

        Label lblAge = new Label("Age:");
        pane.add(lblAge, 0, 3);
        txfAge = new TextField();
        pane.add(txfAge, 1, 3);
        txfAge.setEditable(false);

        Button btnInc = new Button("Inc");
        pane.add(btnInc, 2, 3);
        GridPane.setMargin(btnInc, new Insets(10, 10, 0, 10));
        btnInc.setOnAction(event -> {
            increaseNumber();
        });

        Button btnReset = new Button("Reset");
        pane.add(btnReset, 3, 3);
        GridPane.setMargin(btnReset, new Insets(10, 10, 0, 10));
        btnReset.setOnAction(event -> {
            resetNumber();
        });

        Label lblActive = new Label("Active: ");
        pane.add(lblActive, 0, 4);

        checkBox = new CheckBox();
        pane.add(checkBox, 1, 4);
        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {
                active = true;
            } else {
                active = false;
            }
        });

        btnCreate = new Button("Create");
        pane.add(btnCreate, 0, 5);
        btnCreate.setOnAction(event -> createStudent());

        btnUpdate = new Button("Update");
        pane.add(btnUpdate, 1, 5);
        btnUpdate.setDisable(true);
        btnUpdate.setOnAction(event -> updateStudent());


        btnDelete = new Button("Delete");
        pane.add(btnDelete, 2, 5);
        btnDelete.setDisable(true);
        btnDelete.setOnAction(event -> deleteStudent());

    }

    private void increaseNumber() {
        age++;
        txfAge.setText("" + age);
    }

    private void resetNumber() {
        age = student.getAge();
        txfAge.setText("" + age);
    }

    private void createStudent() {
        student = new Student(txfName.getText(), Integer.parseInt(txfAge.getText()), active);

        txaStudentInfo.setText("Name: " + student.getName() +
                "\nAge: " + student.getAge() +
                "\nActive: " + student.getActive());

        txfName.setText("");
        txfAge.setText("");
        age = 0;
        checkBox.setSelected(false);
        active=false;

        btnCreate.setDisable(true);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
    }

    private void updateStudent() {

        student.setName(txfName.getText());
        student.setAge(Integer.parseInt(txfAge.getText()));
        student.setActive(active);

        txaStudentInfo.setText("Name: " + student.getName() +
                "\nAge: " + student.getAge() +
                "\nActive: " + student.getActive());

        txfName.setText("");
        txfAge.setText("");
        age = 0;
        checkBox.setSelected(false);
        active=false;
    }

    private void deleteStudent() {
        txaStudentInfo.setText("");

        student = new Student();

        btnCreate.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);


    }


}
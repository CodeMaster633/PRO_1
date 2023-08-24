package Opg4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.jfr.Event;

public class Gui extends Application {

    private TextField txfCelsius;
    private TextField txfFahrenheit;
    private TextField txfCelsius2;
    private TextField txfFahrenheit2;


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
        pane.setVgap(10);

        Label lblName = new Label("CONVERTIUS");
        pane.add(lblName, 2, 0);

        //Cel to Fahr
        Label lblCelsius = new Label("Celsius:");
        pane.add(lblCelsius, 0, 1);
        txfCelsius = new TextField();
        pane.add(txfCelsius,1,1);

        Label lblFahrenheit = new Label("To fahrenheit:");
        pane.add(lblFahrenheit,2,1);
        txfFahrenheit = new TextField();
        pane.add(txfFahrenheit,3,1);

        Button btnConvertCelToFahr = new Button("Convert");
        pane.add(btnConvertCelToFahr,2,2);
        btnConvertCelToFahr.setOnAction(event->convertCelToFahr());

        //Fahr to Cel
        Label lblFahrenheit2 = new Label("Fahrenheit:");
        pane.add(lblFahrenheit2, 0, 4);
        txfFahrenheit2 = new TextField();
        pane.add(txfFahrenheit2,1,4);

        Label lblCelsius2 = new Label("To celsius:");
        pane.add(lblCelsius2,2,4);
        txfCelsius2 = new TextField();
        pane.add(txfCelsius2,3,4);

        Button btnConvertFahrToCel = new Button("Convert");
        pane.add(btnConvertFahrToCel,2,5);
        btnConvertFahrToCel.setOnAction(event->convertFahrToCel());


    }

    public void convertCelToFahr() {
        double celsius = Double.parseDouble(txfCelsius.getText());
        double fahrenheit = 1.8*celsius+32;
        txfFahrenheit.setText(""+fahrenheit);
    }

    public void convertFahrToCel() {
        double fahrenheit = Double.parseDouble(txfFahrenheit2.getText());
        double celsius = (fahrenheit-32)/1.8;
        txfCelsius2.setText(""+celsius);

    }
}
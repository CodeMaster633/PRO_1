package Opg3;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Math;

public class Gui extends Application {

    private TextField txfInvestment;
    private TextField txfYears;
    private TextField txfInterest;
    private TextField txfFutureValue;


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

        Label lblInvest = new Label("Investment:");
        pane.add(lblInvest, 0, 0);
        txfInvestment = new TextField();
        pane.add(txfInvestment, 1, 0);

        Label lblYears = new Label("Years:");
        pane.add(lblYears, 0, 1);
        txfYears = new TextField();
        pane.add(txfYears, 1, 1);

        Label lblInterest = new Label("Interest:");
        pane.add(lblInterest, 0, 2);
        txfInterest = new TextField();
        pane.add(txfInterest, 1, 2);

        Button btnCal = new Button("Calculate");
        pane.add(btnCal, 1, 3);
        GridPane.setMargin(btnCal, new Insets(10, 20, 8, 45));
        btnCal.setOnAction(event->{calculateAction();});

        Label lblFutureValue = new Label("FutureValue:");
        pane.add(lblFutureValue, 0, 5);
        txfFutureValue = new TextField();
        pane.add(txfFutureValue, 1, 5);

    }

    public void calculateAction(){
        double investment = Double.parseDouble(txfInvestment.getText());
        double years = Double.parseDouble(txfYears.getText());
        double interest = Double.parseDouble(txfInterest.getText());
        interest=interest/100;

        double finalCapital = investment*Math.pow((1+interest),years);
        txfFutureValue.setText(""+finalCapital);
    }

}
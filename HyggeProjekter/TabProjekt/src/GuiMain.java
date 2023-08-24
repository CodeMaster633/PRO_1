import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.util.ArrayList;

public class GuiMain extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("TabProjekt");
        TabPane tabPane = new TabPane();
        this.initContent(tabPane);

        Scene scene = new Scene(tabPane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField[] txfCars = new TextField[3];
    private final TextField txfUp = new TextField("Up");
    private final TextField txfDown = new TextField("Down");
    private int chosenCar;

    private void initContent(TabPane pane) {

        Tab tab = new Tab();
        tab.setText("Tab 1");
        VBox tab_vBox = new VBox();
        tab_vBox.getChildren().addAll(
                new Button("Button 1"),
                new Button("Button 2"),
                new Button("Button 3"),
                new Button("Button 4"),
                new HBox(new Label("Hey"),new Label(" heeey")));
        tab.setContent(tab_vBox);

        Tab tab2 = new Tab();
        tab2.setText("Tab2");
        VBox tab2vBox = new VBox();
        txfCars[0] = new TextField("Audi");
        txfCars[1] = new TextField("WV");
        txfCars[2] = new TextField("Tesla");
        txfCars[0].setEditable(false);
        txfCars[1].setEditable(false);
        txfCars[2].setEditable(false);
        tab2vBox.getChildren().addAll(txfCars[0],txfCars[1],txfCars[2]);

        txfCars[0].setOnMouseClicked(event -> setChosenCar(0));
        txfCars[1].setOnMouseClicked(event -> setChosenCar(1));
        txfCars[2].setOnMouseClicked(event -> setChosenCar(2));


        txfUp.setOnMouseClicked(event -> upClicked());
        txfDown.setOnMouseClicked(event -> downClicked());

        HBox tab2hBox = new HBox();
        tab2hBox.getChildren().addAll(txfUp,txfDown);
        tab2vBox.getChildren().add(tab2hBox);
        tab2.setContent(tab2vBox);

        pane.getTabs().add(tab);
        pane.getTabs().add(tab2);

    }

    private void setChosenCar(int car) {
        chosenCar=car;
        System.out.println(chosenCar);
    }

    private void upClicked() {

        if(chosenCar==2) {
            String tempCar = txfCars[chosenCar].getText();
            txfCars[chosenCar].setText(txfCars[1].getText());
            txfCars[1].setText(tempCar);
            chosenCar--;

        }else if(chosenCar==1) {
            String tempCar = txfCars[1].getText();
            txfCars[1].setText(txfCars[0].getText());
            txfCars[0].setText(tempCar);
            chosenCar--;

        }else if(chosenCar==0) {
            System.out.println("Hehee");
        }
    }

    private void downClicked() {
        if(chosenCar==0) {
            String tempCar = txfCars[chosenCar].getText();
            txfCars[chosenCar].setText(txfCars[1].getText());
            txfCars[1].setText(tempCar);
            chosenCar++;

        }else if(chosenCar==1) {
            String tempCar = txfCars[1].getText();
            txfCars[1].setText(txfCars[2].getText());
            txfCars[2].setText(tempCar);
            chosenCar++;

        }else if(chosenCar==2) {
            System.out.println("Hehee");
        }
    }

}

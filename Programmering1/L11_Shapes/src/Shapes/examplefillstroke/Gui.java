package Shapes.examplefillstroke;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui extends Application {
private int afstand = 80;
private int radiusHjul = 20;
int antal = 4;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {

        Polygon karos = new Polygon(20,240,20,300,350,300,350,200,90,200);
        pane.getChildren().add(karos);
        karos.setFill(Color.RED);

        for(int j=0;j<antal;j++){

            Circle c1 = new Circle(70+(afstand *j), 300, radiusHjul);
            pane.getChildren().add(c1);

            Line door = new Line(90+(afstand *j),200,90+(afstand *j),300);
            pane.getChildren().add(door);
            door.setFill(Color.BLACK);
        }
    }
}

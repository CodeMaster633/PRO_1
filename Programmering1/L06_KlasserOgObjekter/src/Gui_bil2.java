import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Gui_bil2 extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Car car1 = new Car();
        this.drawCar(pane, car1);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void drawCar(Pane pane, Car car) {

        int afstand = 80;
        int radiusHjul = 20;
        int antalWheels = car.getWheels();
        int antalDoors = car.getDoors();


        Polygon karos = new Polygon(20, 240, 20, 300, 350, 300, 350, 200, 90, 200);
        pane.getChildren().add(karos);
        karos.setFill(Color.RED);

        for (int j = 0; j < antalWheels; j++) {

            Circle c1 = new Circle(70 + (afstand * j), 300, radiusHjul);
            pane.getChildren().add(c1);

        }

        for (int j = 0; j < antalDoors; j++) {

            Line door = new Line(90 + (afstand * j), 200, 90 + (afstand * j), 300);
            pane.getChildren().add(door);
            door.setFill(Color.BLACK);
        }
    }
}

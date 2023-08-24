import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
public class Gui_konto extends Application{

    @Override
    public void start (Stage stage){
        Pane pane = new Pane();
        Scene scene = new Scene(pane,400,400);

        stage.setTitle("Konto");
        stage.setScene(scene);
        stage.show();
    }

}

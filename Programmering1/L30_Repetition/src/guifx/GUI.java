package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application {

    ListView lvwJob = new ListView();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Prøve 2020");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        Label lbl = new Label("Festival");
        pane.add(lbl,0,0);

        lvwJob = new ListView();
        pane.add(lvwJob,0,1);
    }


}

package gui;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Menu extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // Load the background image
        Image backgroundImage = new Image("gui/Background.png");

        // Create a background with the image
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        // Set the background to the root pane
        root.setBackground(new Background(background));

        // Create a VBox to hold the buttons
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        // Create the start button
        Button startButton = new Button("Start");
        startButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10px 20px;");
        startButton.setOnAction(e -> {
            YatzyGui yahtzee = new YatzyGui();
            yahtzee.start(stage);
        });

        //Animation
        TranslateTransition buttonAnimation = new TranslateTransition(Duration.millis(50), startButton);
        buttonAnimation.setFromY(0);
        buttonAnimation.setToY(5);
        buttonAnimation.setCycleCount(2);
        buttonAnimation.setAutoReverse(true);

        startButton.setOnMousePressed(event -> {
            buttonAnimation.playFromStart();
        });

        // Add the buttons to the VBox
        vbox.getChildren().addAll(startButton);

        // Add the VBox to the center of the root pane
        root.setCenter(vbox);

        // Resize the window to match the size of the background image
        Scene scene = new Scene(root, backgroundImage.getWidth(), backgroundImage.getHeight());

        // Set the stage properties
        stage.setScene(scene);
        stage.setTitle("Yahtzee");
        stage.show();
    }}
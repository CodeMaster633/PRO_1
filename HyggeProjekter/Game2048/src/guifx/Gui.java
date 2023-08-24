package guifx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Gui extends Application {

    private static final int SIZE = 4;
    private static final int TILE_SIZE = 100;

    private int[][] board = new int[SIZE][SIZE];
    private StackPane[][] tiles = new StackPane[SIZE][SIZE];
    private Label scoreLabel;
    private int score = 0;

    @Override
    public void start(Stage primaryStage) {
        GridPane root = createBoard();
        generateRandomTile();
        generateRandomTile();

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(this::handleKeyPress);

        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private GridPane createBoard() {
        GridPane boardPane = new GridPane();
        boardPane.setAlignment(Pos.CENTER);
        boardPane.setHgap(10);
        boardPane.setVgap(10);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Rectangle tileBackground = new Rectangle(TILE_SIZE, TILE_SIZE);
                tileBackground.setFill(Color.LIGHTGRAY);
                tileBackground.setStroke(Color.BLACK);
                tileBackground.setArcWidth(15);
                tileBackground.setArcHeight(15);

                Label tileLabel = new Label();
                tileLabel.setFont(Font.font("Arial", 32));

                StackPane tilePane = new StackPane(tileBackground, tileLabel);
                tiles[row][col] = tilePane;

                boardPane.add(tilePane, col, row);
            }
        }

        scoreLabel = new Label("Score: 0");
        scoreLabel.setFont(Font.font(20));
        boardPane.add(scoreLabel, 0, SIZE);

        return boardPane;
    }

    private void generateRandomTile() {
        int emptyCount = 0;
        for (int[] row : board) {
            for (int tile : row) {
                if (tile == 0) {
                    emptyCount++;
                }
            }
        }

        if (emptyCount == 0) {
            return;
        }

        int randomIndex = (int) (Math.random() * emptyCount);
        int value = Math.random() < 0.9 ? 2 : 4;

        int count = 0;
        outerLoop:
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    if (count == randomIndex) {
                        board[row][col] = value;
                        updateTile(row, col, value);
                        break outerLoop;
                    }
                    count++;
                }
            }
        }
    }

    private void handleKeyPress(KeyEvent event) {
        KeyCode code = event.getCode();
        boolean moved = false;

        switch (code) {
            case UP:
                moved = moveUp();
                break;
            case DOWN:
                moved = moveDown();
                break;
            case LEFT:
                moved = moveLeft();
                break;
            case RIGHT:
                moved = moveRight();
                break;
            default:
                break;
        }

        if (moved) {
            generateRandomTile();
            updateScore();
            if (isGameOver()) {
                showGameOver();
            }
        }
    }

    private boolean moveUp() {
        boolean moved = false;
        for (int col = 0; col < SIZE; col++) {
            for (int row = 1; row < SIZE; row++) {
                if (board[row][col] != 0) {
                    int value = board[row][col];
                    int prevRow = row - 1;
                    while (prevRow >= 0 && board[prevRow][col] == 0) {
                        board[prevRow][col] = value;
                        board[prevRow + 1][col] = 0;
                        prevRow--;
                        moved = true;
                    }
                    if (prevRow >= 0 && board[prevRow][col] == value) {
                        board[prevRow][col] *= 2;
                        score += board[prevRow][col];
                        board[row][col] = 0;
                        moved = true;
                    }
                }
            }
        }
        if (moved) {
            updateBoard();
        }
        return moved;
    }


    private boolean moveDown() {
        boolean moved = false;
        for (int col = 0; col < SIZE; col++) {
            for (int row = SIZE - 2; row >= 0; row--) {
                if (board[row][col] != 0) {
                    int value = board[row][col];
                    int nextRow = row + 1;
                    while (nextRow < SIZE && board[nextRow][col] == 0) {
                        board[nextRow][col] = value;
                        board[nextRow - 1][col] = 0;
                        nextRow++;
                        moved = true;
                    }
                    if (nextRow < SIZE && board[nextRow][col] == value) {
                        board[nextRow][col] *= 2;
                        score += board[nextRow][col];
                        board[row][col] = 0;
                        moved = true;
                    }
                }
            }
        }
        if (moved) {
            updateBoard();
        }
        return moved;
    }

    private boolean moveLeft() {
        boolean moved = false;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 1; col < SIZE; col++) {
                if (board[row][col] != 0) {
                    int value = board[row][col];
                    int prevCol = col - 1;
                    while (prevCol >= 0 && board[row][prevCol] == 0) {
                        board[row][prevCol] = value;
                        board[row][prevCol + 1] = 0;
                        prevCol--;
                        moved = true;
                    }
                    if (prevCol >= 0 && board[row][prevCol] == value) {
                        board[row][prevCol] *= 2;
                        score += board[row][prevCol];
                        board[row][col] = 0;
                        moved = true;
                    }
                }
            }
        }
        if (moved) {
            updateBoard();
        }
        return moved;
    }

    private boolean moveRight() {
        boolean moved = false;
        for (int row = 0; row < SIZE; row++) {
            for (int col = SIZE - 2; col >= 0; col--) {
                if (board[row][col] != 0) {
                    int value = board[row][col];
                    int nextCol = col + 1;
                    while (nextCol < SIZE && board[row][nextCol] == 0) {
                        board[row][nextCol] = value;
                        board[row][nextCol - 1] = 0;
                        nextCol                        ++;
                        moved = true;
                    }
                    if (nextCol < SIZE && board[row][nextCol] == value) {
                        board[row][nextCol] *= 2;
                        score += board[row][nextCol];
                        board[row][col] = 0;
                        moved = true;
                    }
                }
            }
        }
        if (moved) {
            updateBoard();
        }
        return moved;
    }

    private void updateBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                updateTile(row, col, board[row][col]);
            }
        }
    }

    private boolean isGameOver() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0 ||
                        (row > 0 && board[row][col] == board[row - 1][col]) ||
                        (row < SIZE - 1 && board[row][col] == board[row + 1][col]) ||
                        (col > 0 && board[row][col] == board[row][col - 1]) ||
                        (col < SIZE - 1 && board[row][col] == board[row][col + 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showGameOver() {
        Label gameOverLabel = new Label("Game Over!");
        gameOverLabel.setFont(Font.font(30));

        StackPane gameOverPane = new StackPane(gameOverLabel);
        gameOverPane.setAlignment(Pos.CENTER);
        gameOverPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5)");

        GridPane.setConstraints(gameOverPane, 0, 0, SIZE, SIZE);
        GridPane.setColumnSpan(gameOverPane, SIZE);
        GridPane.setRowSpan(gameOverPane, SIZE);

        ((GridPane) scoreLabel.getParent()).getChildren().add(gameOverPane);
    }

    private void updateScore() {
        scoreLabel.setText("Score: " + score);
    }

    private void updateTile(int row, int col, int value) {
        Label tileLabel = (Label) tiles[row][col].getChildren().get(1);
        tileLabel.setText(value > 0 ? String.valueOf(value) : "");
        tileLabel.setTextFill(value >= 8 ? Color.WHITE : Color.BLACK);

        Rectangle tileBackground = (Rectangle) tiles[row][col].getChildren().get(0);
        tileBackground.setFill(getTileColor(value));
    }

    private Color getTileColor(int value) {
        switch (value) {
            case 2:
                return Color.web("#AED6F1"); // Light Blue
            case 4:
                return Color.web("#5DADE2"); // Blue
            case 8:
                return Color.web("#F9E79F"); // Light Yellow
            case 16:
                return Color.web("#F7DC6F"); // Yellow
            case 32:
                return Color.web("#F5B041"); // Dark Yellow
            case 64:
                return Color.web("#EC7063"); // Light Red
            case 128:
                return Color.web("#E74C3C"); // Red
            case 256:
                return Color.web("#C0392B"); // Dark Red
            case 512:
                return Color.web("#F5CBA7"); // Light Orange
            case 1024:
                return Color.web("#F4D03F"); // Orange
            case 2048:
                return Color.web("#F39C12"); // Dark Orange
            default:
                return Color.LIGHTGRAY;
        }
    }

}
//    private Label[] labels;
//
//    @Override
//    public void start(Stage primaryStage) {
//        labels = new Label[4]; // Initialize the labels array with size 4
//
//        for (int i = 0; i < labels.length; i++) {
//            labels[i] = new Label("Label " + (i + 1)); // Create a new Label object for each element
//        }
//
//        VBox root = new VBox(labels);
//        Scene scene = new Scene(root, 400, 200);
//
//        scene.setOnKeyPressed(this::handleKeyPress);
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private void handleKeyPress(KeyEvent event) {
//        switch (event.getCode()) {
//            case UP:
//                updateLabelColors(Color.RED);
//                break;
//            case DOWN:
//                updateLabelColors(Color.GREEN);
//                break;
//            case LEFT:
//                updateLabelColors(Color.BLUE);
//                break;
//            case RIGHT:
//                updateLabelColors(Color.ORANGE);
//                break;
//            default:
//                updateLabelColors(Color.BLACK);
//                break;
//        }
//    }
//
//    private void updateLabelColors(Color color) {
//        if (labels != null) {
//            for (Label label : labels) {
//                label.setTextFill(color);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

//        pane.setPrefSize(850, 500);
//        pane.setPadding(new Insets(10));
//        pane.setHgap(20);
//        pane.setVgap(20);
//
//        Label lblBaner = new Label("Baner");
//        pane.add(lblBaner, 1, 0);
//
//        lvwBaner = new ListView();
//        lvwBaner.getItems().setAll(Controller.getBaner());
//        pane.add(lvwBaner, 1, 1, 1, 2);
//
//        Label lblSpillere = new Label("Spillere");
//        pane.add(lblSpillere, 2, 0);
//
//        lvwSpillere = new ListView();
//        lvwSpillere.getItems().setAll(Controller.getSpillere());
//        pane.add(lvwSpillere, 2, 1, 1, 2);
//
//        Label lblSpillerBookinger = new Label("Spilleren bookinger");
//        pane.add(lblSpillerBookinger, 3, 0);
//
//        txaSpillere = new TextArea();
//        pane.add(txaSpillere, 3, 1, 1, 2);
//        lvwSpillere.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent arg0) {
//                int index = lvwSpillere.getSelectionModel().getSelectedIndex();
//                txaSpillere.setText(Controller.getSpillere().get(index).getBookinger().toString());
//            }
//        });
//
//        Label lblBookingerBane = new Label("Antal bookinger på banen");
//        pane.add(lblBookingerBane, 1, 3);
//
//
//        txaBookingerBane = new TextArea();
//        pane.add(txaBookingerBane, 1, 4, 1, 2);
//        lvwBaner.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent arg0) {
//                int index = lvwBaner.getSelectionModel().getSelectedIndex();
//                txaBookingerBane.setText(Controller.getBaner().get(index).antalBookingerPrTimeStr());
//            }
//        });
//
//        Label lblOpretBooking = new Label("Opret booking");
//        pane.add(lblOpretBooking, 3, 3);
//
//        HBox hBox = new HBox();
//        HBox hBox2 = new HBox();
//        HBox hBox3 = new HBox();
//        VBox vBox = new VBox();
//
//
//        Label lblDato = new Label("Dato:");
//
//        txfDato = new TextField();
////        pane.add(txfDato,4,4);
//        hBox.getChildren().add(lblDato);
//        hBox.getChildren().add(txfDato);
//
//
//        Label lblTid = new Label("Tid:");
////        pane.add(lblTid, 3, 5);
//        txfTid = new TextField();
////        pane.add(txfTid,4,5);
//        hBox2.getChildren().add(lblTid);
//        hBox2.getChildren().add(txfTid);
//
//        CheckBox chbSingle = new CheckBox("Single");
//        hBox3.getChildren().add(chbSingle);
//
//        Button btnBookBane = new Button("Book bane til spiller");
//        btnBookBane.setOnMouseClicked(event -> opretBooking());
//
//
//        vBox.getChildren().add(hBox);
//        vBox.getChildren().add(hBox2);
//        vBox.getChildren().add(hBox3);
//        vBox.getChildren().add(btnBookBane);
//        pane.add(vBox, 3, 4);
//    }
//
//    private void opretBooking() {
//        if (txfDato.getText().equals("")||txfTid.getText().equals("")) {
//            System.out.println("Booking ikke oprettet");
//            popUpError();
//        }
//
//        LocalDate dato = LocalDate.parse(txfDato.getText());
//        LocalTime tid = LocalTime.parse(txfTid.getText());
//        Bane bane = (Bane) lvwBaner.getSelectionModel().getSelectedItem();
//        Spiller spiller = (Spiller) lvwSpillere.getSelectionModel().getSelectedItem();
//        Boolean single = chbSingle.isSelected();
//
//        popUp(Controller.createBooking(dato, tid, single, spiller, bane));
//
//        txfDato.clear();
//        txfTid.clear();
//    }
//
//    public static void popUp(Booking booking) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//
//        alert.setTitle("Booking oprettet");
//        alert.setContentText("Booking oprettet for " + booking.getSpiller().getNavn() + " på " + booking.getBane() + " d. " + booking.getDato() + " kl. " + booking.getTid());
//        alert.showAndWait();
//    }
//    private void popUpError() {
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//
//        alert.setTitle("Booking ikke oprettet");
//        alert.setContentText("Der er opstået en fejl - Prøv igen.");
//        alert.showAndWait();
//    }



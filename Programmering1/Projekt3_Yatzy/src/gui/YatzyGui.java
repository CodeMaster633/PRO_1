package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.YatzyDice;

import java.util.ArrayList;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();
    private int roundNumber = 1;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");

        // Create textfields for results
        for (int i = 0; i < 15; i++) {
            TextField resultField = new TextField();
            resultField.setEditable(false);
            resultField.setAlignment(Pos.CENTER_RIGHT);
            txfResults.add(resultField);
        }

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private final Label lblThrowCount = new Label();
    private final Button btnThrow = new Button(" Throw 1");


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues
        for (int i = 0; i < txfValues.length; i++) {
            TextField textField = new TextField();
            textField.setEditable(false);
            textField.setPrefHeight(50);
            textField.setPrefWidth(50);
            textField.setAlignment(Pos.CENTER);
            txfValues[i] = textField;
            dicePane.add(textField, i, 0);
        }

        // add chbHolds
        for (int i = 0; i < cbxHolds.length; i++) {
            CheckBox checkbox = new CheckBox("Hold");
            checkbox.setOnMouseClicked(event -> {
                CheckBox source = (CheckBox) event.getSource();
                source.setDisable(true);
            });
            cbxHolds[i] = checkbox;
            dicePane.add(checkbox, i, 1);
        }
        setHoldsDisabled(true);

        // add btnThrow
        btnThrow.setPrefHeight(50);
        btnThrow.setPrefWidth(100);
        btnThrow.setAlignment(Pos.CENTER);
        dicePane.add(btnThrow, 0, 2, 2, 1);
        btnThrow.setOnMouseClicked(event -> throwDice());

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields

        // add labels and results
        scorePane.add(new Label("1-s"), 0, 0);
        scorePane.add(txfResults.get(0), 1, 0);

        scorePane.add(new Label("2-s"), 0, 1);
        scorePane.add(txfResults.get(1), 1, 1);

        scorePane.add(new Label("3-s"), 0, 2);
        scorePane.add(txfResults.get(2), 1, 2);

        scorePane.add(new Label("4-s"), 0, 3);
        scorePane.add(txfResults.get(3), 1, 3);

        scorePane.add(new Label("5-s"), 0, 4);
        scorePane.add(txfResults.get(4), 1, 4);

        scorePane.add(new Label("6-s"), 0, 5);
        scorePane.add(txfResults.get(5), 1, 5);

        scorePane.add(new Label("Sum"), 0, 6);
        txfSumSame.setEditable(false);
        scorePane.add(txfSumSame, 1, 6);

        scorePane.add(new Label("Bonus"), 0, 7);
        txfBonus.setEditable(false);
        scorePane.add(txfBonus, 1, 7);

        scorePane.add(new Label("One pair"), 0, 9);
        scorePane.add(txfResults.get(6), 1, 9);

        scorePane.add(new Label("Two pairs"), 0, 10);
        scorePane.add(txfResults.get(7), 1, 10);

        scorePane.add(new Label("Three-same"), 0, 11);
        scorePane.add(txfResults.get(8), 1, 11);

        scorePane.add(new Label("Four-same"), 0, 12);
        scorePane.add(txfResults.get(9), 1, 12);

        scorePane.add(new Label("Full House"), 0, 13);
        scorePane.add(txfResults.get(10), 1, 13);

        scorePane.add(new Label("Small str."), 0, 14);
        scorePane.add(txfResults.get(11), 1, 14);

        scorePane.add(new Label("Large str."), 0, 15);
        scorePane.add(txfResults.get(12), 1, 15);

        scorePane.add(new Label("Chance"), 0, 16);
        scorePane.add(txfResults.get(13), 1, 16);

        scorePane.add(new Label("Yatsy"), 0, 17);
        scorePane.add(txfResults.get(14), 1, 17);

        scorePane.add(new Label("Sum"), 0, 18);
        txfSumOther.setEditable(false);
        scorePane.add(txfSumOther, 1, 18);

        scorePane.add(new Label("Total"), 0, 19);
        txfTotal.setEditable(false);
        scorePane.add(txfTotal, 1, 19);

    }

    // -------------------------------------------------------------------------

    // Create an action method for btnThrow's action.
    private void throwDice() {
        // Create a boolean array, that represents what dice are held, based on the checkboxes that are checked.
        boolean[] holds = new boolean[]{
            cbxHolds[0].isSelected(),
            cbxHolds[1].isSelected(),
            cbxHolds[2].isSelected(),
            cbxHolds[3].isSelected(),
            cbxHolds[4].isSelected()
        };
        // Throw the dice
        dice.throwDice(holds);
        setFaceValues();

        // If it is the first throw, enable hold checkboxes
        if (dice.getThrowCount() == 1) {
            setHoldsDisabled(false);
            btnThrow.setText("Throw 2");
        }

        if (dice.getThrowCount() == 2) {
            btnThrow.setText("Throw 3");
        }

        // If the throw count is now 3, update results and disable throw button
        if (dice.getThrowCount() == 3) {
            updateResultsAndDisableThrowButton();
            btnThrow.setText("Throw 1");
        }
    }

    // setFaceValues will update the dice face value text fields
    private void setFaceValues() {
        // Update the dice fields in the gui
        int[] diceValues = dice.getValues();
        for (int i = 0; i < diceValues.length; i++) {
            txfValues[i].setText(String.valueOf(diceValues[i]));
        }

    }

    private void updateResultsAndDisableThrowButton() {
        // Update the result checkboxes based on the dice.results. As the returned results array is
        // the same order as our txfResults ArrayList, we can update all the result textfields based on array index
        int[] results = dice.getResults();
        for (int i = 0; i < results.length; i++) {
            // If result field has already been picked (is disabled), skip updating that field
            if (txfResults.get(i).isDisabled()) {
                continue;
            }
            txfResults.get(i).setText(String.valueOf(results[i]));
        }

        // Disable throw button
        btnThrow.setDisable(true);
        // Disable all hold checkboxes
        setHoldsDisabled(true);

        // Activate result picking
        activateResultPicking();
    }

    // resetDice resets the dice object by overwriting the dice with a new YatsyDice object
    // and resets + disables the holds
    private void nextRound() {
        // Deactivate result picking
        deactivateResultPicking();

        // Update scores
        updateScores();

        // Increment round number
        roundNumber++;

        // If round is > 15, round is over
        if (roundNumber > 15) {
            return;
        }

        // Create new dice object
        dice = new YatzyDice();
        btnThrow.setDisable(false);
        // Uncheck all holds
        resetHolds();
        // Disable all holds
        setHoldsDisabled(true);

        // Set txf for dice to 0
        for (int i = 0; i < 5; i++) {
            txfValues[i].setText("0");
        }
    }

    private void setHoldsDisabled(boolean disabled) {
        for (CheckBox hold : cbxHolds) {
            hold.setDisable(disabled);
        }
    }

    // resetHolds unchecks all checkboxes
    private void resetHolds() {
        for (CheckBox hold : cbxHolds) {
            hold.setSelected(false);
        }
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    private void activateResultPicking() {
        for (TextField resultField : txfResults) {
            // If resultField is disabled, skip it as it has already been picked
            if (resultField.isDisabled()) {
                continue;
            }

            resultField.setStyle("-fx-control-inner-background: yellow");

            resultField.setOnMouseClicked(event -> {
                TextField field = (TextField) event.getSource();
                field.setDisable(true);
                nextRound();
            });
        }
    }

    // deactivateResultPicking will remove yellow background and remove on mouse clicked handler
    private void deactivateResultPicking() {
        for (TextField resultField : txfResults) {
            if (!resultField.isDisabled()) {
                resultField.setText("");
            }
            resultField.setStyle("-fx-control-inner-background: white");
            resultField.setOnMouseClicked(null);
        }
    }

    private void updateScores() {
        // Update sums
        int sumSame = 0;
        int sumOther = 0;
        for (int i = 0; i < 15; i++) {
            TextField resultField = txfResults.get(i);
            // We use the disabled flag to determine if a field has been picked
            // if the field is not disabled (has not been picked yet), we skip it
            if (!resultField.isDisabled()) {
                continue;
            }

            int fieldValue = Integer.parseInt(resultField.getText());

            if (i < 6) { // if i < 6 (same face fields, add to sumSame)
                sumSame += fieldValue;
            } else { // otherwise, add to sumOther
                sumOther += fieldValue;
            }
        }
        txfSumSame.setText(String.valueOf(sumSame));
        txfSumOther.setText(String.valueOf(sumOther));

        // Update bonus. If sumSame >= 63, bonus is set to 50
        int bonus = 0;
        if (sumSame >= 63) {
            bonus = 50;
        }
        txfBonus.setText(String.valueOf(bonus));

        // Update total
        int total = sumSame + bonus + sumOther;
        txfTotal.setText(String.valueOf(total));
    }

}

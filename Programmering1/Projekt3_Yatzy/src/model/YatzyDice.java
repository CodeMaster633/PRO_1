package model;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class YatzyDice {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6 for i in [0..4]
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private final Random random = new Random();

    /**
     * Return the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Set the 5 face values of the dice.<br/>
     * Pre: 1 <= values[i] <= 6 for i in [0..4].<br/>
     * Note: This method is only to be used in tests.
     */
    void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Return the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Reset the throw count.
     */
    public void resetThrowCount() {
        this.throwCount = 0;
    }

    /**
     * Roll the 5 dice. Only roll dice that are not hold.<br/>
     * Note: holdStatus[index] is true, if die no. index is hold (for index in [0..4]).
     */
    public void throwDice(boolean[] holdStatus) {
        int[] newValues = Arrays.copyOf(this.values, 5);
        for (int i = 0; i < newValues.length; i++) {
            // if hold for dice, skip the roll
            if (holdStatus[i]) {
                continue;
            }
            newValues[i] = (int) (Math.random() * 6 + 1);
        }

        setValues(newValues);
        throwCount += 1;
    }

    // -------------------------------------------------------------------------

    /**
     * Return all results possible with the current face values.<br/>
     * The order of the results is the same as on the score board.<br/>
     * Note: This is an optional method. Comment this method out,<br/>
     * if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Return an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
    // Index 0 is not used.
    // Note: This method can be used in several of the following methods.
    private int[] frequency() {

        int[] counter = new int[7];

        for (int i = 0; i < counter.length; i++) {
            counter[values[i]]++;
        }
        return counter;
    }

    /** Test passed
     * Return same-value points for the given face value.<br/>
     * Returns 0, if no dice has the given face value.<br/>
     * Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        int sum = 0;

        // checking if index i is the same as the paramenter value, then it will at the number to sum
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value) {
                sum += values[i];
            }
        }
        return sum;
    }

    public int sameValue(int value) {
        int count = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i] == value) {
                count++;
            }
        }

        return count;
    }

    /** Test passed
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {

        int highestValue = 0;
        int secondHighestValue = 0;


        boolean pairs = false;

        int[] counter = new int[7];

        for (int i = 0; i < values.length; i++) {
            counter[values[i]]++;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] >= 2 && !pairs){
                highestValue = i * 2;
                pairs = true;
            }
            if (counter[i] >= 2 && pairs){

                secondHighestValue = i * 2;

                if (secondHighestValue > highestValue){
                    int container = highestValue;
                    highestValue = secondHighestValue;
                    secondHighestValue = container;
                }

            }
        }
        if (pairs) {
            return highestValue;
        }

        return 0;
    }

    /** test passed
     * Return points for two pairs<br/>
     * (for the 2 face values giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int twoPairPoints() {
        int[] counter = new int[7]; // 7 as im counting dice face from 1-6

        for (int i = 0; i < values.length; i++) {
            counter[values[i]]++;
        }

        int numPairs = 0;
        int sum = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] >= 2) {
                numPairs++;
                sum += i * 2;
            }

        }

        if (numPairs > 1) {
            return sum;
        }

        return 0;
    }

    /** Test passed
     * Return points for 3 of a kind.<br/>
     * Return 0, if there aren't 3 dice with the same face value.
     */
    public int threeSamePoints() {
        boolean threeSameValues = false;
        int[] counter = new int[7];

        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            counter[values[i]]++;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] >= 3) {
                threeSameValues = true;
                sum = i * 3;
            }
        }
        if (threeSameValues == true) {
            return sum;
        }

        return 0;
    }

    /** test passed
     * Return points for 4 of a kind.<br/>
     * Return 0, if there aren't 4 dice with the same face value.
     */
    public int fourSamePoints() {

        boolean fourSameValues = false;
        int[] counter = new int[7];

        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            counter[values[i]]++;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] >= 4) {
                fourSameValues = true;
                sum = i * 4;
            }
        }
        if (fourSameValues == true) {
            return sum;
        }

        return 0;
    }



    /** Test passed
     * Return points for full house.<br/>
     * Return 0, if there aren't 3 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int fullHousePoints() {

        int[] counter = new int[7]; // counter array to count occurence of every value

        boolean threeFaceValue = false;
        boolean twoFaceValue = false;

        // counting occurence. Value 1 on index 1 ...
        for (int i = 0; i < values.length; i++) {
            counter[values[i]]++; // i = 0, values[0] = value, counter[value] + 1
        }

        // checking if any index is the value 3
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 3) {
                threeFaceValue = true;
            }
            // checking if any index has the value of 2
            if (counter[i] == 2) {
                twoFaceValue = true;
            }

        }

        // if there are index containing both 3 and 2, then return sum of values array
        if (threeFaceValue == true && twoFaceValue == true){
            return IntStream.of(values).sum();
        }

        return 0;
    }


    /** Test passed
     * Return points for small straight.<br/>
     * Return 0, if the dice aren't showing 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int smallStraightPoints = 0;
        int count = 0;

        for (int i = 1; i <= 5; i++) {
            if (sameValue(i) == 1) {
                count++;
            }
        }
        if(count==5){
            smallStraightPoints=15;
        }

        return smallStraightPoints;
    }


    /** Test passed
     * Return points for large straight.<br/>
     * Return 0, if the dice aren't showing 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int largeStraightPoints = 0;
        int count = 0;

        for (int i = 2; i <= 6; i++) {
            if (sameValue(i) == 1) {
                count++;
            }
        }
        if(count==5){
            largeStraightPoints=20;
        }

        return largeStraightPoints;

    }

    // return the sum of the values
    public int chancePoints() {

        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }

        return sum;
    }

    // returns 50 if yatzy
    public int yatzyPoints() {
        for (int i = 1; i < values.length; i++) {
            if (values[0] != values[i]){
                return 0;
            }
        }
        return 50;
    }
}

import java.awt.*;

public class Car {

    private Color color;
    private int doors;
    private int wheels;

    public Car(Color color, int doors, int wheels){
        this.color=color;
        this.doors=doors;
        this.wheels =wheels;
    }
    public Car(){
        this(Color.red,1,3);
    }

    public Color getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return wheels;
    }
}

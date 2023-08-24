package rep2.guifx;

import javafx.application.Application;
import rep2.application.controller.Controller;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();

        Application.launch(Gui.class);


    }
}

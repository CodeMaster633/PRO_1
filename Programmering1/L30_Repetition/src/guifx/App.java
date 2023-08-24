package guifx;

import application.controller.Controller;
import javafx.application.Application;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Controller.initStorage();
//        test();
        Application.launch(GUI.class);

    }

}


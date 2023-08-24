package gui;


import javafx.application.Application;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);

    }

    public static void initStorage(){
        System.out.println("Storage setup completed");
    }
}

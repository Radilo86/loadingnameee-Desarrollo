package view.App;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            //MainController mc = new MainController();
            URL url = new File("src/main/resources/Main.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);


            //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view.App/Main.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("EntreCulturas");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Crud.Crud;
import model.Entities.Trabajadores;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import java.io.IOException;
import java.net.URL;

public class MainController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void imprimirTrabajadores(ActionEvent event){

        Crud crud = new Crud();
        Trabajadores t =new Trabajadores();

        crud.listar(t);

    }

    public void showTrabajadores(ActionEvent event)  throws IOException {
        URL url = new File("src/main/resources/trabajadores.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        //root = FXMLLoader.load(getClass().getClassLoader().getResource("trabajadores.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void showProyectos(ActionEvent event)  throws IOException {
        URL url = new File("src/main/resources/proyectos.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        //root = FXMLLoader.load(getClass().getClassLoader().getResource("proyectos.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showSedes(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/sedes.fxml").toURI().toURL();
        root = FXMLLoader.load(url);

        //root = FXMLLoader.load(getClass().getClassLoader().getResource("sedes.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

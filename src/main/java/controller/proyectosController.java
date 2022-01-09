package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Crud.Crud;
import model.Entities.Proyectos;
import model.Entities.Trabajadores;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class proyectosController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Declaracion campos de texto
    @FXML
    private TextField idProyectoTf;
    @FXML
    private TextField paisProyectoTf;

    //Declaración de la tabla
    @FXML
    private TableView<Proyectos> tablaProyectos;
    @FXML
    private TableColumn paisCol;
    @FXML
    private TableColumn idCol;
    ObservableList<Proyectos> proyectos;



    public void volver(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void verProyectos() {
        Crud crud = new Crud();
        Proyectos p =new Proyectos();

        paisCol.setCellValueFactory(new PropertyValueFactory<Proyectos, String>("pais"));
        idCol.setCellValueFactory(new PropertyValueFactory<Proyectos, Integer>("idproyectos"));

        List<Proyectos> proyList = new ArrayList<Proyectos>();

        proyList=crud.listar(p);

        if (proyList==null){
            System.out.println("La lista es null!!");
        }

        proyectos = FXCollections.observableArrayList(proyList);
        tablaProyectos.setItems(proyectos);
    }

    public void addProyecto() {
        Proyectos p = new Proyectos();
        p.setPais(paisProyectoTf.getText());

        Crud crud = new Crud();
        crud.crear(p);
        verProyectos();
    }

    public void searchProyecto() {
        Crud crud = new Crud();
        Proyectos p = new Proyectos();
        p.setIdproyectos(Integer.parseInt((idProyectoTf.getText())));

        paisCol.setCellValueFactory(new PropertyValueFactory<Proyectos, String>("pais"));
        idCol.setCellValueFactory(new PropertyValueFactory<Proyectos, Integer>("idproyectos"));

        List<Proyectos> proyList = new ArrayList<Proyectos>();

        Object ob = crud.leer(p);

        if(ob==null){
            System.out.println("Ob es NULLLLLL");
        }
        Proyectos buscado = (Proyectos) ob;
        proyList.add(buscado);
        if (proyList==null){
            System.out.println("La lista es null!!");
        }


        proyectos = FXCollections.observableArrayList(proyList);

        tablaProyectos.setItems(proyectos);
    }

    public void delProyecto() {
        Proyectos p = new Proyectos();
        p.setIdproyectos(Integer.parseInt(idProyectoTf.getText()));
        Crud crud = new Crud();
        crud.borrar(p);
        verProyectos();
    }

    public void updateProyecto() {
        Proyectos p = new Proyectos();
        p.setPais(paisProyectoTf.getText());
        p.setIdproyectos(Integer.parseInt(idProyectoTf.getText()));
        Crud crud = new Crud();
        crud.actualizar(p);
        verProyectos();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        verProyectos();
    }
}

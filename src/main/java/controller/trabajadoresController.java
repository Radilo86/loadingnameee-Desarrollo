package controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Crud.Crud;
import model.Entities.Trabajadores;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class trabajadoresController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Declaracion de botones
    @FXML
    private Button addTrabajadorBtn;
    @FXML
    private Button searchTrabajadorBtn;
    @FXML
    private Button delTrabajadorBtn;
    @FXML
    private Button updTrabajadorBtn;
    @FXML
    private Button listTrabajadoresBtn;
    @FXML
    private Button volverBtn;

    //Declaracion campos de tesxto
    @FXML
    private TextField nombreTf;
    @FXML
    private TextField edadTf;
    @FXML
    private TextField fechaIncTf;
    @FXML
    private TextField idTf;

    //Declaramos la tabla y las columnas

    @FXML
    private TableView<Trabajadores> tablaTrabajadores;
    @FXML
    private TableColumn nombreCol;
    @FXML
    private TableColumn edadCol;
    @FXML
    private TableColumn fechaIncCol;
    @FXML
    private TableColumn idCol;
    ObservableList<Trabajadores> trabajadores;


    private int posicionTrabEnTabla;


    @FXML
    public void addTrabajador(){
        Trabajadores t = new Trabajadores();
        t.setNombre(nombreTf.getText());
        t.setEdad(Integer.parseInt(edadTf.getText()));
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date parsed = format.parse(fechaIncTf.getText());
           java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
           t.setFechaIncorporacion(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Crud crud = new Crud();
        crud.crear(t);
        verTrabajadores();
    }

    @FXML
    public void searchTrabajador(){
        Crud crud = new Crud();
        Trabajadores t = new Trabajadores();
        t.setId(Integer.parseInt(idTf.getText()));

        nombreCol.setCellValueFactory(new PropertyValueFactory<Trabajadores, String>("nombre"));
        edadCol.setCellValueFactory(new PropertyValueFactory<Trabajadores, Integer>("edad"));
        fechaIncCol.setCellValueFactory(new PropertyValueFactory<Trabajadores,java.sql.Date>("fechaIncorporacion"));
        idCol.setCellValueFactory(new PropertyValueFactory<Trabajadores, Integer>("id"));

        List<Trabajadores> trabList = new ArrayList<Trabajadores>();

        Object ob = crud.leer(t);

        if(ob==null){
            System.out.println("Ob es NULLLLLL");
        }

        Trabajadores buscado = (Trabajadores)ob;


        /*System.out.println("Nombre: " + buscado.getNombre());
*/

        trabList.add(buscado);

        if (trabList==null){
            System.out.println("La lista es null!!");
        }


        trabajadores = FXCollections.observableArrayList(trabList);

        tablaTrabajadores.setItems(trabajadores);

    }
    @FXML
    public void delTrabajador(){
        Trabajadores t = new Trabajadores();
        t.setId(Integer.parseInt(idTf.getText()));
        Crud crud = new Crud();
        crud.borrar(t);
        verTrabajadores();

    }
    @FXML
    public void updateTrabajador(){
        Trabajadores t = new Trabajadores();
        t.setId(Integer.parseInt(idTf.getText()));
        Crud crud = new Crud();
        crud.actualizar(t);
        verTrabajadores();

    }
    @FXML
    public void volver(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void verTrabajadores(){

        Crud crud = new Crud();
        Trabajadores t =new Trabajadores();

        nombreCol.setCellValueFactory(new PropertyValueFactory<Trabajadores, String>("nombre"));
        edadCol.setCellValueFactory(new PropertyValueFactory<Trabajadores, Integer>("edad"));
        fechaIncCol.setCellValueFactory(new PropertyValueFactory<Trabajadores,java.sql.Date>("fechaIncorporacion"));
        idCol.setCellValueFactory(new PropertyValueFactory<Trabajadores, Integer>("id"));

        List<Trabajadores> trabList = new ArrayList<Trabajadores>();

        trabList=crud.listar(t);

        if (trabList==null){
            System.out.println("La lista es null!!");
        }


        trabajadores = FXCollections.observableArrayList(trabList);

        tablaTrabajadores.setItems(trabajadores);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        verTrabajadores();
    }
}

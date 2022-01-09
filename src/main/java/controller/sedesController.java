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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Crud.Crud;
import model.Entities.Sedes;
import model.Entities.Trabajadores;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class sedesController implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;

    //Declaracion de botones
    @FXML
    private Button AñadirSedeBtn;
    @FXML
    private Button BuscarSedeBtn;
    @FXML
    private Button EliminarSedeBtn;
    @FXML
    private Button ActualizarSedeBtn;
    @FXML
    private Button VolverSedeBtn;

    //Declaracion campos de texto (TextField)
    @FXML
    private TextField NombreSedeTxtField;
    @FXML
    private TextField DireccionSedeTxtField;
    @FXML
    private TextField MtsSedeTxtField;
    @FXML
    private TextField TelefonoSedeTxtField;
    @FXML
    private TextField IdSedeTxtField;

    //Declaramos la tabla y las columnas
    @FXML
    private TableView<Sedes> TablaSedes;
    @FXML
    private TableColumn NombreSedeCol;
    @FXML
    private TableColumn DireccionSedeCol;
    @FXML
    private TableColumn MtsSedeCol;
    @FXML
    private TableColumn TelefonoSedeCol;
    @FXML
    private TableColumn IdSedeCol;

    ObservableList<Sedes> sedes;

    @FXML
    public void addSede(){
        Sedes s = new Sedes();
        s.setNombre(NombreSedeTxtField.getText());
        s.setDireccion(DireccionSedeTxtField.getText());
        s.setMts(new BigDecimal(MtsSedeTxtField.getText()));
        s.setTelefono(TelefonoSedeTxtField.getText());
        Crud crud = new Crud();
        crud.crear(s);
        verSedes();
    }

    @FXML
    public void eliminarSede(){
        Sedes s = new Sedes();
        s.setIdSede(Integer.parseInt(IdSedeTxtField.getText()));
        Crud crud = new Crud();
        crud.borrar(s);
        verSedes();
    }

    @FXML
    public void actualizarSede(){
        Sedes s = new Sedes();
        s.setIdSede(Integer.parseInt(IdSedeTxtField.getText()));
        Crud crud = new Crud();
        crud.actualizar(s);
        verSedes();
    }

    @FXML
    public void buscarSede(){
        Crud crud = new Crud();
        Sedes s = new Sedes();
        s.setIdSede(Integer.parseInt(IdSedeTxtField.getText()));

        NombreSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes, String>("nombre"));
        DireccionSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes, String>("direccion"));
        MtsSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes, BigDecimal>("mts"));
        TelefonoSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes, String>("telefono"));
        IdSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes,Integer>("id_sede"));

        List<Sedes> sedesLista= new ArrayList<Sedes>();

        Object ob = crud.leer(s);

        if(ob==null){
            System.out.println("Ob es NULL");
        }

        Sedes buscado = (Sedes)ob;

        sedesLista.add(buscado);

        if (sedesLista==null){
            System.out.println("La lista es null!!");
        }

        sedes = FXCollections.observableArrayList(sedesLista);

        TablaSedes.setItems(sedes);
    }

    public void volver(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void verSedes(){

        Crud crud = new Crud();
        Sedes s =new Sedes();

        NombreSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes, String>("nombre"));
        DireccionSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes, String>("direccion"));
        MtsSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes, BigDecimal>("mts"));
        TelefonoSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes, String>("telefono"));
        IdSedeCol.setCellValueFactory(new PropertyValueFactory<Sedes,Integer>("id_sede"));

        List<Sedes> listaSede = new ArrayList<Sedes>();

        listaSede=crud.listar(s);

        if (listaSede==null){
            System.out.println("La lista es null!!");
        }


        sedes = FXCollections.observableArrayList(listaSede);

        TablaSedes.setItems(sedes);
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        verSedes();
    }
}

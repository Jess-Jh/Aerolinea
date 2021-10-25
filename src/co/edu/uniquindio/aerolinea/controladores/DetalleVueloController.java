package co.edu.uniquindio.aerolinea.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aeronave;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class DetalleVueloController implements Initializable {
	
	TiqueteController tiqueteController;
	
	//----------SINGLETON----------------------------------------------------->>
	ModelFactoryController modelFactoryController;
	Aerolinea aerolinea;
	
	public DetalleVueloController() {
		modelFactoryController = ModelFactoryController.getInstance();
		aerolinea = modelFactoryController.getAerolinea();
	}
	
    public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	//-----------------------------------------------------------------------||

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancelarCompra;

    @FXML
    private Button btnRealizarCompra;

    @FXML
    private ComboBox<String> cmbDestino;

    @FXML
    private ComboBox<String> cmbOrigen;

    @FXML
    private TableColumn<Aeronave, String> columnCantPasajeros;

    @FXML
    private TableColumn<Aeronave, String> columnDuracionVuelo;

    @FXML
    private TableColumn<Aeronave, String> columnHoraSalida;

    @FXML
    private TableColumn<Aeronave, String> columnNombreAeronave;

    @FXML
    private ToggleGroup grupoVuelo;

    @FXML
    private RadioButton rbtIda;

    @FXML
    private RadioButton rbtidaVuelta;

    @FXML
    private TableView<Aeronave> tableViewVuelos;

    @FXML
    private TextField txtCostoPorPersona;

    @FXML
    private TextField txtVuelo;

    @FXML
    void cancelarCompra(ActionEvent event) {

    }

    @FXML
    void realizarCompra(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}



}


package co.edu.uniquindio.aerolinea.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aeronave;
import co.edu.uniquindio.aerolinea.modelo.Ruta;
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
import javafx.scene.control.cell.PropertyValueFactory;

public class DetalleVueloController implements Initializable {
		
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
    private TableColumn<Aeronave, String> columnNumeroIdAvion;

    @FXML
    private TableColumn<Aeronave, String> columnNombreAeronave;
    
    @FXML
    private TableColumn<Ruta, String> columnDestino;

    @FXML
    private TableColumn<Ruta, String> columnDuracion;

    @FXML
    private TableColumn<Ruta, String> columnHoraSalida;

    @FXML
    private TableColumn<Ruta, String> columnOrigen;

    @FXML
    private ToggleGroup grupoVuelo;

    @FXML
    private RadioButton rbtIda;

    @FXML
    private RadioButton rbtidaVuelta;

    @FXML
    private TableView<Aeronave> tableViewVuelos;
    
    @FXML
    private TableView<Ruta> tableViewRutas;

    @FXML
    private TextField txtCostoPorPersona;

    @FXML
    private TextField txtVuelo;
    
    private AplicacionAerolinea aplicacionAerolinea;
    
    private Aeronave aeronaveSeleccion;
    
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		this.columnNombreAeronave.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnNumeroIdAvion.setCellValueFactory(new PropertyValueFactory<>("numIdentificacionAvion"));
		this.columnOrigen.setCellValueFactory(new PropertyValueFactory<>("ciudadOrigen"));
		this.columnDestino.setCellValueFactory(new PropertyValueFactory<>("ciudadDestino"));
		this.columnDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
		this.columnHoraSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
		
		//Obtener selección de la tabla
		tableViewVuelos.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				aeronaveSeleccion = newSelection;
				if(aeronaveSeleccion != null) txtVuelo.setText(aeronaveSeleccion.getNombre());
			}
		});
//		tableViewVuelos.setDisable(true);
	}
    
    // Listado de Aeronaves que se muestran en la interfaz 
    ObservableList<Aeronave> listadoAeronaves = FXCollections.observableArrayList();
    // Listado de Rutas que se muestran en la interfaz 
    ObservableList<Ruta> listadoRutas = FXCollections.observableArrayList();
    
    public void setAplicacion(AplicacionAerolinea aplicacionAerolinea) {
    	this.aplicacionAerolinea = aplicacionAerolinea;
    	this.aerolinea = aplicacionAerolinea.getAerolinea();
    	tableViewVuelos.getItems().clear();
    	tableViewVuelos.setItems(getVuelos());
    	tableViewRutas.getItems().clear();
    	tableViewRutas.setItems(getRutas());
    }
    
    /**
     * Obtener los vuelos de la aerolínea
     * @return
     */
	private ObservableList<Aeronave> getVuelos() {
		listadoAeronaves.addAll(aerolinea.getListaAeronaves());
		return listadoAeronaves;
	}
	
    /**
     * Obtener las rutas de la aerolínea
     * @return
     */
	private ObservableList<Ruta> getRutas() {
		listadoRutas.addAll(aerolinea.getListaRutas());
		return listadoRutas;
	}

	public void recuperarDatos(String origen, String destino, String viajeSeleccionado) {
		cmbOrigen.setValue(origen);
		cmbDestino.setValue(destino);
		
		if(viajeSeleccionado.equalsIgnoreCase("ida")) rbtIda.setSelected(true);
		else rbtidaVuelta.setSelected(true);
				
	}    

    @FXML
    void cancelarCompra(ActionEvent event) {
//    	aplicacionAerolinea.mostrarVentanaPrincipal();
    }

    @FXML
    void realizarCompra(ActionEvent event) {

    }





}


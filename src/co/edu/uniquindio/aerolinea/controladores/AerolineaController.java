package co.edu.uniquindio.aerolinea.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.CruceAeronavesRutas;
import co.edu.uniquindio.aerolinea.modelo.Tripulante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class AerolineaController implements Initializable {

	//----------SINGLETON----------------------------------------------------->>
	ModelFactoryController modelFactoryController;
	Aerolinea aerolinea;
	
	public AerolineaController() {
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
    private Button btnBuscarViaje;

    @FXML
    private Button btnCancelarCompra;

    @FXML
    private Button btnCancelarCompraTiquetes;

    @FXML
    private Button btnPagarTiquetes;

    @FXML
    private Button btnRealizarAsignacion;

    @FXML
    private Button btnRealizarCompra;

    @FXML
    private Button btnSeleccionarPuesto;

    @FXML
    private ComboBox<String> cmbClase;
    ObservableList<String> listaCmbClase = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> cmbDestino;
    ObservableList<String> listaCmbDestino = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> cmbDestino1;

    @FXML
    private ComboBox<String> cmbOrigen;
    ObservableList<String> listaCmbOrigen = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> cmbOrigen1;

    @FXML
    private TableColumn<Tripulante, String> columnApellidoTripulante;

    @FXML
    private TableColumn<Tripulante, String> columnCargoTipulanteAsignado;

    @FXML
    private TableColumn<Tripulante, String> columnCargoTripulante;

    @FXML
    private TableColumn<Tripulante, String> columnCedulaTripulante;

    @FXML
    private TableColumn<Tripulante, String> columnCedulaTripulanteAsignado;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnDestino;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnDestinoTripulacion;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnDuracion;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnHoraSalida;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnNombreAeronave;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnNombreAeronaveTripulacion;

    @FXML
    private TableColumn<Tripulante, String> columnNombreTripulante;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnNumeroIdAvion;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnNumeroIdAvionTripulacion;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnOrigen;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnOrigenTripulacion;
    
    @FXML
    private ToggleGroup grupoVuelo;

    @FXML
    private ToggleGroup grupoVuelo1;

    @FXML
    private RadioButton rbtIda;

    @FXML
    private RadioButton rbtIda1;

    @FXML
    private RadioButton rbtidaVuelta;

    @FXML
    private RadioButton rbtidaVuelta1;

    @FXML
    private Slider sldNumeroPersonas;

    @FXML
    private TabPane tabPrincipalAerolinea;

    @FXML
    private TabPane tabPrincipalTiquetes;

    @FXML
    private TableView<CruceAeronavesRutas> tableViewVuelosTripulacion;

    @FXML
    private TableView<Tripulante> tableViewTripulantes;

    @FXML
    private TableView<CruceAeronavesRutas> tableViewVuelos;

    @FXML
    private TableView<Tripulante> tableviewAsignacionVuelos;

    @FXML
    private TextField txtApellido;

    @FXML
    private Label txtAsignacionTripulantes;

    @FXML
    private TextField txtCorreoElectronico;

    @FXML
    private TextField txtCostoPorPersona;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtDireccionResidencia;

    @FXML
    private TextField txtDuracionVuelo;

    @FXML
    private DatePicker txtFechaNacimiento;

    @FXML
    private DatePicker txtFechaRegreso;

    @FXML
    private DatePicker txtFechaSalida;

    @FXML
    private TextField txtHoraSalida;

    @FXML
    private Label txtIdAvion;

    @FXML
    private TextField txtIdentificacionOPasaporte;

    @FXML
    private Label txtLabel;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecioTotal;

    @FXML
    private TextField txtTarjetaDebitoCredito;

    @FXML
    private TextField txtVuelo;

    @FXML
    private TextField txtVuelo1;
    
    private AplicacionAerolinea aplicacionAerolinea;
    
    private CruceAeronavesRutas aeronaveSeleccion;
    private CruceAeronavesRutas aeronaveSeleccionTripulacion;
    private Tripulante tripulanteSeleccion;
    private Tripulante tripulanteSeleccionAsignado;
    
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		//----------------------------------------- Gestión Tripulantes ----------------------------------------------->>
		//----------------------------------------- Vuelos ------------------------------------------------------------>>
		this.columnNombreAeronaveTripulacion.setCellValueFactory(new PropertyValueFactory<>("nombreAeronave"));
		this.columnNumeroIdAvionTripulacion.setCellValueFactory(new PropertyValueFactory<>("idAvion"));
		this.columnOrigenTripulacion.setCellValueFactory(new PropertyValueFactory<>("ciudadOrigen"));
		this.columnDestinoTripulacion.setCellValueFactory(new PropertyValueFactory<>("ciudadDestino"));
		
		//Obtener selección de la tabla
		tableViewVuelosTripulacion.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				aeronaveSeleccionTripulacion = newSelection;
				if(aeronaveSeleccionTripulacion != null) txtIdAvion.setText(aeronaveSeleccionTripulacion.getIdAvion());
			}
		});
		//-------------------------------------------------------------------------------------------------------------||
		//----------------------------------------- Tripulación ------------------------------------------------------->>
		this.columnNombreTripulante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellidoTripulante.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		this.columnCedulaTripulante.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		this.columnCargoTripulante.setCellValueFactory(new PropertyValueFactory<>("tipoTripulante"));
		
		tableViewTripulantes.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				tripulanteSeleccion = newSelection;
//				if(tripulanteSeleccion != null) txtVuelo.setText(aeronaveSeleccion.getNombre());
			}
		});
		//-------------------------------------------------------------------------------------------------------------||
		//----------------------------------------- Asignación de Vuelos ---------------------------------------------->>
		this.columnCedulaTripulanteAsignado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnCargoTipulanteAsignado.setCellValueFactory(new PropertyValueFactory<>("tipoTripulante"));
		
		tableviewAsignacionVuelos.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				tripulanteSeleccionAsignado = newSelection;
//				if(tripulanteSeleccionAsignado != null) txtVuelo.setText(aeronaveSeleccion.getNombre());
			}
		});
		//-------------------------------------------------------------------------------------------------------------||
		
		this.columnNombreAeronave.setCellValueFactory(new PropertyValueFactory<>("nombreAeronave"));
		this.columnNumeroIdAvion.setCellValueFactory(new PropertyValueFactory<>("idAvion"));
		this.columnOrigen.setCellValueFactory(new PropertyValueFactory<>("ciudadOrigen"));
		this.columnDestino.setCellValueFactory(new PropertyValueFactory<>("ciudadDestino"));
		this.columnDuracion.setCellValueFactory(new PropertyValueFactory<>("duracionViaje"));
		this.columnHoraSalida.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
		
		//Obtener selección de la tabla
		tableViewVuelos.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				aeronaveSeleccion = newSelection;
				if(aeronaveSeleccion != null) txtVuelo.setText(aeronaveSeleccion.getNombreAeronave());
			}
		});
//		tableViewVuelos.setDisable(true);
	}
	
    // Listado de Aeronaves que se muestran en la interfaz 
    ObservableList<CruceAeronavesRutas> listadoAeronaves = FXCollections.observableArrayList();
    // Listado de Tripulantes que se muestran en la interfaz 
    ObservableList<Tripulante> listadoTripulantes = FXCollections.observableArrayList();
    
    public void setAplicacion(AplicacionAerolinea aplicacionAerolinea) {
    	this.aplicacionAerolinea = aplicacionAerolinea;
    	this.aerolinea = aplicacionAerolinea.getAerolinea();
    	
    	tableViewVuelosTripulacion.getItems().clear();
    	tableViewVuelosTripulacion.setItems(getVuelos());
//    	tableViewRutasTripulacion.getItems().clear();
//    	tableViewRutasTripulacion.setItems(getRutas());
    	
    	tableViewTripulantes.getItems().clear();
    	tableViewTripulantes.setItems(getTripulantes());
    	
    	tableviewAsignacionVuelos.getItems().clear();
    	tableviewAsignacionVuelos.setItems(getVuelosAsignados());
    	
    	tableViewVuelos.getItems().clear();
    	tableViewVuelos.setItems(getVuelos());
    	
//    	tableViewRutas.getItems().clear();
//    	tableViewRutas.setItems(getRutas());
    }
    
    /**
     * Obtener los vuelos de la aerolínea
     * @return
     */
	private ObservableList<CruceAeronavesRutas> getVuelos() {
		listadoAeronaves.clear();
		listadoAeronaves.addAll(aerolinea.datosViajes());
		return listadoAeronaves;
	}

	/**
	 * Obtener los tripulantes de la aerolínea
	 * @return
	 */
	private ObservableList<Tripulante> getTripulantes() {
		listadoTripulantes.addAll(aerolinea.getListaTripulantes());
		return listadoTripulantes;
	}

	/**
	 * Obtener la asignación de los vuelos de la aerolínea
	 * @return
	 */
	private ObservableList<Tripulante> getVuelosAsignados() {
		listadoTripulantes.addAll(aerolinea.getListaTripulantes());
		return listadoTripulantes;
	}

    @FXML
    void buscarViaje(ActionEvent event) {
    	tabPrincipalTiquetes.getSelectionModel().select(1);
    
    }

    @FXML
    void cancelarCompra(ActionEvent event) {
    	tabPrincipalTiquetes.getSelectionModel().select(0);

    }

    @FXML
    void cancelarCompraTiquetes(ActionEvent event) {
    	tabPrincipalTiquetes.getSelectionModel().select(1);

    }

    @FXML
    void pagarTiquetes(ActionEvent event) {
    	tabPrincipalAerolinea.getSelectionModel().select(2);

    }

    @FXML
    void realizarAsignacion(ActionEvent event) {
        
        tabPrincipalAerolinea.getSelectionModel().select(1);
        

    }

    @FXML
    void realizarCompra(ActionEvent event) {
    	tabPrincipalTiquetes.getSelectionModel().select(2);

    }

    @FXML
    void seleccionarPuesto(ActionEvent event) {
    }



   

}

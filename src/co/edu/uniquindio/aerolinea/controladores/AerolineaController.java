package co.edu.uniquindio.aerolinea.controladores;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.excepciones.CupoTripulanteException;
import co.edu.uniquindio.aerolinea.excepciones.DatosInvalidosException;
import co.edu.uniquindio.aerolinea.excepciones.EquipajeException;
import co.edu.uniquindio.aerolinea.excepciones.VueloException;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aeronave;
import co.edu.uniquindio.aerolinea.modelo.Cliente;
import co.edu.uniquindio.aerolinea.modelo.CruceAeronavesRutas;
import co.edu.uniquindio.aerolinea.modelo.Equipaje;
import co.edu.uniquindio.aerolinea.modelo.Ruta;
import co.edu.uniquindio.aerolinea.modelo.TipoTripulante;
import co.edu.uniquindio.aerolinea.modelo.Tiquete;
import co.edu.uniquindio.aerolinea.modelo.Tripulante;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controlador de la Aerolinea
 * @author Jessica Ospina
 */
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
    private Button btnRegistrarNuevoViaje;

    @FXML
    private Button btnPagarTiquetes;

    @FXML
    private Button btnRealizarAsignacion;

    @FXML
    private Button btnRealizarCompra;

    @FXML
    private Button btnSeleccionarPuesto;
    
    @FXML
    private Button btnAceptarRegistroEquipaje;
    
    @FXML
    private Button btnRegistrarEquipajes;

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
    private TableColumn<CruceAeronavesRutas, String> columnClaseTiquete;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnDestinoTiquete;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnDuracionViajeTiquete;

    @FXML
    private TableColumn<Equipaje, String> columnIdAvionEquipaje;

    @FXML
    private TableColumn<CruceAeronavesRutas, String> columnIdAvionTiquete;

    @FXML
    private TableColumn<Cliente, String> columnIdentificacionCliente;

    @FXML
    private TableColumn<Equipaje, String> columnIdentificacionClienteEquipaje;
    
    @FXML
    private TableColumn<Cliente, String> columnApellidoCliente;

    @FXML
    private TableColumn<Cliente, String> columnNombreCliente;

    @FXML
    private TableColumn<Equipaje, Double> columnPesoEquipaje;

    @FXML
    private FontAwesomeIconView iconEquip2;

    @FXML
    private Label lblAltoEquip2;

    @FXML
    private Label lblAnchoEquip2;

    @FXML
    private Label lblEquipaje2;

    @FXML
    private Label lblIgualEquip2;

    @FXML
    private Label lblLargoEquip2;

    @FXML
    private Label lblRequerimientoEquipajeClase;

    @FXML
    private Label lblSum1Equip2;

    @FXML
    private Label lblSum2Equip2;

    @FXML
    private TextField txtAltoEquipaje1;

    @FXML
    private TextField txtAltoEquipaje2;

    @FXML
    private TextField txtAltoEquipajeMano;

    @FXML
    private TextField txtAnchoEquipaje1;

    @FXML
    private TextField txtAnchoEquipaje2;

    @FXML
    private TextField txtAnchoEquipajeMano;

    @FXML
    private TextField txtFiltrarCliente;

    @FXML
    private TextField txtLargoEquipaje1;

    @FXML
    private TextField txtLargoEquipaje2;

    @FXML
    private TextField txtLargoEquipajeMano;

    @FXML
    private TextField txtPesoAdicional;

    @FXML
    private TextField txtPesoEquipaje1;

    @FXML
    private TextField txtPesoEquipaje2;

    @FXML
    private Label txtTextoSeleccionTripulantes1;

    @FXML
    private TextField txtTotalDimensionEquipaje1;

    @FXML
    private TextField txtTotalDimensionEquipaje2;

    @FXML
    private TextField txtTotalDimensionEquipajeMano;
    
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
    private TableView<Cliente> tableViewClientes;

    @FXML
    private TableView<Equipaje> tableViewEquipajes;

    @FXML
    private TableView<CruceAeronavesRutas> tableViewTiquetesCliente;

    @FXML
    private TextField txtApellido;

    @FXML
    private Label txtAsignacionTripulantes;
    
    @FXML
    private Label txtTextoConfirmacionSeleccionVuelo;

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
    private Label lblCantTiquetes;
    
    @FXML
    private Label txtTextoSeleccionVuelos;
    
    @FXML
    private Label txtTextoSeleccionTripulantes;
    
    @FXML
    private Label txtTextoSeleccionAuxiliaresVuelo;

    @FXML
    private Label txtTextoSeleccionCopiloto;

    @FXML
    private Label txtTextoSeleccionNumeroTripulantes;

    @FXML
    private Label txtTextoSeleccionPiloto;
    
    @FXML
    private Label txtTextoConfirmacionRegistroTripulantes;

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
    
    // Selección en las TableViews
    private CruceAeronavesRutas aeronaveSeleccion;
    private CruceAeronavesRutas aeronaveSeleccionTripulacion;
    private Tripulante tripulanteSeleccion;
    private Cliente clienteSeleccion;
    private CruceAeronavesRutas tiqueteSeleccion;
    private Equipaje equipajeSeleccion;
    double costoTotalViaje;
    int cantTiquetes = 0;;
    
    
    ArrayList<Button> listaPuestosUsuario = new ArrayList<>();
    
	// Listado de Aeronaves que se muestran en la interfaz 
    private ObservableList<CruceAeronavesRutas> listadoAeronaves = FXCollections.observableArrayList();
    // Listado de Tripulantes que se muestran en la interfaz 
    private ObservableList<Tripulante> listadoTripulantes = FXCollections.observableArrayList();
    private ObservableList<Tripulante> listadoTripulantesAsignados = FXCollections.observableArrayList();
    
    private ObservableList<Cliente> listadoClientes = FXCollections.observableArrayList();
    // Lista observable para filtrar una búsqueda
    ObservableList<Cliente> filtroListadoClientes = FXCollections.observableArrayList();

    private ObservableList<Equipaje> listadoEquipajes = FXCollections.observableArrayList();
    private ObservableList<CruceAeronavesRutas> listadoTiquetesCliente = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL location, ResourceBundle resource) {
			
		//----------------------------------------- Gestión Tripulantes --------------------------------------------------------------------------->>
		//----------------------------------------- Vuelos ------------------------------------------------------------>>
		
		this.columnNombreAeronaveTripulacion.setCellValueFactory(new PropertyValueFactory<>("nombreAeronave"));
		this.columnNumeroIdAvionTripulacion.setCellValueFactory(new PropertyValueFactory<>("idAvion"));
		this.columnOrigenTripulacion.setCellValueFactory(new PropertyValueFactory<>("ciudadOrigen"));
		this.columnDestinoTripulacion.setCellValueFactory(new PropertyValueFactory<>("ciudadDestino"));
		
		//Obtener selección de la tabla
		tableViewVuelosTripulacion.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				aeronaveSeleccionTripulacion = newSelection;			
				if(aeronaveSeleccionTripulacion != null) {
					txtIdAvion.setText(aeronaveSeleccionTripulacion.getIdAvion());
					verificarTripulantes(txtIdAvion.getText());
				}
			}
		});
		//-------------------------------------------------------------------------------------------------------------||
		//----------------------------------------- Tripulación ------------------------------------------------------->>
		this.columnNombreTripulante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellidoTripulante.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		this.columnCedulaTripulante.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
		this.columnCargoTripulante.setCellValueFactory(new PropertyValueFactory<>("tipoTripulante"));
		
		tableViewTripulantes.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				tripulanteSeleccion = newSelection;
			}
		});
		//-------------------------------------------------------------------------------------------------------------||
		//----------------------------------------- Asignación de Vuelos ---------------------------------------------->>
		this.columnCedulaTripulanteAsignado.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
		this.columnCargoTipulanteAsignado.setCellValueFactory(new PropertyValueFactory<>("tipoTripulante"));
		
		tableviewAsignacionVuelos.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				tripulanteSeleccion = newSelection;			
			}
		});		
		//-------------------------------------------------------------------------------------------------------------||
		//--------------------------------------------------------------------------------------------------------------------------------------------||
		
		//----------------------------------------- Gestión Tiquetes --------------------------------------------------------------------------->>
		//----------------------------------------- Selección Viaje ------------------------------------------------------------>>
		
    	// Añadiendo Listener al value property.
        sldNumeroPersonas.valueProperty().addListener(
             new ChangeListener<Number>() {
  
            public void changed(ObservableValue <? extends Number > observable, Number oldValue, Number newValue) {
                txtLabel.setText("Número de personas: " + newValue.intValue());
            }
        });
    	
    	//Agregar datos a la lista Observable del combo box Clase
        listaCmbClase.clear();
    	listaCmbClase.add("Ejecutiva");
    	listaCmbClase.add("Económica");
    	cmbClase.setItems(listaCmbClase);

    	//Agregar datos a la lista Observable del combo box Origen
    	listaCmbOrigen.clear();
    	listaCmbOrigen.add("Ciudad de México");
    	cmbOrigen.setItems(listaCmbOrigen);
    	
    	//Agregar datos a la lista Observable del combo box Destino
    	listaCmbDestino.clear();
    	listaCmbDestino.add("Monterrey");
    	listaCmbDestino.add("Cancún");
    	listaCmbDestino.add("Buenos Aires");
    	listaCmbDestino.add("Los Ángeles");
    	listaCmbDestino.add("Bogotá");
    	listaCmbDestino.add("Panamá");
    	cmbDestino.setItems(listaCmbDestino);
    	//--------------------------------------------------------------------------------------------------------------------||
    	//----------------------------------------- Detalle del Vuelo ------------------------------------------------------------>>
		
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
				if(aeronaveSeleccion != null) {
					txtVuelo.setText(aeronaveSeleccion.getNombreAeronave() + "      Id Avión: " + aeronaveSeleccion.getIdAvion());
					txtVuelo1.setText(aeronaveSeleccion.getNombreAeronave());
				}
			}
		});
		//--------------------------------------------------------------------------------------------------------------------||
		//--------------------------------------------------------------------------------------------------------------------------------------------||
		//----------------------------------------- Gestión Equipajes --------------------------------------------------------------------------->>
		//----------------------------------------- TableViewCientes ----------------------------------------------------------->
		this.columnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellidoCliente.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		this.columnIdentificacionCliente.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
		
		//Obtener selección de la tabla
		tableViewClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				clienteSeleccion = newSelection;	
			}
		});
		//-------------------------------------------------------------------------------------------------------------------------||
		//----------------------------------------- TableViewTiquetesCliente ----------------------------------------------------------->
		this.columnIdAvionTiquete.setCellValueFactory(new PropertyValueFactory<>("idAvion"));
		this.columnDestinoTiquete.setCellValueFactory(new PropertyValueFactory<>("ciudadDestino"));
		this.columnClaseTiquete.setCellValueFactory(new PropertyValueFactory<>("ciudadOrigen"));
		this.columnDuracionViajeTiquete.setCellValueFactory(new PropertyValueFactory<>("duracionViaje"));
		
		tableViewTiquetesCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				tiqueteSeleccion = newSelection;
				if(tiqueteSeleccion != null) {
					llenarRequerimientosPesoEquipaje();
					cantTiquetes = Integer.valueOf(tiqueteSeleccion.getNombreAeronave());
					
					if(cantTiquetes == 0) btnAceptarRegistroEquipaje.setDisable(true);	
					else if(cantTiquetes > 0) btnAceptarRegistroEquipaje.setDisable(false);	
				}
			}
		});	
		//------------------------------------------------------------------------------------------------------------------------------||
		//----------------------------------------- TableViewEquipajes ----------------------------------------------------------->
		this.columnIdAvionEquipaje.setCellValueFactory(new PropertyValueFactory<>("numAvion"));
		this.columnPesoEquipaje.setCellValueFactory(new PropertyValueFactory<>("peso"));
		this.columnIdentificacionClienteEquipaje.setCellValueFactory(new PropertyValueFactory<>("identificacionCliente"));
		
		tableViewEquipajes.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				equipajeSeleccion = newSelection;		
			}
		});	
		//------------------------------------------------------------------------------------------------------------------------------||
		//--------------------------------------------------------------------------------------------------------------------------------------------||
	}

	public void setAplicacion(AplicacionAerolinea aplicacionAerolinea) {
    	this.aplicacionAerolinea = aplicacionAerolinea;
    	this.aerolinea = aplicacionAerolinea.getAerolinea();
    	
    	tableViewVuelosTripulacion.getItems().clear();
    	tableViewVuelosTripulacion.setItems(getVuelos());
    	
    	tableViewTripulantes.getItems().clear();
    	tableViewTripulantes.setItems(getTripulantes());
    	
    	tableViewClientes.getItems().clear();
    	tableViewClientes.setItems(getClientes());

//    	tableViewEquipajes.getItems().clear();
//    	tableViewEquipajes.setItems(getEquipajes());
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
	 * Obtener los vuelos de la aerolínea
	 * @return
	 */
	private ObservableList<CruceAeronavesRutas> getVuelos(String destino) {
		listadoAeronaves.clear();
		listadoAeronaves.addAll(aerolinea.datosViajes(destino));
		return listadoAeronaves;
	}

	/**
	 * Obtener los tripulantes de la aerolínea
	 * @return
	 */
	private ObservableList<Tripulante> getTripulantes() {
		listadoTripulantes.clear();
		listadoTripulantes.addAll(aerolinea.getListaTripulantes());
		return listadoTripulantes;
	}
	
	/**
	 * Obtener los clientes de la aerolínea
	 * @return
	 */
	private ObservableList<Cliente> getClientes() {
		listadoClientes.clear();
		listadoClientes.addAll(aerolinea.getListaClientes());
		return listadoClientes;
	}

	/**
	 * Obtener los tiquetes del cliente
	 * @return
	 */
	private ObservableList<CruceAeronavesRutas> getTiquetesCliente() {
			listadoTiquetesCliente.clear();
			listadoTiquetesCliente.addAll(aerolinea.datosViajesUsuario(clienteSeleccion.getIdentificacion()));			
		return listadoTiquetesCliente;
	}

	/**
	 * Obtener los equipajes del cliente
	 * @return
	 */
//	private ObservableList<CruceAeronavesRutas> getEquipajes() {
//		listadoTiquetesCliente.clear();
//		listadoTiquetesCliente.addAll(aerolinea.datosViajesUsuario(clienteSeleccion.getIdentificacion()));			
//		return listadoTiquetesCliente;
//	}
	
    @FXML
    void pasarDatosTablaAsignacionTripulantes(MouseEvent event) {
    	if(tripulanteSeleccion != null) {
			listadoTripulantesAsignados.add(tripulanteSeleccion);
			tableviewAsignacionVuelos.setItems(listadoTripulantesAsignados);
			listadoTripulantes.remove(tripulanteSeleccion);
		}
    }
    
    @FXML
    void retirarDatosTablaAsignacionTripulantes(MouseEvent event) {
    	
    	if(tripulanteSeleccion != null) {
    		listadoTripulantes.add(tripulanteSeleccion);
    		listadoTripulantesAsignados.remove(tripulanteSeleccion);
    	}
    }
    
    @FXML
    void llenarTablaTiquetesCliente(MouseEvent event) {    		
        	tableViewTiquetesCliente.getItems().clear();
        	tableViewTiquetesCliente.setItems(getTiquetesCliente());
    }
    
    /**
     * Mostrar los requerimientos de cada equipaje dependiendo del vuelo
     */
	private void llenarRequerimientosPesoEquipaje() {
		lblCantTiquetes.setText(tiqueteSeleccion.getNombreAeronave());
		
		if(tiqueteSeleccion.getCiudadDestino().equalsIgnoreCase("Monterrey") || tiqueteSeleccion.getCiudadDestino().equalsIgnoreCase("Cancún")) {
			if(tiqueteSeleccion.getCiudadOrigen().equalsIgnoreCase("Economica")) {
				lblRequerimientoEquipajeClase.setText("1 Pieza, peso máximo 24kg");
				
				//  Quitar requerimientos de la clase económica 
				cambiarEstado(false);
			} 
				
			if(tiqueteSeleccion.getCiudadOrigen().equalsIgnoreCase("Ejecutiva")) {
				lblRequerimientoEquipajeClase.setText("2 piezas con un peso máximo de 34 kilogramos cada una");
				cambiarEstado(true);
			}
		}
		if(tiqueteSeleccion.getCiudadDestino().equalsIgnoreCase("Buenos Aires") || tiqueteSeleccion.getCiudadDestino().equalsIgnoreCase("Los Ángeles") ||
		   tiqueteSeleccion.getCiudadDestino().equalsIgnoreCase("Bogotá") || tiqueteSeleccion.getCiudadDestino().equalsIgnoreCase("Panamá")) {
			if(tiqueteSeleccion.getCiudadOrigen().equalsIgnoreCase("Economica")) {
				lblRequerimientoEquipajeClase.setText("2 piezas con un peso máximo de 24 kilogramos cada una");
				cambiarEstado(true);
			} 
			
			if(tiqueteSeleccion.getCiudadOrigen().equalsIgnoreCase("Ejecutiva")) {
				lblRequerimientoEquipajeClase.setText("2 piezas con un peso máximo de 34 kilogramos cada una");
				cambiarEstado(true);
			}
		}
	}
    
    /**
     * Cambiar la visibilidad de los labels dependiendo del tipo de viaje
     * @param estado
     */
    private void cambiarEstado(boolean estado) {
    	lblAltoEquip2.setVisible(estado); lblAnchoEquip2.setVisible(estado); lblLargoEquip2.setVisible(estado);
		lblEquipaje2.setVisible(estado); txtPesoEquipaje2.setVisible(estado); iconEquip2.setVisible(estado);
		txtAltoEquipaje2.setVisible(estado); txtAnchoEquipaje2.setVisible(estado); txtLargoEquipaje2.setVisible(estado);
		lblSum1Equip2.setVisible(estado); lblSum2Equip2.setVisible(estado); lblIgualEquip2.setVisible(estado);
		txtTotalDimensionEquipaje2.setVisible(estado);
	}

	/**
     * Verificar los tripulantes que el usuario vaya seleccionando
     * @param text
     */
    private void verificarTripulantes(String idAvion) {
    	Aeronave aeronaveAsignacion = null;
    	for (Aeronave aeronave : aerolinea.getListaAeronaves()) {
			if(aeronave.getNumIdentificacionAvion().equalsIgnoreCase(idAvion))
				aeronaveAsignacion = aeronave;
		}
    	if(aeronaveAsignacion.getNombre().equalsIgnoreCase("Airbus A320")) {
    		txtTextoSeleccionNumeroTripulantes.setText("Cupo de tripulantes para este vuelo: ");
    		txtTextoSeleccionPiloto.setText("1 Piloto");
    		txtTextoSeleccionCopiloto.setText("1 Copiloto");
    		txtTextoSeleccionAuxiliaresVuelo.setText("3 Auxiliares de vuelo");
    	}
    	if(aeronaveAsignacion.getNombre().equalsIgnoreCase("Airbus A330") || aeronaveAsignacion.getNombre().equalsIgnoreCase("Boeing 787")) {
    		txtTextoSeleccionNumeroTripulantes.setText("Cupo de tripulantes para este vuelo: ");
    		txtTextoSeleccionPiloto.setText("1 Piloto");
    		txtTextoSeleccionCopiloto.setText("1 Copiloto");
    		txtTextoSeleccionAuxiliaresVuelo.setText("7 Auxiliares de vuelo");
    	}
	}
    
    @FXML
    void realizarAsignacion(ActionEvent event) { 	
    	String idVueloSeleccionado = txtIdAvion.getText();
    	realizarAsignacionVuelo(idVueloSeleccionado, listadoTripulantesAsignados);
    }
    
    /**
     * Realizar Asignación del vuelo
     * @param idVueloSeleccionado
     * @param listadoTripulantesAsignados
     */
    public void realizarAsignacionVuelo(String idVueloSeleccionado, ObservableList<Tripulante> listadoTripulantesAsignados) {
    	
    	try {
			verificarDatos(idVueloSeleccionado, listadoTripulantesAsignados);
			
			if(verificarCantidadTripulantes(idVueloSeleccionado, listadoTripulantesAsignados)) {
				
				try {
					ArrayList<Tripulante> listaTripulantesVuelos = new ArrayList<>();
					
					for (Tripulante tripulante : listadoTripulantesAsignados) {
						listaTripulantesVuelos.add(tripulante);
					}
					modelFactoryController.realizarAsignacionVuelo(idVueloSeleccionado, listaTripulantesVuelos);
					
					txtTextoConfirmacionRegistroTripulantes.setText("¡Los tripulantes han sido registrados con éxito!");
					aplicacionAerolinea.mostrarMensaje("Asignación de Vuelo", "Asignación de Vuelo", "Se realizó la asignación del vuelo con éxito", AlertType.INFORMATION);
					
					//------- Limpiar campos para una nueva asignación ------------>>
					txtIdAvion.setText("");
					initialize(location, resources);
					setAplicacion(aplicacionAerolinea);
					txtTextoSeleccionNumeroTripulantes.setText("");
					txtTextoSeleccionPiloto.setText("");
					txtTextoSeleccionCopiloto.setText("");
					txtTextoSeleccionAuxiliaresVuelo.setText("");
					//-------------------------------------------------------------||
					txtTextoConfirmacionRegistroTripulantes.setText("");
				} catch (VueloException e) {
					aplicacionAerolinea.mostrarMensaje("Asignación de Vuelo", "Asignación de Vuelo", e.getMessage(), AlertType.WARNING);
				}
	    		
			}
		} catch (DatosInvalidosException | CupoTripulanteException e) {
			aplicacionAerolinea.mostrarMensaje("Asignación de Vuelo", "Asignación de Vuelo", e.getMessage(), AlertType.WARNING);
		}
    }

    /**
     * Verificar la cantidad de tripulantes seleccionados por el usuario
     * @param idVueloSeleccionado 
     * @param listadoTripulantesAsignados2
     * @throws DatosInvalidosException 
     */
    private boolean verificarCantidadTripulantes(String idVueloSeleccionado, ObservableList<Tripulante> listadoTripulantesAsignados) throws CupoTripulanteException {
    	Aeronave aeronaveAsignacion = null;
    	
    	for (Aeronave aeronave : aerolinea.getListaAeronaves()) {
			if(aeronave.getNumIdentificacionAvion().equalsIgnoreCase(idVueloSeleccionado))
				aeronaveAsignacion = aeronave;
		}
    	    	
    	if(aeronaveAsignacion.getNombre().equalsIgnoreCase("Airbus A320")) {
    		int cantAuxiliaresVuelo = 3;
    		validarTripulantesVuelo(cantAuxiliaresVuelo);	
    	}
    	
    	if(aeronaveAsignacion.getNombre().equalsIgnoreCase("Airbus A330") || aeronaveAsignacion.getNombre().equalsIgnoreCase("Boeing 787")) {
    		int cantAuxiliaresVuelo = 7;
    		validarTripulantesVuelo(cantAuxiliaresVuelo);
    	}
		return true;
	}

    /**
     * Validar los tripulantes seleccionados
     * @throws DatosInvalidosException 
     */
	private boolean validarTripulantesVuelo(int cantAuxiliaresVuelo) throws CupoTripulanteException {
		int cantPilotos = 0, cantCopilotos = 0, cantAuxiliares = 0;
		String notificacion = "El vuelo debe contener: \n";
		
		for (Tripulante tripulante : listadoTripulantesAsignados) {
			if(tripulante.getTipoTripulante().equals(TipoTripulante.PILOTO)) cantPilotos++;
			if(tripulante.getTipoTripulante().equals(TipoTripulante.COPILOTO)) cantCopilotos++;
			if(tripulante.getTipoTripulante().equals(TipoTripulante.AUXILIAR_VUELO)) cantAuxiliares++;
		}    		
		if(cantPilotos != 1) notificacion += "1 Piloto\n";
		if(cantCopilotos != 1) notificacion += "1 Copiloto\n";
		if(cantAuxiliares != cantAuxiliaresVuelo) notificacion += cantAuxiliaresVuelo + " Auxiliares de vuelo\n";
		
		if(notificacion.equals("El vuelo debe contener: \n")) return true;	
		throw new CupoTripulanteException(notificacion); 
	}

	/**
     * Verificar que el usuario si haya seleccionado los datos
     * @param idVueloSeleccionado
     * @param listadoTripulantesAsignados2
     * @throws DatosInvalidosException 
     */
    private boolean verificarDatos(String idVueloSeleccionado, ObservableList<Tripulante> listadoTripulantesAsignados) throws DatosInvalidosException {
 
		String notificacion = "";	
		
		if(idVueloSeleccionado == null || idVueloSeleccionado.equals("")) {
			notificacion += "Seleccione el vuelo\n";
		}
		if(listadoTripulantesAsignados == null || listadoTripulantesAsignados.isEmpty()) {
			notificacion += "Seleccione los tripulantes para el vuelo\n";
		}
		if(notificacion.equals("")) {
			return true;
		}
		throw new DatosInvalidosException(notificacion); 
	}

	@FXML
    void buscarViaje(ActionEvent event) {
    	
       	String viajeSeleccionado = ""; 
    	
    	if(rbtIda.isSelected()) {
    		viajeSeleccionado = "ida";
    		rbtIda1.setSelected(true);
    	}
    	if(rbtidaVuelta.isSelected()) {
    		viajeSeleccionado = "idaYVuelta";
    		rbtidaVuelta1.setSelected(true);
    	}
    	
		try {
			verificarDatos(viajeSeleccionado, cmbClase.getValue(), cmbOrigen.getValue(), cmbDestino.getValue(), txtFechaSalida.getValue(),
					txtFechaRegreso.getValue(), sldNumeroPersonas.getValue() );
						
			//--------- Llenar campos de la tabla con datos agregados por el usuario ---------------------------->>
			cmbOrigen1.setValue(cmbOrigen.getValue());
			cmbDestino1.setValue(cmbDestino.getValue());
			txtCostoPorPersona.setText(String.valueOf(Tiquete.asignarValorTiquete(cmbDestino.getValue())));
			tableViewVuelos.getItems().clear();
	    	tableViewVuelos.setItems(getVuelos(cmbDestino.getValue()));
	    	//---------------------------------------------------------------------------------------------------||
			tabPrincipalTiquetes.getSelectionModel().select(1);
			
		} catch (DatosInvalidosException e) {
			aplicacionAerolinea.mostrarMensaje("Registro Viaje", "Registro Viaje", e.getMessage(), AlertType.WARNING);
		}
    }

	/**
	 * Verificar los datos ingresados por el usuario
	 * @param viajeSeleccionado, clase, origen, destino, fechaSalida, fechaRegreso, numeroPersonas
	 * @throws DatosInvalidosException 
	 */
	private boolean verificarDatos(String viajeSeleccionado, String clase, String origen, String destino, LocalDate fechaSalida, 
								LocalDate fechaRegreso, double numeroPersonas) throws DatosInvalidosException {

		String notificacion = "Seleccione: ";
		
		if(viajeSeleccionado == null || viajeSeleccionado.equals("")) notificacion += "Seleccione el tipo de viaje\n";
		
		if(clase == null || clase.equals("")) notificacion += "La clase\n";
		
		if(origen == null || origen.equals("")) notificacion += "El origen\n";
		
		if(destino == null || destino.equals("")) notificacion += "El destino\n";
		
		if(fechaSalida == null) notificacion += "La fecha de salida\n";
		
		if(viajeSeleccionado.equalsIgnoreCase("IdaYVuelta"))
			if(fechaRegreso == null) notificacion += "La fecha de regreso\n";
		
		if(numeroPersonas == 0) notificacion += "El número de personas\n";
		
		if(notificacion.equals("Seleccione: ")) return true;
		
		throw new DatosInvalidosException(notificacion); 
	}

    @FXML
    void realizarCompra(ActionEvent event) throws DatosInvalidosException {
    	double totalCostoPersonas;
    	double tasa;
    	
    	Ruta ruta = aerolinea.confirmarRuta(cmbDestino.getValue());
    	
    	if(aeronaveSeleccion == null)  
    		aplicacionAerolinea.mostrarMensaje("Gestión Tiquetes", "Gestión Tiquetes", "Seleccione un vuelo de la tabla", AlertType.WARNING);
    	else {
    		txtDuracionVuelo.setText(ruta.getDuracion());
    		txtHoraSalida.setText(ruta.getHoraSalida());
    		totalCostoPersonas = Double.valueOf(txtCostoPorPersona.getText()) * (int) sldNumeroPersonas.getValue();
    		
    		if(aeronaveSeleccion.getNombreAeronave().equals("Airbus A320")) {
    			tasa = totalCostoPersonas * 0.008;
    			costoTotalViaje =  totalCostoPersonas + tasa;
    		}
    		else {
    			tasa = totalCostoPersonas * 0.0097;
    			costoTotalViaje =  totalCostoPersonas + tasa;
    		}    		
    		txtPrecioTotal.setText(String.valueOf(costoTotalViaje));
    		tabPrincipalTiquetes.getSelectionModel().select(2);    		
    	}	
    }
    

    @FXML
    void cancelarCompra(ActionEvent event) {
    	tabPrincipalTiquetes.getSelectionModel().select(0);

    }

    @FXML
    void registrarNuevoViaje(ActionEvent event) {
    	
		rbtIda.setSelected(false);
		rbtidaVuelta.setSelected(false);
    	
    	cmbDestino.setValue("");
    	cmbClase.setValue("");
    	txtFechaSalida.setValue(null);;
    	txtFechaRegreso.setValue(null);
    	sldNumeroPersonas.setValue(0);
    	
    	rbtIda1.setSelected(false);
		rbtidaVuelta1.setSelected(false);
    	cmbOrigen1.setValue("");
		cmbDestino1.setValue("");
		txtCostoPorPersona.setText("");
		txtVuelo.setText("");
		
		txtVuelo1.setText("");
		txtDuracionVuelo.setText("");
		txtHoraSalida.setText("");
		txtPrecioTotal.setText("");
		
		txtIdentificacionOPasaporte.setText(""); txtNombre.setText(""); txtApellido.setText(""); txtDireccion.setText(""); txtCorreoElectronico.setText("");
		txtFechaNacimiento.setValue(null); txtDireccionResidencia.setText(""); txtTarjetaDebitoCredito.setText("");
		
    	tabPrincipalTiquetes.getSelectionModel().select(0);
    }

    @FXML
    void seleccionarPuesto(ActionEvent event) {
    	
    	if(aeronaveSeleccion.getNombreAeronave() == null){
    		aplicacionAerolinea.mostrarMensaje("Compra de Tiquetes", "Compra de Tiquetes", "Para la selección de su puesto primero elija el vuelo en el que va a viajar", AlertType.WARNING);
    	} else {
    		if(aeronaveSeleccion.getNombreAeronave().equals("Airbus A320")) 
    			cargarVista("OcupacionSillasView");
    		if(aeronaveSeleccion.getNombreAeronave().equals("Airbus A330")) 
    			cargarVista("OcupacionSillas2View");
    		if(aeronaveSeleccion.getNombreAeronave().equals("Boeing 787")) 
    			cargarVista("OcupacionSillas3View");
    	}
    }
    
    /**
     * Cargar la vista de la aeronave dependiendo de la elección del usuario
     * @param string
     */
    private void cargarVista(String nombreView) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AplicacionAerolinea.class.getResource("/co/edu/uniquindio/aerolinea/vistas/"+nombreView+".fxml"));
			AnchorPane anchorPane = (AnchorPane)loader.load();
			
			if(nombreView.equalsIgnoreCase("OcupacionSillasView")) {
				OcupacionSillasController ocupacionSillasController = loader.getController();
				ocupacionSillasController.recuperarDatos(aeronaveSeleccion.getIdAvion(), cmbClase.getValue(), (int)sldNumeroPersonas.getValue());
				ocupacionSillasController.setAplicacion(aplicacionAerolinea);
			}
			if(nombreView.equalsIgnoreCase("OcupacionSillas2View")) {
				OcupacionSillas2Controller ocupacionSillasController = loader.getController();
				ocupacionSillasController.recuperarDatos(aeronaveSeleccion.getIdAvion(), cmbClase.getValue(), (int)sldNumeroPersonas.getValue());
				ocupacionSillasController.setAplicacion(aplicacionAerolinea);
			}
			if(nombreView.equalsIgnoreCase("OcupacionSillas3View")) {
				OcupacionSillas3Controller ocupacionSillasController = loader.getController();
				ocupacionSillasController.recuperarDatos(aeronaveSeleccion.getIdAvion(), cmbClase.getValue(), (int)sldNumeroPersonas.getValue());
				ocupacionSillasController.setAplicacion(aplicacionAerolinea);
			}
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ocupación Sillas");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			
			Scene scene = new Scene(anchorPane);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();
			    				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
    void pagarTiquetes(ActionEvent event) {
    	agregarCompraTiquetes(txtIdentificacionOPasaporte.getText(), txtNombre.getText(), txtApellido.getText(), txtDireccion.getText(), txtCorreoElectronico.getText(),
    			txtFechaNacimiento.getValue(), txtDireccionResidencia.getText(), txtTarjetaDebitoCredito.getText());
    	
    }

    /**
     * Agregar el cliente que realiza la compra del o los tiquetes
     * @param identificacionOPasaporte, nombre, apellido, direccion, correoElectronico, fechaNacimiento
     * @param direccionResidencia, tarjetaDebitoCredito
     */
	private void agregarCompraTiquetes(String identificacionOPasaporte, String nombre, String apellido, String direccion, String correoElectronico, LocalDate fechaNacimiento,
			String direccionResidencia, String tarjetaDebitoCredito) {
		try {
			ArrayList<String> listaPuestosCliente = new ArrayList<>();
			listaPuestosCliente = modelFactoryController.getListaPuestosCliente();
			Cliente clienteCompra = null;
			Tiquete tiquete;
			
			String viajeSeleccionado = ""; 	    	
	    	if(rbtIda.isSelected()) viajeSeleccionado = "ida";
	    	if(rbtidaVuelta.isSelected()) viajeSeleccionado = "idaYVuelta";
			
			for (Cliente cliente : aerolinea.getListaClientes()) {
				if(identificacionOPasaporte.equalsIgnoreCase(cliente.getIdentificacion())) {
					clienteCompra = cliente;
				}
			} 

			if(clienteCompra == null) {
				verificarDatos(identificacionOPasaporte,nombre, apellido, direccion, correoElectronico, fechaNacimiento, direccionResidencia, tarjetaDebitoCredito, listaPuestosCliente);
				clienteCompra = modelFactoryController.agregarCliente(identificacionOPasaporte, nombre, apellido, direccion, correoElectronico, fechaNacimiento, direccionResidencia, tarjetaDebitoCredito);
			}
			
			tiquete = modelFactoryController.agregarCompraTiquete(aeronaveSeleccion.getIdAvion(), viajeSeleccionado, cmbClase.getValue(), cmbOrigen.getValue(), cmbDestino.getValue(), txtFechaSalida.getValue(),
					txtFechaRegreso.getValue(), (int)sldNumeroPersonas.getValue(), costoTotalViaje, clienteCompra, listaPuestosCliente);
			
			if(clienteCompra != null) listadoClientes.add(0, clienteCompra);
			
			// Añadir el cliente al filtro al momento de agregarlo al tableview
			if(clienteCompra.toString().toLowerCase().contains(txtFiltrarCliente.getText().toLowerCase())) {
				filtroListadoClientes.add(clienteCompra);
			}
			tableViewClientes.refresh();
			
			aplicacionAerolinea.mostrarMensaje("Compra de Tiquetes", "Compra de Tiquetes", "La compra de su tiquete con destino a " + tiquete.getRutaViaje().getCiudadDestino() + " se ha realizado con éxito", AlertType.INFORMATION);
		} catch (DatosInvalidosException e) {
			aplicacionAerolinea.mostrarMensaje("Compra de Tiquetes", "Compra de Tiquetes", e.getMessage(), AlertType.WARNING);
		}
	}
	
	/**
	 * Datos de la ocupación de sillas del usuario
	 * @param listaBotonesSeleccionados
	 * @return
	 */
	public void obtenerDatos(ArrayList<Button> listaBotonesSeleccionados) {
		listaPuestosUsuario.addAll(listaBotonesSeleccionados);		
	}

	
	private boolean verificarDatos(String identificacionOPasaporte, String nombre, String apellido, String direccion, String correoElectronico, LocalDate fechaNacimiento, String direccionResidencia,
			String tarjetaDebitoCredito, ArrayList<String> listaPuestosCliente) throws DatosInvalidosException {
			
		String notificacion = "";	
		
		if(identificacionOPasaporte == null || identificacionOPasaporte.equals("")) notificacion += "Ingrese la identificación o pasaporte\n";
		
		if(nombre == null || nombre.equals("")) notificacion += "Ingrese el nombre\n";
		
		if(apellido == null || apellido.equals("")) notificacion += "Ingrese el apellido\n";
		
		if(direccion == null || direccion.equals("")) notificacion += "Ingrese la dirección\n";
		
		if(correoElectronico == null || correoElectronico.equals("")) notificacion += "Seleccione el correo electrónico\n";
		
		if(fechaNacimiento == null) notificacion += "Seleccione la fecha de nacimiento\n";
		
		if(direccionResidencia == null || direccionResidencia.equals("")) notificacion += "Ingrese la dirección de residencia\n";
		
		if(tarjetaDebitoCredito == null || tarjetaDebitoCredito.equals("")) notificacion += "Ingrese el número de la tarjeta débito o crédito\n";
		
		if(listaPuestosCliente.isEmpty()) notificacion += "Seleccione los puestos que desea ocupar\n";
		
		if(notificacion.equals("")) 
			return true;
		
		throw new DatosInvalidosException(notificacion); 
	}
	
    @FXML
    void sumaDimensionesEquipaje(KeyEvent event) {
    	String equip1 = "Equipaje1", equip2 = "Equipaje2", equipMano = "EquipajeMano";
    	
    	// Equipaje 1
    	calcularDimension(txtAltoEquipaje1.getText(), txtAnchoEquipaje1.getText(), txtLargoEquipaje1.getText(), equip1, txtTotalDimensionEquipaje1);    		
    	
    	// Equipaje 2
    	calcularDimension(txtAltoEquipaje2.getText(), txtAnchoEquipaje2.getText(), txtLargoEquipaje2.getText(), equip2, txtTotalDimensionEquipaje2);

    	// Equipaje de mano
		calcularDimension(txtAltoEquipajeMano.getText(), txtAnchoEquipajeMano.getText(), txtLargoEquipajeMano.getText(), equipMano, txtTotalDimensionEquipajeMano);
    }
	
	/**
	 * Calcular las dimensiones del equipaje
	 * @param nombreEquipaje 
	 * @param txtTotalDimensionEquipaje 
	 * @param altoEquipaje, anchoEquipaje, largoEquipaje
	 * @return 
	 */
    private void calcularDimension(String altoEquipaje, String anchoEquipaje, String largoEquipaje, String nombreEquipaje, TextField txtTotalDimensionEquipaje) {
    	int alto = 0, largo = 0, ancho = 0, dimension = 0;
    	
    	try {
			validarNumero(altoEquipaje, largoEquipaje, anchoEquipaje);
			if(!(altoEquipaje.equals(""))) alto =  Integer.valueOf(altoEquipaje);
			if(!(anchoEquipaje.equals(""))) ancho =  Integer.valueOf(anchoEquipaje);
			if(!(largoEquipaje.equals(""))) largo =  Integer.valueOf(largoEquipaje);
			
			if(alto > 0 && largo > 0 && ancho > 0) {
				dimension = alto + largo + ancho;
			}
			if(nombreEquipaje.equals("Equipaje1") || nombreEquipaje.equals("Equipaje2")) {
				if(dimension > 170) {
					txtTotalDimensionEquipaje.setStyle("-fx-text-fill: red; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width:  0px 0px 0px 0px;");    		
				} else 
					txtTotalDimensionEquipaje.setStyle("-fx-text-fill: black; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width:  0px 0px 0px 0px;");    		
			} else {
				
				if(dimension > 110) {
					txtTotalDimensionEquipaje.setStyle("-fx-text-fill: red; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width:  0px 0px 0px 0px;");    		
				} else 
					txtTotalDimensionEquipaje.setStyle("-fx-text-fill: black; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width:  0px 0px 0px 0px;");	
			}
			if(dimension > 0) txtTotalDimensionEquipaje.setText(String.valueOf(dimension));
			else txtTotalDimensionEquipaje.setText("");
			
		} catch (DatosInvalidosException e) {
			aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", e.getMessage(), AlertType.WARNING);
		}
	}
    
    /**
	 * validar que el usuario ingrese valores numéricos
	 * @param peso, estatura, valorMensualidad, imc, porcentajeGrasa
	 * @return
	 * @throws DatosInvalidosException 
	 */
	private boolean validarNumero(String alto, String largo, String ancho) throws DatosInvalidosException {	
		String notificacionNumero = "";
				
		if(!(alto.matches("[0-9.]*"))) {
			notificacionNumero += "El alto debe ser un valor numérico\n";
		}
		if(!(largo.matches("[0-9.]*"))) {
			notificacionNumero += "El largo debe ser un valor numérico\n";
		}
		if(!(ancho.matches("[0-9.]*"))) {
			notificacionNumero += "El ancho debe ser un valor numérico\n";
		}
		
		if(notificacionNumero.equals("")) {
			return true;
		}
		throw new DatosInvalidosException(notificacionNumero);
	}
	
	@FXML
    void aceptarRegistroEquipaje(ActionEvent event) {
				
		if(clienteSeleccion == null) aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", "Seleccione un cliente", AlertType.WARNING);
		if(tiqueteSeleccion == null) aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", "Seleccione uno de los registros de tiquete(s) del cliente", AlertType.WARNING);
				
		else {
			try {
				if(tiqueteSeleccion.getCiudadOrigen().equalsIgnoreCase("Economica")) {
					
					verificarInformacionIngresada(txtPesoEquipaje1.getText(), txtTotalDimensionEquipaje1.getText(), txtPesoEquipaje2.getText(), txtTotalDimensionEquipaje2.getText(),
							txtTotalDimensionEquipajeMano.getText(), txtPesoAdicional.getText(), 24);
					
				} else if(tiqueteSeleccion.getCiudadOrigen().equalsIgnoreCase("Ejecutiva")) {
										
					verificarInformacionIngresada(txtPesoEquipaje1.getText(), txtTotalDimensionEquipaje1.getText(), txtPesoEquipaje2.getText(), txtTotalDimensionEquipaje2.getText(),
							txtTotalDimensionEquipajeMano.getText(), txtPesoAdicional.getText(), 34);
				}
				cantTiquetes--;
				if(cantTiquetes == 0) {
					aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", "Se ha añadido su último equipaje al registro con éxito", AlertType.INFORMATION);				
					btnAceptarRegistroEquipaje.setDisable(true);	
				} else if(cantTiquetes > 0) {
					aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", "Se ha añadido su equipaje al registro con éxito", AlertType.INFORMATION);				
				}
				
				// Dejar en blanco los campos para un nuevo registro
				txtPesoEquipaje1.setText(""); txtTotalDimensionEquipaje1.setText(""); txtPesoEquipaje2.setText(""); txtTotalDimensionEquipaje2.setText("");
				txtTotalDimensionEquipajeMano.setText(""); txtPesoAdicional.setText(""); txtAltoEquipaje1.setText(""); txtAnchoEquipaje1.setText(""); txtLargoEquipaje1.setText("");
				txtAltoEquipaje2.setText(""); txtAnchoEquipaje2.setText(""); txtLargoEquipaje2.setText(""); txtAltoEquipajeMano.setText(""); txtAnchoEquipajeMano.setText(""); txtLargoEquipajeMano.setText("");
				
			} catch (DatosInvalidosException | EquipajeException e) {
				aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", e.getMessage(), AlertType.WARNING);				
			}
		}
	}
			
	/**
	 * Verificar la información ingresada por el usuario
	 * @param pesoEquipaje1, totalDimensionEquipaje1, pesoEquipaje2, totalDimensionEquipaje2
	 * @param totalDimensionEquipajeMano, pesoAdicional, pesoEquipaje
	 * @return
	 * @throws DatosInvalidosException 
	 * @throws EquipajeException 
	 */
    private void verificarInformacionIngresada(String pesoEquipaje1, String totalDimensionEquipaje1, String pesoEquipaje2, String totalDimensionEquipaje2, String totalDimensionEquipajeMano,
			 String pesoAdicional, int pesoEquipaje) throws DatosInvalidosException, EquipajeException {
    	
    	double pesoTotalEquipaje = 0, equipaje1, equipaje2 = 0, equipajeAdicional = 0, dimensionEquipaje, dimensionEquipaje2, dimensionEquipajeMano; 	
    	
    	
		verificarDatos(pesoEquipaje1, totalDimensionEquipaje1);
		validarNumero(pesoEquipaje1);
		equipaje1 = Double.valueOf(pesoEquipaje1);
		dimensionEquipaje = Double.valueOf(totalDimensionEquipaje1);
		
		if(validarEquipaje(equipaje1, dimensionEquipaje, pesoEquipaje));
		
		if(!(pesoEquipaje2.equals(""))) {
			verificarDatos(pesoEquipaje2, totalDimensionEquipaje2);
			validarNumero(pesoEquipaje2);
			equipaje2 = Double.valueOf(pesoEquipaje2);
			dimensionEquipaje2 = Double.valueOf(totalDimensionEquipaje2);
			
			if(validarEquipaje(equipaje2, dimensionEquipaje2, pesoEquipaje));
		}							
		if(!(totalDimensionEquipajeMano.equals(""))) {
			validarNumero(totalDimensionEquipajeMano);
			dimensionEquipajeMano = Double.valueOf(totalDimensionEquipajeMano);
			if(dimensionEquipajeMano > 110) aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", "La suma de las dimensiones de su equipaje no puede ser mayor a 110 centímetros", AlertType.WARNING);
		}
		if(!(pesoAdicional.equals(""))) {
			validarNumero(pesoAdicional);
			equipajeAdicional = Double.valueOf(pesoAdicional);
		}
		pesoTotalEquipaje = equipaje1 + equipaje2 + equipajeAdicional;
		
		Equipaje equipaje = new Equipaje(clienteSeleccion.getIdentificacion(), pesoTotalEquipaje, tiqueteSeleccion.getIdAvion());
		if(equipaje != null) listadoEquipajes.add(0, equipaje);
		tableViewEquipajes.setItems(listadoEquipajes);
		tableViewEquipajes.refresh();
	}

	/**
	 * Validar peso y dimensión del equipaje
	 * @param equipaje1, dimensionEquipaje, tamaño 
	 * @return
	 * @throws EquipajeException 
	 */
    private boolean validarEquipaje(double equipaje1, double dimensionEquipaje, int tamaño) throws EquipajeException {
    	String notificacionNumero = "";
    	
    	if(equipaje1 > tamaño) 
    		notificacionNumero += "El peso de su equipaje debe ser de máximo " + tamaño + " kilogramos\n";
		
    	if(dimensionEquipaje > 170) 
			notificacionNumero += "La suma de las dimensiones de su equipaje no puede ser mayor a 170 centímetros \n";
		
		if(notificacionNumero.equals("")) 
			return true;
		
		throw new EquipajeException(notificacionNumero);
	}

	private boolean validarNumero(String peso) throws DatosInvalidosException {
    	String notificacionNumero = "";
		
		if(!(peso.matches("[0-9.]*"))) {
			notificacionNumero += "Debe ingresar un valor numérico\n";
		}
		if(notificacionNumero.equals("")) {
			return true;
		}
		throw new DatosInvalidosException(notificacionNumero);
	}
    
    private boolean verificarDatos(String pesoEquipaje, String dimensionEquipaje) throws DatosInvalidosException {
			
		String notificacion = "";	
		
		if(pesoEquipaje == null || pesoEquipaje.equals("")) notificacion += "Ingrese el peso del equipaje\n";
		
		if(dimensionEquipaje == null || dimensionEquipaje.equals("")) notificacion += "Ingrese las dimensiones del equipaje\n";
		
		if(notificacion.equals("")) 
			return true;
		
		throw new DatosInvalidosException(notificacion); 
	}

	@FXML
    void registrarEquipajes(ActionEvent event) {
		try {
			boolean confirmacion = aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", "¿Desea registrar estos equipajes en el vuelo?");		
			
			if(confirmacion == true) {
				modelFactoryController.registrarEquipajesAerolinea(listadoEquipajes);
				aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", "Los equipajes han sido registrados con éxito", AlertType.WARNING);	
				
				listadoEquipajes.clear();
				tableViewEquipajes.setItems(listadoEquipajes);
				tableViewEquipajes.refresh();
			}	
		} catch (EquipajeException e) {
			aplicacionAerolinea.mostrarMensaje("Registro de Equipaje", "Registro de Equipaje", e.getMessage(), AlertType.WARNING);							
		}
    }
    
    @FXML
    void filtrarCliente(KeyEvent event) {
    	String filtroCliente = txtFiltrarCliente.getText();
    	
    	if(filtroCliente.isEmpty()) {
    		tableViewClientes.setItems(listadoClientes);
    	} else {
    		filtroListadoClientes.clear();
    		
    		for (Cliente cliente: listadoClientes) {
				if(cliente.toString().toLowerCase().contains(filtroCliente.toLowerCase())) {
					filtroListadoClientes.add(cliente);
				}
			}
    		tableViewClientes.setItems(filtroListadoClientes);
    	}
    }


		
	




   

}

package co.edu.uniquindio.aerolinea.controladores;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.excepciones.CupoTripulanteException;
import co.edu.uniquindio.aerolinea.excepciones.DatosInvalidosException;
import co.edu.uniquindio.aerolinea.excepciones.VueloException;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aeronave;
import co.edu.uniquindio.aerolinea.modelo.Cliente;
import co.edu.uniquindio.aerolinea.modelo.CruceAeronavesRutas;
import co.edu.uniquindio.aerolinea.modelo.Ruta;
import co.edu.uniquindio.aerolinea.modelo.TipoTripulante;
import co.edu.uniquindio.aerolinea.modelo.Tiquete;
import co.edu.uniquindio.aerolinea.modelo.Tripulante;
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
    
    private CruceAeronavesRutas aeronaveSeleccion;
    private CruceAeronavesRutas aeronaveSeleccionTripulacion;
    private Tripulante tripulanteSeleccion;
    double costoTotalViaje;
    
    ArrayList<Button> listaPuestosUsuario = new ArrayList<>();
    
	// Listado de Aeronaves que se muestran en la interfaz 
    private ObservableList<CruceAeronavesRutas> listadoAeronaves = FXCollections.observableArrayList();
    // Listado de Tripulantes que se muestran en la interfaz 
    private ObservableList<Tripulante> listadoTripulantes = FXCollections.observableArrayList();
    private ObservableList<Tripulante> listadoTripulantesAsignados = FXCollections.observableArrayList();
    
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
		
	}
	
	public void setAplicacion(AplicacionAerolinea aplicacionAerolinea) {
    	this.aplicacionAerolinea = aplicacionAerolinea;
    	this.aerolinea = aplicacionAerolinea.getAerolinea();
    	
    	tableViewVuelosTripulacion.getItems().clear();
    	tableViewVuelosTripulacion.setItems(getVuelos());
    	
    	tableViewTripulantes.getItems().clear();
    	tableViewTripulantes.setItems(getTripulantes());
    	
    	tableviewAsignacionVuelos.getItems().clear();
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


		
	




   

}

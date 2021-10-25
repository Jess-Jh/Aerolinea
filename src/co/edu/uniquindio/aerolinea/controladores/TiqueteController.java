package co.edu.uniquindio.aerolinea.controladores;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.excepciones.DatosInvalidosException;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;

/**
 * Controlador de la vista TiqueteView
 * @author Jessica Ospina
 */
public class TiqueteController implements Initializable {
	
	//----------SINGLETON----------------------------------------------------->>
	ModelFactoryController modelFactoryController;
	Aerolinea aerolinea;
	
	public TiqueteController() {
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
    private ComboBox<String> cmbClase;
    ObservableList<String> listaCmbClase = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> cmbDestino;
    ObservableList<String> listaCmbDestino = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> cmbOrigen;
    ObservableList<String> listaCmbOrigen = FXCollections.observableArrayList();

    @FXML
    private ToggleGroup grupoVuelo;

    @FXML
    private RadioButton rbtIda;

    @FXML
    private RadioButton rbtidaVuelta;

	@FXML
    private Slider sldNumeroPersonas;

    @FXML
    private DatePicker txtFechaRegreso;

    @FXML
    private DatePicker txtFechaSalida;
    
    @FXML
    private Label txtLabel;
    
    private AplicacionAerolinea aplicacionAerolinea;
    
    // --------------------------- Métodos Getters and Setters --------------------------------------->>
    public ComboBox<String> getCmbDestino() {
		return cmbDestino;
	}
	public void setCmbDestino(ComboBox<String> cmbDestino) {
		this.cmbDestino = cmbDestino;
	}
	public ComboBox<String> getCmbOrigen() {
		return cmbOrigen;
	}
	public void setCmbOrigen(ComboBox<String> cmbOrigen) {
		this.cmbOrigen = cmbOrigen;
	}
	public RadioButton getRbtIda() {
		return rbtIda;
	}
	public void setRbtIda(RadioButton rbtIda) {
		this.rbtIda = rbtIda;
	}
	public RadioButton getRbtidaVuelta() {
		return rbtidaVuelta;
	}
	public void setRbtidaVuelta(RadioButton rbtidaVuelta) {
		this.rbtidaVuelta = rbtidaVuelta;
	}
	// ----------------------------------------------------------------------------------------------||
	
    @Override
    public void initialize(URL location, ResourceBundle resource) {
    	
    	// Añadiendo Listener al value property.
        sldNumeroPersonas.valueProperty().addListener(
             new ChangeListener<Number>() {
  
            public void changed(ObservableValue <? extends Number > observable, Number oldValue, Number newValue) {
                txtLabel.setText("Número de personas: " + newValue.intValue());
            }
        });
    	
    	//Agregar datos a la lista Observable del combo box Clase
    	listaCmbClase.add("Ejecutiva");
    	listaCmbClase.add("Económica");
    	cmbClase.setItems(listaCmbClase);

    	//Agregar datos a la lista Observable del combo box Origen
    	listaCmbOrigen.add("Ciudad de México");
    	cmbOrigen.setItems(listaCmbOrigen);
    	
    	//Agregar datos a la lista Observable del combo box Destino
    	listaCmbDestino.add("Monterrey");
    	listaCmbDestino.add("Cancún");
    	listaCmbDestino.add("Buenos Aires");
    	listaCmbDestino.add("Los Ángeles");
    	listaCmbDestino.add("Bogotá");
    	listaCmbDestino.add("Panamá");
    	cmbDestino.setItems(listaCmbDestino);
    }
    
    public void setAplicacion(AplicacionAerolinea aplicacionAerolinea) {
    	this.aplicacionAerolinea = aplicacionAerolinea;
    	this.aerolinea = aplicacionAerolinea.getAerolinea();
    }

    @FXML
    void buscarViaje(ActionEvent event) {
    	String viajeSeleccionado = "";
    	
    	if(rbtIda.isSelected()) viajeSeleccionado = "ida";
    	if(rbtidaVuelta.isSelected()) viajeSeleccionado = "idaYVuelta";
    	
    	buscarViaje(viajeSeleccionado, cmbClase.getValue(), cmbOrigen.getValue(), cmbDestino.getValue(), txtFechaSalida.getValue(),
    			    txtFechaRegreso.getValue(), sldNumeroPersonas.getValue() );
    }

	private void buscarViaje(String viajeSeleccionado, String clase, String origen, String destino, LocalDate fechaSalida,
			LocalDate fechaRegreso, double numeroPersonas) {
		
		try {
			verificarDatos(viajeSeleccionado, clase, origen, destino, fechaSalida, fechaRegreso, numeroPersonas);
			
			modelFactoryController.buscarViaje(viajeSeleccionado, clase, origen, destino, fechaSalida, fechaRegreso, numeroPersonas);
			
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

		String notificacion = "";
		
		if(viajeSeleccionado == null || viajeSeleccionado.equals("")) notificacion += "Seleccione el tipo de viaje\n";
		
		if(clase == null || clase.equals("")) notificacion += "Seleccione la clase\n";
		
		if(origen == null || origen.equals("")) notificacion += "Seleccione el origen\n";
		
		if(destino == null || destino.equals("")) notificacion += "Seleccione el destino\n";
		
		if(fechaSalida == null) notificacion += "Seleccione la fecha de salida\n";
		
		if(viajeSeleccionado.equalsIgnoreCase("IdaYVuelta"))
			if(fechaRegreso == null) notificacion += "Seleccione la fecha de regreso\n";
		
		if(numeroPersonas == 0) notificacion += "Ingrese el número de personas\n";
		
		if(notificacion.equals("")) return true;
		
		throw new DatosInvalidosException(notificacion); 
	}


}

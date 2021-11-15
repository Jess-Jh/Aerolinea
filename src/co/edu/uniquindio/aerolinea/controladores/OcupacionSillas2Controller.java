package co.edu.uniquindio.aerolinea.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aeronave;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

/**
 * Clase Singleton
 * @author Jessica Johana Ospina Patiño
 */
public class OcupacionSillas2Controller {
	
	//----------SINGLETON----------------------------------------------------->
	ModelFactoryController modelFactoryController;
	Aerolinea aerolinea;
	
	public OcupacionSillas2Controller() {
		modelFactoryController = ModelFactoryController.getInstance();
		aerolinea = modelFactoryController.getAerolinea();
	}
	
    public Aerolinea getGimnasio() {
		return aerolinea;
	}
	public void setGimnasio(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	//-----------------------------------------------------------------------||

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button A1E, A2E, A3E, A4E, A5E, C1E, C2E, C3E, C4E, C5E, D1E, D2E, D3E, D4E, D5E, F1E, F2E, F3E, F4E, F5E, H1E, H2E, H3E, H4E, H5E, 
	 K1E, K2E, K3E, K4E, K5E, A1C, A2C, A3C, A4C, A5C, A6C, A7C, A8C, A9C, A10C, A11C, A12C, A13C, A14C, A15C, A16C, A17C, A18C, A19C,
	 A20C, A21C, A22C, A23C, A24C, A25C, A26C, A27C, A28C, C1C, C2C, C3C, C4C, C5C, C6C, C7C, C8C, C9C, C10C, C11C, C12C, C13C, C14C, 
	 C15C, C16C, C17C, C18C, C19C, C20C, C21C, C22C, C23C, C24C, C25C, C26C, C27C, C28C, D1C, D2C, D3C, D4C, D5C, D6C, D7C, D8C, D9C, 
	 D10C, D11C, D12C, D13C, D14C, D15C, D16C, D17C, D18C, D19C, D20C, D21C, D22C, D23C, D24C, D25C, D26C, D27C, E1C, E2C, E3C, E4C, E5C,
	 E6C, E7C, E8C, E9C, E10C, E11C, E12C, E13C, E14C, E15C, E16C, E17C, E18C, E19C, E20C, E21C, E22C, E23C, E24C, E25C, E26C, E27C, E28C, 
	 F1C, F2C, F3C, F4C, F5C, F6C, F7C, F8C, F9C, F10C, F11C, F12C, F13C, F14C, F15C, F16C, F17C, F18C, F19C, F20C, F21C, F22C, F23C, F24C,
	 F25C, F26C, F27C, F28C, G1C, G2C, G3C, G4C, G5C, G6C, G7C, G8C, G9C, G10C, G11C, G12C, G13C, G14C, G15C, G16C, G17C, G18C, G19C, G20C,
	 G21C, G22C, G23C, G24C, G25C, G26C, G27C, H1C, H2C, H3C, H4C, H5C, H6C, H7C, H8C, H9C, H10C, H11C, H12C, H13C, H14C, H15C, H16C, H17C, 
	 H18C, H19C, H20C, H21C, H22C, H23C, H24C, H25C, H26C, H27C, H28C, K1C, K2C, K3C, K4C, K5C, K6C, K7C, K8C, K9C, K10C, K11C, K12C, K13C, 
	 K14C, K15C, K16C, K17C, K18C, K19C, K20C, K21C, K22C, K23C, K24C, K25C, K26C, K27C, K28C;

//    @FXML
//    private Button A12C;
//
//    @FXML
//    private Button A13C;
//
//    @FXML
//    private Button A14C;
//
//    @FXML
//    private Button A15C;
//
//    @FXML
//    private Button A16C;
//
//    @FXML
//    private Button A17C;
//
//    @FXML
//    private Button A18C;
//
//    @FXML
//    private Button A19C;
//
//    @FXML
//    private Button A1C;
//
//    @FXML
//    private Button A1E;
//
//    @FXML
//    private Button A20C;
//
//    @FXML
//    private Button A21C;
//
//    @FXML
//    private Button A22C;
//
//    @FXML
//    private Button A23C;
//
//    @FXML
//    private Button A24C;
//
//    @FXML
//    private Button A25C;
//
//    @FXML
//    private Button A26C;
//
//    @FXML
//    private Button A27C;
//
//    @FXML
//    private Button A28C;
//
//    @FXML
//    private Button A2C;
//
//    @FXML
//    private Button A2E;
//
//    @FXML
//    private Button A3C;
//
//    @FXML
//    private Button A3E;
//
//    @FXML
//    private Button A4C;
//
//    @FXML
//    private Button A4E;
//
//    @FXML
//    private Button A5C;
//
//    @FXML
//    private Button A5E;
//
//    @FXML
//    private Button A6C;
//
//    @FXML
//    private Button A7C;
//
//    @FXML
//    private Button A8C;
//
//    @FXML
//    private Button A9C;
//
//    @FXML
//    private Button C10C;
//
//    @FXML
//    private Button C11C;
//
//    @FXML
//    private Button C12C;
//
//    @FXML
//    private Button C13C;
//
//    @FXML
//    private Button C14C;
//
//    @FXML
//    private Button C15C;
//
//    @FXML
//    private Button C16C;
//
//    @FXML
//    private Button C17C;
//
//    @FXML
//    private Button C18C;
//
//    @FXML
//    private Button C19C;
//
//    @FXML
//    private Button C1C;
//
//    @FXML
//    private Button C1E;
//
//    @FXML
//    private Button C20C;
//
//    @FXML
//    private Button C21C;
//
//    @FXML
//    private Button C22C;
//
//    @FXML
//    private Button C23C;
//
//    @FXML
//    private Button C24C;
//
//    @FXML
//    private Button C25C;
//
//    @FXML
//    private Button C26C;
//
//    @FXML
//    private Button C27C;
//
//    @FXML
//    private Button C28C;
//
//    @FXML
//    private Button C2C;
//
//    @FXML
//    private Button C2E;
//
//    @FXML
//    private Button C3C;
//
//    @FXML
//    private Button C3E;
//
//    @FXML
//    private Button C4C;
//
//    @FXML
//    private Button C4E;
//
//    @FXML
//    private Button C5C;
//
//    @FXML
//    private Button C5E;
//
//    @FXML
//    private Button C6C;
//
//    @FXML
//    private Button C7C;
//
//    @FXML
//    private Button C8C;
//
//    @FXML
//    private Button C9C;
//
//    @FXML
//    private Button D10C;
//
//    @FXML
//    private Button D11C;
//
//    @FXML
//    private Button D12C;
//
//    @FXML
//    private Button D13C;
//
//    @FXML
//    private Button D14C;
//
//    @FXML
//    private Button D15C;
//
//    @FXML
//    private Button D16C;
//
//    @FXML
//    private Button D17C;
//
//    @FXML
//    private Button D18C;
//
//    @FXML
//    private Button D19C;
//
//    @FXML
//    private Button D1C;
//
//    @FXML
//    private Button D1E;
//
//    @FXML
//    private Button D20C;
//
//    @FXML
//    private Button D21C;
//
//    @FXML
//    private Button D22C;
//
//    @FXML
//    private Button D23C;
//
//    @FXML
//    private Button D24C;
//
//    @FXML
//    private Button D25C;
//
//    @FXML
//    private Button D26C;
//
//    @FXML
//    private Button D27C;
//
//    @FXML
//    private Button D2C;
//
//    @FXML
//    private Button D2E;
//
//    @FXML
//    private Button D3C;
//
//    @FXML
//    private Button D3E;
//
//    @FXML
//    private Button D4C;
//
//    @FXML
//    private Button D4E;
//
//    @FXML
//    private Button D5C;
//
//    @FXML
//    private Button D5E;
//
//    @FXML
//    private Button D6C;
//
//    @FXML
//    private Button D7C;
//
//    @FXML
//    private Button D8C;
//
//    @FXML
//    private Button D9C;
//
//    @FXML
//    private Button E10C;
//
//    @FXML
//    private Button E11C;
//
//    @FXML
//    private Button E12C;
//
//    @FXML
//    private Button E13C;
//
//    @FXML
//    private Button E14C;
//
//    @FXML
//    private Button E15C;
//
//    @FXML
//    private Button E16C;
//
//    @FXML
//    private Button E17C;
//
//    @FXML
//    private Button E18C;
//
//    @FXML
//    private Button E19C;
//
//    @FXML
//    private Button E1C;
//
//    @FXML
//    private Button E20C;
//
//    @FXML
//    private Button E21C;
//
//    @FXML
//    private Button E22C;
//
//    @FXML
//    private Button E23C;
//
//    @FXML
//    private Button E24C;
//
//    @FXML
//    private Button E25C;
//
//    @FXML
//    private Button E26C;
//
//    @FXML
//    private Button E27C;
//
//    @FXML
//    private Button E28C;
//
//    @FXML
//    private Button E2C;
//
//    @FXML
//    private Button E3C;
//
//    @FXML
//    private Button E4C;
//
//    @FXML
//    private Button E5C;
//
//    @FXML
//    private Button E6C;
//
//    @FXML
//    private Button E7C;
//
//    @FXML
//    private Button E8C;
//
//    @FXML
//    private Button E9C;
//
//    @FXML
//    private Button F10C;
//
//    @FXML
//    private Button F11C;
//
//    @FXML
//    private Button F12C;
//
//    @FXML
//    private Button F13C;
//
//    @FXML
//    private Button F14C;
//
//    @FXML
//    private Button F15C;
//
//    @FXML
//    private Button F16C;
//
//    @FXML
//    private Button F17C;
//
//    @FXML
//    private Button F18C;
//
//    @FXML
//    private Button F19C;
//
//    @FXML
//    private Button F1C;
//
//    @FXML
//    private Button F1E;
//
//    @FXML
//    private Button F20C;
//
//    @FXML
//    private Button F21C;
//
//    @FXML
//    private Button F22C;
//
//    @FXML
//    private Button F23C;
//
//    @FXML
//    private Button F24C;
//
//    @FXML
//    private Button F25C;
//
//    @FXML
//    private Button F26C;
//
//    @FXML
//    private Button F27C;
//
//    @FXML
//    private Button F28C;
//
//    @FXML
//    private Button F2C;
//
//    @FXML
//    private Button F2E;
//
//    @FXML
//    private Button F3C;
//
//    @FXML
//    private Button F3E;
//
//    @FXML
//    private Button F4C;
//
//    @FXML
//    private Button F4E;
//
//    @FXML
//    private Button F5C;
//
//    @FXML
//    private Button F5E;
//
//    @FXML
//    private Button F6C;
//
//    @FXML
//    private Button F7C;
//
//    @FXML
//    private Button F8C;
//
//    @FXML
//    private Button F9C;
//
//    @FXML
//    private Button G10C;
//
//    @FXML
//    private Button G11C;
//
//    @FXML
//    private Button G12C;
//
//    @FXML
//    private Button G13C;
//
//    @FXML
//    private Button G14C;
//
//    @FXML
//    private Button G15C;
//
//    @FXML
//    private Button G16C;
//
//    @FXML
//    private Button G17C;
//
//    @FXML
//    private Button G18C;
//
//    @FXML
//    private Button G19C;
//
//    @FXML
//    private Button G1C;
//
//    @FXML
//    private Button G20C;
//
//    @FXML
//    private Button G21C;
//
//    @FXML
//    private Button G22C;
//
//    @FXML
//    private Button G23C;
//
//    @FXML
//    private Button G24C;
//
//    @FXML
//    private Button G25C;
//
//    @FXML
//    private Button G26C;
//
//    @FXML
//    private Button G27C;
//
//    @FXML
//    private Button G2C;
//
//    @FXML
//    private Button G3C;
//
//    @FXML
//    private Button G4C;
//
//    @FXML
//    private Button G5C;
//
//    @FXML
//    private Button G6C;
//
//    @FXML
//    private Button G7C;
//
//    @FXML
//    private Button G8C;
//
//    @FXML
//    private Button G9C;
//
//    @FXML
//    private Button H10C;
//
//    @FXML
//    private Button H11C;
//
//    @FXML
//    private Button H12C;
//
//    @FXML
//    private Button H13C;
//
//    @FXML
//    private Button H14C;
//
//    @FXML
//    private Button H15C;
//
//    @FXML
//    private Button H16C;
//
//    @FXML
//    private Button H17C;
//
//    @FXML
//    private Button H18C;
//
//    @FXML
//    private Button H19C;
//
//    @FXML
//    private Button H1C;
//
//    @FXML
//    private Button H1E;
//
//    @FXML
//    private Button H20C;
//
//    @FXML
//    private Button H21C;
//
//    @FXML
//    private Button H22C;
//
//    @FXML
//    private Button H23C;
//
//    @FXML
//    private Button H24C;
//
//    @FXML
//    private Button H25C;
//
//    @FXML
//    private Button H26C;
//
//    @FXML
//    private Button H27C;
//
//    @FXML
//    private Button H28C;
//
//    @FXML
//    private Button H2C;
//
//    @FXML
//    private Button H2E;
//
//    @FXML
//    private Button H3C;
//
//    @FXML
//    private Button H3E;
//
//    @FXML
//    private Button H4C;
//
//    @FXML
//    private Button H4E;
//
//    @FXML
//    private Button H5C;
//
//    @FXML
//    private Button H5E;
//
//    @FXML
//    private Button H6C;
//
//    @FXML
//    private Button H7C;
//
//    @FXML
//    private Button H8C;
//
//    @FXML
//    private Button H9C;
//
//    @FXML
//    private Button K10C;
//
//    @FXML
//    private Button K11C;
//
//    @FXML
//    private Button K12C;
//
//    @FXML
//    private Button K13C;
//
//    @FXML
//    private Button K14C;
//
//    @FXML
//    private Button K15C;
//
//    @FXML
//    private Button K16C;
//
//    @FXML
//    private Button K17C;
//
//    @FXML
//    private Button K18C;
//
//    @FXML
//    private Button K19C;
//
//    @FXML
//    private Button K1C;
//
//    @FXML
//    private Button K1E;
//
//    @FXML
//    private Button K20C;
//
//    @FXML
//    private Button K21C;
//
//    @FXML
//    private Button K22C;
//
//    @FXML
//    private Button K23C;
//
//    @FXML
//    private Button K24C;
//
//    @FXML
//    private Button K25C;
//
//    @FXML
//    private Button K26C;
//
//    @FXML
//    private Button K27C;
//
//    @FXML
//    private Button K28C;
//
//    @FXML
//    private Button K2C;
//
//    @FXML
//    private Button K2E;
//
//    @FXML
//    private Button K3C;
//
//    @FXML
//    private Button K3E;
//
//    @FXML
//    private Button K4C;
//
//    @FXML
//    private Button K4E;
//
//    @FXML
//    private Button K5C;
//
//    @FXML
//    private Button K5E;
//
//    @FXML
//    private Button K6C;
//
//    @FXML
//    private Button K7C;
//
//    @FXML
//    private Button K8C;
//
//    @FXML
//    private Button K9C;

    @FXML
    private Button btnAceptarPuestos;

    @FXML
    private Label txtPuestosSeleccionados;
    
    private String identificacionAvion;
    
    private AplicacionAerolinea aplicacionAerolinea;
    
    private ArrayList<String> puestosSeleccionados = new ArrayList<>();
    private ArrayList<Button> listaBotonesSeleccionados = new ArrayList<>();
    private ArrayList<Button> listaPuestosOcupados = new ArrayList<>();
    private Button[] puestos;
    private String claseVuelo;
    private int numPersonasViaje;
    
    public ArrayList<Button> getListaBotonesSeleccionados() {
		return listaBotonesSeleccionados;
	}

    private Button[] llenarPuestos() {
		Button[] listaPuestos = {A1E, A2E, A3E, A4E, A5E, C1E, C2E, C3E, C4E, C5E, D1E, D2E, D3E, D4E, D5E, F1E, F2E, F3E, F4E, F5E, H1E, H2E, H3E, H4E, H5E, 
								 K1E, K2E, K3E, K4E, K5E, A1C, A2C, A3C, A4C, A5C, A6C, A7C, A8C, A9C, A10C, A11C, A12C, A13C, A14C, A15C, A16C, A17C, A18C, A19C,
								 A20C, A21C, A22C, A23C, A24C, A25C, A26C, A27C, A28C, C1C, C2C, C3C, C4C, C5C, C6C, C7C, C8C, C9C, C10C, C11C, C12C, C13C, C14C, 
								 C15C, C16C, C17C, C18C, C19C, C20C, C21C, C22C, C23C, C24C, C25C, C26C, C27C, C28C, D1C, D2C, D3C, D4C, D5C, D6C, D7C, D8C, D9C, 
								 D10C, D11C, D12C, D13C, D14C, D15C, D16C, D17C, D18C, D19C, D20C, D21C, D22C, D23C, D24C, D25C, D26C, D27C, E1C, E2C, E3C, E4C, E5C,
								 E6C, E7C, E8C, E9C, E10C, E11C, E12C, E13C, E14C, E15C, E16C, E17C, E18C, E19C, E20C, E21C, E22C, E23C, E24C, E25C, E26C, E27C, E28C, 
								 F1C, F2C, F3C, F4C, F5C, F6C, F7C, F8C, F9C, F10C, F11C, F12C, F13C, F14C, F15C, F16C, F17C, F18C, F19C, F20C, F21C, F22C, F23C, F24C,
								 F25C, F26C, F27C, F28C, G1C, G2C, G3C, G4C, G5C, G6C, G7C, G8C, G9C, G10C, G11C, G12C, G13C, G14C, G15C, G16C, G17C, G18C, G19C, G20C,
								 G21C, G22C, G23C, G24C, G25C, G26C, G27C, H1C, H2C, H3C, H4C, H5C, H6C, H7C, H8C, H9C, H10C, H11C, H12C, H13C, H14C, H15C, H16C, H17C, 
								 H18C, H19C, H20C, H21C, H22C, H23C, H24C, H25C, H26C, H27C, H28C, K1C, K2C, K3C, K4C, K5C, K6C, K7C, K8C, K9C, K10C, K11C, K12C, K13C, 
								 K14C, K15C, K16C, K17C, K18C, K19C, K20C, K21C, K22C, K23C, K24C, K25C, K26C, K27C, K28C};
		return listaPuestos;
	}

	public void setListaBotonesSeleccionados(ArrayList<Button> listaBotonesSeleccionados) {
		this.listaBotonesSeleccionados = listaBotonesSeleccionados;
	}
    
    public void setAplicacion(AplicacionAerolinea aplicacionAerolinea) {
    	this.aplicacionAerolinea = aplicacionAerolinea;
    	this.aerolinea = aplicacionAerolinea.getAerolinea(); 
    	
    	listaPuestosOcupados.clear();
    	listaPuestosOcupados.addAll(sillasOcupadas());
    }

	@FXML
    void handleButtonPress(ActionEvent event) {
    	
		// Valida la selección de puesto en la clase que decidió viajar
    	if(claseVuelo.equalsIgnoreCase("Ejecutiva") && ((Button)event.getTarget()).getId().endsWith("C")) {
    		aplicacionAerolinea.mostrarMensaje("Selección de Puesto", "Selección de Puesto", "No puede seleccionar este puesto ya que eligió viajar en clase ejecutiva", AlertType.INFORMATION);
    		
    	} else if(claseVuelo.equalsIgnoreCase("Económica") && ((Button)event.getTarget()).getId().endsWith("E")) {
    		aplicacionAerolinea.mostrarMensaje("Selección de Puesto", "Selección de Puesto", "No puede seleccionar este puesto ya que eligió viajar en clase económica", AlertType.INFORMATION);
    		
    	} else {	
    		// Validar que el usuario no seleccione un número mayor en los puestos comparándolo con el número de personas que seleccionó para el viaje
			if(((Button)event.getTarget()).getStyle().equalsIgnoreCase("-fx-background-color: #E5E102;") || ((Button)event.getTarget()).getStyle().equalsIgnoreCase("-fx-background-color: #079CE6;")) {
								
				if(puestosSeleccionados.size()+1 > numPersonasViaje) {
					aplicacionAerolinea.mostrarMensaje("Selección de Puesto", "Selección de Puesto", "No puede seleccionar este puesto, sobrepasa el cupo del número de personas para su viaje", AlertType.INFORMATION);
					
				} else {
					((Button)event.getTarget()).setStyle("-fx-background-color: GREEN");
					listaBotonesSeleccionados.add(((Button)event.getTarget()));
					
					puestosSeleccionados.add(((Button)event.getTarget()).getId());
					txtPuestosSeleccionados.setText(puestosSeleccionados + " ");					
				}
					
			// Cambio de color en los botones dependiendo de la selección
			} else if(((Button)event.getTarget()).getStyle().equalsIgnoreCase("-fx-background-color: GREEN") && ((Button)event.getTarget()).getId().endsWith("E")) {
				
				((Button)event.getTarget()).setStyle("-fx-background-color: #079CE6;");
				listaBotonesSeleccionados.remove(((Button)event.getTarget()));
				
				puestosSeleccionados.remove(((Button)event.getTarget()).getId());
				txtPuestosSeleccionados.setText(puestosSeleccionados + " ");
				
			} else if(((Button)event.getTarget()).getStyle().equalsIgnoreCase("-fx-background-color: GREEN") && ((Button)event.getTarget()).getId().endsWith("C")) {
				
				((Button)event.getTarget()).setStyle("-fx-background-color: #E5E102;");
				listaBotonesSeleccionados.remove(((Button)event.getTarget()));
				
				puestosSeleccionados.remove(((Button)event.getTarget()).getId());
				txtPuestosSeleccionados.setText(puestosSeleccionados + " ");
			}	
    	}
    }

	@FXML
    void aceptarPuestos(ActionEvent event) {
		
		if(puestosSeleccionados.size() < numPersonasViaje) {
			aplicacionAerolinea.mostrarMensaje("Selección de Puesto", "Selección de Puesto", "Su cupo para este vuelo es de " + numPersonasViaje + " personas, seleccione los demás puestos que desea ocupar", AlertType.INFORMATION);
			
		} else {
			boolean confirmacion = aplicacionAerolinea.mostrarMensaje("Compra de Tiquetes", "Compra de Tiquetes", "¿Desea seleccionar estos puestos? \n Después de seleccionados ya no podrá cambiarlos.");		
			
			if(confirmacion == true) {
				ArrayList<String> listaSillasCliente = new ArrayList<>();
				for (Button puestoSeleccionado : listaBotonesSeleccionados) {
					puestoSeleccionado.setStyle("-fx-background-color: #EA1200");
					listaSillasCliente.add(puestoSeleccionado.getId());
				}
				modelFactoryController.ocupacionSillasCliente(listaSillasCliente);
				aplicacionAerolinea.mostrarMensaje("Compra de Tiquetes", "Compra de Tiquetes", "Se han registrado sus puestos con éxito", AlertType.INFORMATION);
				btnAceptarPuestos.setDisable(true);
			}			
		}
	}
	
	/**
	 * Encontrar los puestos ocupados del avión y pintarlos
	 * @return
	 */
    private ArrayList<Button> sillasOcupadas() {
    	ArrayList<Button> listaPuestos = new ArrayList<>();
    	puestos = llenarPuestos();
    	
    	for (Aeronave aeronave : aerolinea.getListaAeronaves()) {	    		
    		if(aeronave.getNumIdentificacionAvion().equalsIgnoreCase(identificacionAvion)) {    			
    			
    			for(String puesto : aeronave.getCapacidadAsientos()) {
    				for(Button puestoOcupado : puestos) {
    					
						if(puesto.equalsIgnoreCase(puestoOcupado.getId())) {
							puestoOcupado.setStyle("-fx-background-color: #EA1200");
							listaPuestos.add(puestoOcupado);
						}
					}
				}
    		}    				
		}  
    	return listaPuestos;
	}

	public void recuperarDatos(String idAvion, String claseViaje, int numPersonas) {		
		identificacionAvion = idAvion;
		claseVuelo = claseViaje;
		numPersonasViaje = numPersonas;
	}


}


package co.edu.uniquindio.aerolinea.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.excepciones.DatosInvalidosException;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Clase Singleton
 * @author Jessica Johana Ospina Patiño
 */
public class OcupacionSillasController {
	
	//----------SINGLETON----------------------------------------------------->
	ModelFactoryController modelFactoryController;
	Aerolinea aerolinea;
	
	public OcupacionSillasController() {
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
    private Button A10C;

    @FXML
    private Button A11C;

    @FXML
    private Button A12C;

    @FXML
    private Button A13C;

    @FXML
    private Button A14C;

    @FXML
    private Button A15C;

    @FXML
    private Button A16C;

    @FXML
    private Button A17C;

    @FXML
    private Button A18C;

    @FXML
    private Button A19C;

    @FXML
    private Button A1C;

    @FXML
    private Button A1E;

    @FXML
    private Button A20C;

    @FXML
    private Button A21C;

    @FXML
    private Button A22C;

    @FXML
    private Button A23C;

    @FXML
    private Button A2C;

    @FXML
    private Button A2E;

    @FXML
    private Button A3C;

    @FXML
    private Button A3E;

    @FXML
    private Button A4C;

    @FXML
    private Button A5C;

    @FXML
    private Button A6C;

    @FXML
    private Button A7C;

    @FXML
    private Button A8C;

    @FXML
    private Button A9C;

    @FXML
    private Button B10C;

    @FXML
    private Button B11C;

    @FXML
    private Button B12C;

    @FXML
    private Button B13C;

    @FXML
    private Button B14C;

    @FXML
    private Button B15C;

    @FXML
    private Button B16C;

    @FXML
    private Button B17C;

    @FXML
    private Button B18C;

    @FXML
    private Button B19C;

    @FXML
    private Button B1C;

    @FXML
    private Button B20C;

    @FXML
    private Button B21C;

    @FXML
    private Button B22C;

    @FXML
    private Button B23C;

    @FXML
    private Button B2C;

    @FXML
    private Button B3C;

    @FXML
    private Button B4C;

    @FXML
    private Button B5C;

    @FXML
    private Button B6C;

    @FXML
    private Button B7C;

    @FXML
    private Button B8C;

    @FXML
    private Button B9C;

    @FXML
    private Button C10C;

    @FXML
    private Button C11C;

    @FXML
    private Button C12C;

    @FXML
    private Button C13C;

    @FXML
    private Button C14C;

    @FXML
    private Button C15C;

    @FXML
    private Button C16C;

    @FXML
    private Button C17C;

    @FXML
    private Button C18C;

    @FXML
    private Button C19C;

    @FXML
    private Button C1C;

    @FXML
    private Button C1E;

    @FXML
    private Button C20C;

    @FXML
    private Button C21C;

    @FXML
    private Button C22C;

    @FXML
    private Button C23C;

    @FXML
    private Button C2C;

    @FXML
    private Button C2E;

    @FXML
    private Button C3C;

    @FXML
    private Button C3E;

    @FXML
    private Button C4C;

    @FXML
    private Button C5C;

    @FXML
    private Button C6C;

    @FXML
    private Button C7C;

    @FXML
    private Button C8C;

    @FXML
    private Button C9C;

    @FXML
    private Button D10C;

    @FXML
    private Button D11C;

    @FXML
    private Button D12C;

    @FXML
    private Button D13C;

    @FXML
    private Button D14C;

    @FXML
    private Button D15C;

    @FXML
    private Button D16C;

    @FXML
    private Button D17C;

    @FXML
    private Button D18C;

    @FXML
    private Button D19C;

    @FXML
    private Button D1C;

    @FXML
    private Button D1E;

    @FXML
    private Button D20C;

    @FXML
    private Button D21C;

    @FXML
    private Button D22C;

    @FXML
    private Button D23C;

    @FXML
    private Button D2C;

    @FXML
    private Button D2E;

    @FXML
    private Button D3C;

    @FXML
    private Button D3E;

    @FXML
    private Button D4C;

    @FXML
    private Button D5C;

    @FXML
    private Button D6C;

    @FXML
    private Button D7C;

    @FXML
    private Button D8C;

    @FXML
    private Button D9C;

    @FXML
    private Button E10C;

    @FXML
    private Button E11C;

    @FXML
    private Button E12C;

    @FXML
    private Button E13C;

    @FXML
    private Button E14C;

    @FXML
    private Button E15C;

    @FXML
    private Button E16C;

    @FXML
    private Button E17C;

    @FXML
    private Button E18C;

    @FXML
    private Button E19C;

    @FXML
    private Button E1C;

    @FXML
    private Button E20C;

    @FXML
    private Button E21C;

    @FXML
    private Button E22C;

    @FXML
    private Button E23C;

    @FXML
    private Button E2C;

    @FXML
    private Button E3C;

    @FXML
    private Button E4C;

    @FXML
    private Button E5C;

    @FXML
    private Button E6C;

    @FXML
    private Button E7C;

    @FXML
    private Button E8C;

    @FXML
    private Button E9C;

    @FXML
    private Button F10C;

    @FXML
    private Button F11C;

    @FXML
    private Button F12C;

    @FXML
    private Button F13C;

    @FXML
    private Button F14C;

    @FXML
    private Button F15C;

    @FXML
    private Button F16C;

    @FXML
    private Button F17C;

    @FXML
    private Button F18C;

    @FXML
    private Button F19C;

    @FXML
    private Button F1C;

    @FXML
    private Button F1E;

    @FXML
    private Button F20C;

    @FXML
    private Button F21C;

    @FXML
    private Button F22C;

    @FXML
    private Button F23C;

    @FXML
    private Button F2C;

    @FXML
    private Button F2E;

    @FXML
    private Button F3C;

    @FXML
    private Button F3E;

    @FXML
    private Button F4C;

    @FXML
    private Button F5C;

    @FXML
    private Button F6C;

    @FXML
    private Button F7C;

    @FXML
    private Button F8C;

    @FXML
    private Button F9C;

    @FXML
    private Button btnAceptarPuestos;
    
    @FXML
    private Label txtPuestosSeleccionados;
    
    ArrayList<String> puestosSeleccionados = new ArrayList<>();
    
    private AplicacionAerolinea aplicacionAerolinea;
    
    private ArrayList<Button> listaBotonesSeleccionados = new ArrayList<>();
    
    public ArrayList<Button> getListaBotonesSeleccionados() {
		return listaBotonesSeleccionados;
	}
	public void setListaBotonesSeleccionados(ArrayList<Button> listaBotonesSeleccionados) {
		this.listaBotonesSeleccionados = listaBotonesSeleccionados;
	}
    
    public void setAplicacion(AplicacionAerolinea aplicacionAerolinea) {
    	this.aplicacionAerolinea = aplicacionAerolinea;
    	this.aerolinea = aplicacionAerolinea.getAerolinea();    	
    }

    @FXML
    void handleButtonPress(ActionEvent event) {
    	
    	if(((Button)event.getTarget()).getStyle().equalsIgnoreCase("-fx-background-color: #E5E102;") || ((Button)event.getTarget()).getStyle().equalsIgnoreCase("-fx-background-color: #079CE6;")) {
    		    		    		
    		((Button)event.getTarget()).setStyle("-fx-background-color: GREEN");
    		listaBotonesSeleccionados.add(((Button)event.getTarget()));
    		
    		puestosSeleccionados.add(((Button)event.getTarget()).getId());
    		txtPuestosSeleccionados.setText(puestosSeleccionados + " ");
    		
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

	@FXML
    void aceptarPuestos(ActionEvent event) {
		
		//Confirmar que el usuario si quiere los puestos seleccionados
		int mensajeDeConfirmacion = JOptionPane.showConfirmDialog(null, "¿Desea seleccionar estos puestos? Después de seleccionados ya no podrá cambiarlos.");
		aplicacionAerolinea.mostrarMensaje("Compra de Tiquetes", "Compra de Tiquetes", "¿Desea seleccionar estos puestos? Después de seleccionados ya no podrá cambiarlos.", AlertType.CONFIRMATION);
//		System.out.println(aplicacionAerolinea.mostrarMensaje("Compra de Tiquetes", "Compra de Tiquetes", "¿Desea seleccionar estos puestos? Después de seleccionados ya no podrá cambiarlos.", AlertType.CONFIRMATION);		
		if(mensajeDeConfirmacion == 0) {
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

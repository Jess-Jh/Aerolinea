package co.edu.uniquindio.aerolinea.aplicacion;

import java.io.IOException;

import co.edu.uniquindio.aerolinea.controladores.AerolineaController;
import co.edu.uniquindio.aerolinea.controladores.ModelFactoryController;
import co.edu.uniquindio.aerolinea.controladores.OcupacionSillasController;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AplicacionAerolinea extends Application {
	
	private Stage primaryStage;
	private Stage dialogStage;
	
	ModelFactoryController modelFactoryController;
	private Aerolinea aerolinea;
	
	public AplicacionAerolinea () {
		modelFactoryController = ModelFactoryController.getInstance();
		aerolinea = modelFactoryController.getAerolinea();
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		
		mostrarVentanaPrincipal();
	}
	
	public void mostrarVentanaPrincipal() {
			
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AplicacionAerolinea.class.getResource("/co/edu/uniquindio/aerolinea/vistas/AerolineaView.fxml"));
			AnchorPane anchorPane = (AnchorPane)loader.load();
			AerolineaController aerolineaController = loader.getController();
			aerolineaController.setAplicacion(this);
			
			dialogStage = new Stage();
			dialogStage.setTitle("Gestión de Viajes de la Aerolínea");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			
			Scene scene = new Scene(anchorPane);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cargar vista mostrarOcupacionSillas
	 */
	public void mostrarOcupacionSillasView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AplicacionAerolinea.class.getResource("/co/edu/uniquindio/aerolinea/vistas/OcupacionSillasView.fxml"));
			AnchorPane anchorPane = (AnchorPane)loader.load();
			OcupacionSillasController ocupacionSillasController = loader.getController();
			ocupacionSillasController.setAplicacion(this);
			
			dialogStage = new Stage();
			dialogStage.setTitle("Ocupación Sillas");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			
			Scene scene = new Scene(anchorPane);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Cargar vista mostrarOcupacionSillas
	 */
	public void mostrarOcupacionSillas2View() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AplicacionAerolinea.class.getResource("/co/edu/uniquindio/aerolinea/vistas/OcupacionSillas2View.fxml"));
			AnchorPane anchorPane = (AnchorPane)loader.load();
			OcupacionSillasController ocupacionSillasController = loader.getController();
			ocupacionSillasController.setAplicacion(this);
			
			dialogStage = new Stage();
			dialogStage.setTitle("Ocupación Sillas");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			
			Scene scene = new Scene(anchorPane);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Cargar vista mostrarOcupacionSillas
	 */
	public void mostrarOcupacionSillas3View() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AplicacionAerolinea.class.getResource("/co/edu/uniquindio/aerolinea/vistas/OcupacionSillas3View.fxml"));
			AnchorPane anchorPane = (AnchorPane)loader.load();
			OcupacionSillasController ocupacionSillasController = loader.getController();
			ocupacionSillasController.setAplicacion(this);
			
			dialogStage = new Stage();
			dialogStage.setTitle("Ocupación Sillas");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			
			Scene scene = new Scene(anchorPane);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
     * Método para mostrar un mensaje al usuario
     * @param titulo, header, contenido, alertType
     */
    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
    }


}

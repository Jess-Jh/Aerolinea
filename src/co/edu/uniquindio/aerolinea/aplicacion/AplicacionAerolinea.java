package co.edu.uniquindio.aerolinea.aplicacion;

import java.io.IOException;

import co.edu.uniquindio.aerolinea.controladores.ModelFactoryController;
import co.edu.uniquindio.aerolinea.controladores.OcupacionSillasController;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
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
			loader.setLocation(AplicacionAerolinea.class.getResource("/co/edu/uniquindio/aerolinea/vistas/OcupacionSillasView.fxml"));
			AnchorPane anchorPane = (AnchorPane)loader.load();
			OcupacionSillasController ocupacionSillasController = loader.getController();
			ocupacionSillasController.setAplicacion(this);
			
			Scene scene = new Scene(anchorPane);
//			scene.setFill(Color.TRANSPARENT);
//			primaryStage.initStyle(StageStyle.TRANSPARENT);
			
			primaryStage.setScene(scene);
			primaryStage.show();				
			
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

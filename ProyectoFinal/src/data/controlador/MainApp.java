package data.controlador;
//code.makery.ch/library/javafx-8-tutorial/es/part1

import java.io.IOException;

import data.modelo.MysqlConsulta1;
import data.modelo.MoviebankConsulta1;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<MoviebankConsulta1> ObservableListMoviebankConsulta1;
    

    @Override
    public void start(Stage primaryStage) {
    	String SqlQuery1 = "SELECT \r\n" + 
    			"    moviebank.distribuidores.Nombre AS Distribuidores,\r\n" + 
    			"    moviebank.peliculas.Titulo AS Titulo\r\n" + 
    			"FROM\r\n" + 
    			"    moviebank.peliculas\r\n" + 
    			"        INNER JOIN\r\n" + 
    			"    moviebank.distribuyenp ON moviebank.peliculas.EAN = moviebank.distribuyenp.EAN\r\n" + 
    			"        INNER JOIN\r\n" + 
    			"    moviebank.distribuidores ON moviebank.distribuyenp.ID_Distribuidores = moviebank.distribuidores.ID_Distribuidores;";
    	MoviebankConsulta1 objectSQL1;
    	
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Consulta 1");
        objectSQL1 = new MoviebankConsulta1(SqlQuery1, SqlQuery1, SqlQuery1, SqlQuery1);
        this.ObservableListMoviebankConsulta1 = objectSQL1.getObservableList();
        
        initRootLayout();

        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../vista/PantallaPPal.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../vista/DataOverView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
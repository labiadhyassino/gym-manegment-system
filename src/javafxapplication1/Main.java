package javafxapplication1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

 @Override
    public void start(Stage primaryStage) throws Exception {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.setWidth(700); // largeur souhaitée
        primaryStage.setHeight(500); // hauteur souhaitée
        primaryStage.setResizable(true); // rendre la fenêtre non redimensionnable (si nécessaire)
        primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Affiche l'erreur pour le débogage
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

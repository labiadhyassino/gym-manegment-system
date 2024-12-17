package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    // Utilisateur et mot de passe prédéfinis pour la démonstration
    private final String validUsername = "u";
    private final String validPassword = "123";

    // Méthode appelée lors du clic sur le bouton de connexion
    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Vérification des informations d'identification
        if (validUsername.equals(username) && validPassword.equals(password)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
            Parent newPage = loader.load();

        // Obtenir la scène actuelle et changer la page affichée
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            currentStage.setScene(new Scene(newPage));
        } else {
            // Si les identifiants sont incorrects, afficher un message d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }
    }
}

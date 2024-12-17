package Controller;

import Model.GestionPersonnel.Personnel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditPersonnelController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField roleField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField telephoneField;

    private Personnel personnel;

    // Méthode pour initialiser les données du personnel à modifier
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;

        // Remplir les champs avec les données actuelles
        nomField.setText(personnel.getNom());
        roleField.setText(personnel.getRole());
        emailField.setText(personnel.getEmail());
        telephoneField.setText(personnel.getTelephone());
    }

    // Méthode appelée lors de la validation
    @FXML
    private void confirmerModification() {
        if (personnel != null) {
            // Mettre à jour les informations
            personnel.nomProperty().set(nomField.getText());
            personnel.roleProperty().set(roleField.getText());
            personnel.emailProperty().set(emailField.getText());
            personnel.telephoneProperty().set(telephoneField.getText());

            // Fermer la fenêtre
            Stage stage = (Stage) nomField.getScene().getWindow();
            stage.close();

            // Afficher un message de succès
            showAlert("Succès", "Les informations du personnel ont été mises à jour.");
        }
    }

    // Méthode appelée lors de l'annulation
    @FXML
    private void annulerModification() {
        // Fermer la fenêtre sans enregistrer les modifications
        Stage stage = (Stage) nomField.getScene().getWindow();
        stage.close();
    }

    // Méthode pour afficher une alerte
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

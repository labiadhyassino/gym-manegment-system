package Controller;

import Model.gestion_membre.Membre;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifierMembreController {

    @FXML
    private TextField abonnementField;

    @FXML
    private TextField telephoneField;

    private Membre membre;

    // Initialiser les champs avec les données du membre sélectionné
    public void initialiserDonnees(Membre membre) {
        this.membre = membre;

        // Remplir les champs avec les données existantes
        abonnementField.setText(membre.getAbonnement());
        telephoneField.setText(membre.getTelephone());
    }

    // Méthode pour confirmer la modification des champs modifiables
    @FXML
    private void confirmerModification() {
        if (membre != null) {
            // Mettre à jour les champs modifiables
            membre.setAbonnement(abonnementField.getText());
            membre.setTelephone(telephoneField.getText());

            // Sauvegarder les modifications
            enregistrerMembre(membre);

            // Fermer la fenêtre (popup)
            fermerPopup();
        } else {
            showAlert("Erreur", "Aucun membre sélectionné pour modification.");
        }
    }

    // Méthode fictive pour sauvegarder les modifications
    private void enregistrerMembre(Membre membre) {
        // Implémentez ici la logique pour sauvegarder les modifications dans la base de données ou autre stockage
        System.out.println("Membre modifié : " + membre.getAbonnement() + ", " + membre.getTelephone());
    }

    // Méthode pour fermer la fenêtre popup
    @FXML
    private void fermerPopup() {
        Stage stage = (Stage) abonnementField.getScene().getWindow();
        stage.close();
    }

    // Méthode pour afficher une alerte en cas d'erreur
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

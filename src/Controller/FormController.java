package Controller;

import Model.gestion_membre.Membre;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class FormController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField abonnementField;
    @FXML
    private TextField telephoneField;

    private ObservableList<Membre> membresList;
    private GestionMembreController gestionMembreController;  // Ajoutez une référence à GestionMembreController

    // Setter pour la liste des membres
    public void setMembresList(ObservableList<Membre> membresList) {
        this.membresList = membresList;
    }

    // Setter pour la référence du GestionMembreController
    public void setGestionMembreController(GestionMembreController gestionMembreController) {
        this.gestionMembreController = gestionMembreController;
    }

    // Méthode qui est appelée pour confirmer l'ajout du membre
    @FXML
    public void confirmerAction() {
        // Récupérer les valeurs des champs de texte
        String id = String.valueOf(membresList.size() + 1); // Générer un ID unique
        String nom = nomField.getText().trim();
        String prenom = prenomField.getText().trim();
        String email = abonnementField.getText().trim();
        String telephone = telephoneField.getText().trim();

        // Vérifier que tous les champs sont remplis
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || telephone.isEmpty()) {
            System.out.println("Erreur : Tous les champs doivent être remplis !");
            return;
        }

        // Demander confirmation à l'utilisateur
        Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Ajout du membre");
        confirmationAlert.setContentText("Voulez-vous confirmer l'ajout de ce membre ?");
        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Créer un objet Membre avec les données
                Membre membre = new Membre(id, nom, prenom, email, telephone);

                // Ajouter le membre à la base de données
                ConnexionDatabase.ajouterMembre(membre);

                // Rafraîchir la liste des membres dans GestionMembreController
               
                // Fermer la fenêtre après l'ajout
                Stage stage = (Stage) nomField.getScene().getWindow();
                stage.close();
            }
        });
    }
}

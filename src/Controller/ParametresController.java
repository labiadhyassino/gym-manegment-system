package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Optional;

public class ParametresController {

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> colNom;

    @FXML
    private TableColumn<User, String> colEmail;

    @FXML
    private TableColumn<User, String> colStatut;

    @FXML
    private TableColumn<User, String> colDateInscription;

    @FXML
    private Button BackButton;

    // Liste des utilisateurs (exemple de données)
    private ObservableList<User> userList = FXCollections.observableArrayList();

    public void initialize() {
        // Configuration des colonnes du tableau
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colStatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        colDateInscription.setCellValueFactory(new PropertyValueFactory<>("dateInscription"));

        // Ajouter des données exemple
        userList.add(new User("Jean Dupont", "jean.dupont@mail.com", "Admin", "2023-01-10"));
        userList.add(new User("Marie Dubois", "marie.dubois@mail.com", "Utilisateur", "2023-03-15"));

        // Ajouter la liste au tableau
        userTable.setItems(userList);
    }

    @FXML
    private void addUser() {
        // Ouvrir une fenêtre pour ajouter un utilisateur
        showAlert("Ajouter Utilisateur", "Fenêtre d'ajout à implémenter.");
    }

    @FXML
    private void editUser() {
        // Vérifier si un utilisateur est sélectionné
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            showAlert("Erreur", "Veuillez sélectionner un utilisateur à modifier.");
            return;
        }

        // Ouvrir une fenêtre pour modifier l'utilisateur
        showAlert("Modifier Utilisateur", "Fenêtre de modification à implémenter pour " + selectedUser.getNom() + ".");
    }

    @FXML
    private void deleteUser() {
        // Vérifier si un utilisateur est sélectionné
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            showAlert("Erreur", "Veuillez sélectionner un utilisateur à supprimer.");
            return;
        }

        // Confirmation avant suppression
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");
        alert.setContentText("Nom : " + selectedUser.getNom() + "\nEmail : " + selectedUser.getEmail());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            userList.remove(selectedUser);
            showAlert("Succès", "L'utilisateur a été supprimé avec succès.");
        }
    }

    @FXML
    private void changePassword() {
        // Ouvrir une fenêtre pour changer le mot de passe
        showAlert("Modifier Mot de Passe", "Fenêtre de modification du mot de passe à implémenter.");
    }

    @FXML
    private void changeTheme() {
        // Exemple de logique pour changer le thème
        showAlert("Changer le Thème", "Fonctionnalité à implémenter.");
    }

    @FXML
    private void changeLanguage() {
        // Exemple de logique pour changer la langue
        showAlert("Changer la Langue", "Fonctionnalité à implémenter.");
    }

    @FXML
    private void editHours() {
        // Exemple de logique pour modifier les horaires
        showAlert("Modifier Horaires", "Fenêtre de modification des horaires à implémenter.");
    }

    @FXML
    private void BackAction() throws IOException {
        // Retour au menu principal
        Stage stage = (Stage) BackButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }

    // Méthode utilitaire pour afficher des alertes
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Classe interne pour représenter un utilisateur
    public static class User {
        private final String nom;
        private final String email;
        private final String statut;
        private final String dateInscription;

        public User(String nom, String email, String statut, String dateInscription) {
            this.nom = nom;
            this.email = email;
            this.statut = statut;
            this.dateInscription = dateInscription;
        }

        public String getNom() {
            return nom;
        }

        public String getEmail() {
            return email;
        }

        public String getStatut() {
            return statut;
        }

        public String getDateInscription() {
            return dateInscription;
        }
    }
}

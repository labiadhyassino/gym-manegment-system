package Controller;

import Model.GestionPersonnel.Entraineur;
import Model.GestionPersonnel.Personnel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonnelsController {

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Personnel> personnelTable;

    @FXML
    private TableColumn<Personnel, String> colNom;

    @FXML
    private TableColumn<Personnel, String> colRole;

    @FXML
    private TableColumn<Personnel, String> colEmail;

    @FXML
    private TableColumn<Personnel, String> colTelephone;

    @FXML
    private Button BackButton;

    private ObservableList<Personnel> personnelsList = FXCollections.observableArrayList();

    public void initialize() {
        // Configuration des colonnes
        colNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        colRole.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        colTelephone.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty());

        // Exemple de données
        personnelsList.addAll(
                new Personnel("Jean Dupont", "Manager", "jean.dupont@mail.com", "123456789"),
                new Personnel("Marie Dubois", "Secrétaire", "marie.dubois@mail.com", "987654321")
        );

        // Ajouter la liste des personnels au tableau
        personnelTable.setItems(personnelsList);
    }

    // Méthode de recherche
    @FXML
    private void searchPersonnel() {
        String query = searchField.getText().toLowerCase();
        ObservableList<Personnel> filteredList = FXCollections.observableArrayList();

        for (Personnel p : personnelsList) {
            if (p.getNom().toLowerCase().contains(query) || p.getRole().toLowerCase().contains(query)) {
                filteredList.add(p);
            }
        }

        personnelTable.setItems(filteredList);
    }

    // Méthode d'ajout de personnel
    @FXML
    private void addPersonnel() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/AddPersonnelForm.fxml"));
            Parent root = loader.load();

            // Créer et configurer la fenêtre modale
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Ajouter un Personnel");
            stage.setScene(new Scene(root));

            // Afficher la fenêtre
            stage.showAndWait();

            // Recharger les données (dans une vraie application, vous récupérez depuis une base de données)
            personnelTable.setItems(personnelsList);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur", "Impossible d'ouvrir la fenêtre d'ajout.");
        }
    }

    // Méthode de modification de personnel
    @FXML
    private void editPersonnel() {
        Personnel selectedPersonnel = personnelTable.getSelectionModel().getSelectedItem();
        if (selectedPersonnel == null) {
            showAlert("Avertissement", "Veuillez sélectionner un personnel à modifier.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/EditPersonnelForm.fxml"));
            Parent root = loader.load();

            // Configurer le contrôleur de la fenêtre
            EditPersonnelController controller = loader.getController();
            controller.setPersonnel(selectedPersonnel);

            // Créer et configurer la fenêtre modale
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Modifier un Personnel");
            stage.setScene(new Scene(root));

            // Afficher la fenêtre
            stage.showAndWait();

            // Recharger les données (dans une vraie application, vous récupérez depuis une base de données)
            personnelTable.refresh();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur", "Impossible d'ouvrir la fenêtre de modification.");
        }
    }

    // Méthode de suppression de personnel
    @FXML
    private void deletePersonnel() {
        Personnel selectedPersonnel = personnelTable.getSelectionModel().getSelectedItem();
        if (selectedPersonnel == null) {
            showAlert("Avertissement", "Veuillez sélectionner un personnel à supprimer.");
            return;
        }

        personnelsList.remove(selectedPersonnel);
        personnelTable.setItems(personnelsList);
        showAlert("Succès", "Le personnel a été supprimé.");
    }

    @FXML
    private void BackAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) BackButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur", "Impossible de revenir à l'accueil.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

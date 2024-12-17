package Controller;
/*
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import Model.gestion_membre.Membre;

import java.io.IOException;
import java.sql.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class GestionMembreController {

    @FXML
    public TableView<Membre> tableMembres;
    @FXML
    private TableColumn<Membre, String> idField;
    @FXML
    private TableColumn<Membre, String> nomField;
    @FXML
    private TableColumn<Membre, String> prenomField;
    @FXML
    private TableColumn<Membre, String> abonnementField;
    @FXML
    private TableColumn<Membre, String> telephoneField;

    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnRechercher;

    @FXML
    private Button BackButton;

    // Liste des membres
    ObservableList<Membre> membresList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialiser les colonnes de la table
        idField.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomField.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomField.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        abonnementField.setCellValueFactory(new PropertyValueFactory<>("abonnement"));
        telephoneField.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        // Charger les données initiales (exemple de membres)
        membresList.add(new Membre("1", "LABIADH", "Yassine", "Premium", "0123456789"));
        membresList.add(new Membre("2", "BOUDIDAH", "Eya", "Standard", "0987654321"));

        tableMembres.setItems(membresList);
    }

    @FXML
    public void afficherPopupAjoutMembre() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/MemberForm.fxml"));
            VBox popupContent = loader.load();

            // Récupérer le contrôleur du formulaire
            FormController controller = loader.getController();
            controller.setMembresList(membresList);  // Passer la liste des membres

            // Créer une nouvelle scène pour le popup
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Ajouter un Membre");
            popupStage.setScene(new Scene(popupContent));
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter un membre à la base de données
   
public void setMembresList(ObservableList<Membre> membresList) {
    this.membresList = membresList;
}

@FXML
public void ajouterMembre(Membre membre) throws SQLException {
        Connection conn = ConnexionDatabase.getConnection();
        String sql = "INSERT INTO MEMBRES (id, nom, prenom, abonnement, telephone) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, membre.getId());
            pstmt.setString(2, membre.getNom());
            pstmt.setString(3, membre.getPrenom());
            pstmt.setString(4, membre.getAbonnement());
            pstmt.setString(5, membre.getTelephone());
            pstmt.executeUpdate();  // Exécuter l'insertion

            // Si l'ajout est réussi, on l'ajoute à la liste et à la table
            membresList.add(membre);
            tableMembres.setItems(membresList);
            showAlert("Succès", "Le membre a été ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Erreur", "Une erreur est survenue lors de l'ajout du membre.");
        } finally {
            try {
                if (conn != null) {
                    conn.close();  // Fermer la connexion
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Le reste des méthodes de gestion comme modifier, supprimer, rechercher, etc.
}






*/
import Controller.ConnexionDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.gestion_membre.Membre;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

public class GestionMembreController {

    @FXML
    private TableView<Membre> tableMembres;
    @FXML
    private TableColumn<Membre, String> idField;
    @FXML
    private TableColumn<Membre, String> nomField;
    @FXML
    private TableColumn<Membre, String> prenomField;
    @FXML
    private TableColumn<Membre, String> abonnementField;
    @FXML
    private TableColumn<Membre, String> telephoneField;

    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnRechercher;
    @FXML
    private Button BackButton;

    // Liste des membres
    ObservableList<Membre> membresList = FXCollections.observableArrayList();

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

        public void initialize() {
        // Initialiser les colonnes de la table
        idField.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomField.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomField.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        abonnementField.setCellValueFactory(new PropertyValueFactory<>("abonnement"));
        telephoneField.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        // Charger les données depuis la base de données
        chargerMembresDepuisBaseDeDonnees();
    }

    public void chargerMembresDepuisBaseDeDonnees() {
        membresList.clear();
        String query = "SELECT id, nom, prenom, abonnement, telephone FROM membre";
        try (Connection connection = ConnexionDatabase.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String abonnement = resultSet.getString("abonnement");
                String telephone = resultSet.getString("telephone");

                Membre membre = new Membre(id, nom, prenom, abonnement, telephone);
                membresList.add(membre);
            }

            tableMembres.setItems(membresList);

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Erreur", "Une erreur est survenue lors du chargement des membres.");
        }
    }
    @FXML
     public void afficherPopupAjoutMembre() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/MemberForm.fxml"));
        VBox popupContent = loader.load();

        // Récupérer le contrôleur du formulaire
        FormController controller = loader.getController();
        controller.setMembresList(membresList);  // Passer la liste des membres

        // Créer une nouvelle scène pour le popup
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Ajouter un Membre");
        popupStage.setScene(new Scene(popupContent));
        popupStage.showAndWait();
        chargerMembresDepuisBaseDeDonnees();
        // Recharger les membres après ajout (si nécessaire)
        // chargerMembresDepuisBaseDeDonnees();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
}


    @FXML
   private void afficherPopupModifierMembre() {
    // Vérifier si un membre est sélectionné dans la table
    Membre membreSelectionne = tableMembres.getSelectionModel().getSelectedItem();
    if (membreSelectionne == null) {
        showAlert("Avertissement", "Veuillez sélectionner un membre à modifier.");
        return;
    }

    try {
        // Charger le fichier FXML pour la fenêtre de modification
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ModifierMembreForm.fxml"));
        Parent root = loader.load();

        // Initialiser le contrôleur de la fenêtre modale
        ModifierMembreController modifierController = loader.getController();
        modifierController.initialiserDonnees(membreSelectionne);

        // Créer et afficher la fenêtre modale
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Modifier Membre");
        stage.setScene(new Scene(root));
        stage.showAndWait();

        // Recharger les membres après modification (fonction à implémenter)
        chargerMembresDepuisBaseDeDonnees();
    } catch (IOException e) {
        e.printStackTrace();
        showAlert("Erreur", "Impossible d'ouvrir la fenêtre de modification.");
    } catch (Exception e) {
        e.printStackTrace();
        showAlert("Erreur", "Une erreur inattendue est survenue : " + e.getMessage());
    }
}


    @FXML
    private void handleSupprimer() {
        Membre membreSelectionne = tableMembres.getSelectionModel().getSelectedItem();
        if (membreSelectionne == null) {
            showAlert("Avertissement", "Veuillez sélectionner un membre à supprimer.");
            return;
        }

        String query = "DELETE FROM membre WHERE id = '" + membreSelectionne.getId() + "'";
        try (Connection connection = ConnexionDatabase.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);
            showAlert("Succès", "Le membre a été supprimé avec succès.");
            chargerMembresDepuisBaseDeDonnees();

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Erreur", "Une erreur est survenue lors de la suppression du membre.");
        }
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
}










/*




import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.gestion_membre.Membre;



import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

public class GestionMembreController {

    @FXML
    private TableView<Membre> tableMembres;
    @FXML
    private TableColumn<Membre, String> idField;
    @FXML
    private TableColumn<Membre, String> nomField;
    @FXML
    private TableColumn<Membre, String> prenomField;
    @FXML
    private TableColumn<Membre, String> abonnementField;
    @FXML
    private TableColumn<Membre, String> telephoneField;

    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnRechercher;

    @FXML
    private Button BackButton;

    // Liste des membres
    ObservableList<Membre> membresList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialiser les colonnes de la table
        idField.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomField.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomField.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        abonnementField.setCellValueFactory(new PropertyValueFactory<>("abonnement"));
        telephoneField.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        // Charger les données initiales (exemple de membres)
        membresList.add(new Membre("1", "LABIADH", "Yassine", "Premium", "0123456789"));
        membresList.add(new Membre("2", "BOUDIDAH", "Eya", "Standard", "0987654321"));

        tableMembres.setItems(membresList);
        // Ajouter une action pour le bouton Ajouter
 
    }


    @FXML
public void afficherPopupModifierMembre() {
    // Récupérer le membre sélectionné
    Membre membreSelectionne = tableMembres.getSelectionModel().getSelectedItem();
    if (membreSelectionne == null) {
        showAlert("Aucun membre sélectionné", "Veuillez sélectionner un membre à modifier.");
        return;
    }

    try {
        // Charger le fichier FXML pour le popup de modification
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ModifierMembreForm.fxml"));
        VBox popupContent = loader.load();

        // Obtenir le contrôleur de la nouvelle fenêtre
        ModifierMembreController modifierController = loader.getController();
        modifierController.initData(membreSelectionne); // Passer les données du membre sélectionné

        // Créer et afficher le popup
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Modifier le Membre");
        popupStage.setScene(new Scene(popupContent));
        popupStage.showAndWait();

        // Actualiser la table après modification
        tableMembres.refresh();
    } catch (IOException e) {
        e.printStackTrace();
    }
}



    @FXML
  
 
private void handleSupprimer() {
    try {
        Membre selectedMembre = tableMembres.getSelectionModel().getSelectedItem();

        if (selectedMembre != null) {
            // Fenêtre de confirmation
            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationDialog.setTitle("Confirmation");
            confirmationDialog.setHeaderText("Supprimer le membre");
            confirmationDialog.setContentText("Êtes-vous sûr de vouloir supprimer " + selectedMembre.getNom() + " ?");

            // Si l'utilisateur confirme, supprimer le membre
            if (confirmationDialog.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                membresList.remove(selectedMembre);
                System.out.println("Membre supprimé: " + selectedMembre.getNom());
            }
        } else {
            showAlert("Aucun membre sélectionné", "Veuillez sélectionner un membre à supprimer.");
        }
    } catch (Exception e) {
        showAlert("Erreur", "Une erreur s'est produite lors de la suppression du membre : " + e.getMessage());
        e.printStackTrace(); // Utile pour le débogage
    }
}



    @FXML
    private void handleRechercher() {
        // Implémenter la recherche d'un membre
        // Exemple simple : rechercher par nom
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Recherche");
        dialog.setHeaderText("Rechercher un membre");
        dialog.setContentText("Nom du membre:");
        dialog.showAndWait().ifPresent(nom -> {
            for (Membre membre : membresList) {
                if (membre.getNom().equalsIgnoreCase(nom)) {
                    tableMembres.getSelectionModel().select(membre);
                    System.out.println("Membre trouvé: " + membre.getNom());
                    return;
                }
            }
            showAlert("Membre non trouvé", "Aucun membre trouvé avec le nom : " + nom);
        });
    }

    @FXML
    private void BackAction() throws IOException {
        // Retour au menu principal ou à la vue précédente
        Stage stage = (Stage) BackButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
    
    

  public void afficherPopupAjoutMembre() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/MemberForm.fxml"));
        VBox popupContent = loader.load();

        // Récupérer le contrôleur du formulaire
        FormController controller = loader.getController();
        controller.setMembresList(membresList);  // Passer la liste des membres

        // Créer une nouvelle scène pour le popup
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Ajouter un Membre");
        popupStage.setScene(new Scene(popupContent));
        popupStage.showAndWait();
    } catch (IOException e) {
        e.printStackTrace();
   



    
}
    
  }}
*/
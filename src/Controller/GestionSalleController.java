 package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Modèle pour la salle

import Model.Salle;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionSalleController {

    @FXML
    private TableView<Salle> tableSalles;

    @FXML
    private TableColumn<Salle, String> colNomSalle;

    @FXML
    private TableColumn<Salle, Integer> colCapacite;

    @FXML
    private TableColumn<Salle, String> colStatut;

    @FXML
    private TableColumn<Salle, String> colActivite;

    @FXML
    private Button rafraichir;

    @FXML
    private Button BackButton;

    private ObservableList<Salle> listeSalles = FXCollections.observableArrayList();

    /**
     * Méthode d'initialisation appelée automatiquement par JavaFX.
     */
    @FXML
    public void initialize() {
        
        configurerColonnes();
        chargerDonnees();
    }

    /**
     * Configure les colonnes du tableau.
     */
    private void configurerColonnes() {
        colNomSalle.setCellValueFactory(new PropertyValueFactory<>("nomSalle"));
        colCapacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        colStatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        colActivite.setCellValueFactory(new PropertyValueFactory<>("activite"));
    }

    /**
     * Charge les données des salles depuis la base de données.
     */
   private void chargerDonnees() {
    listeSalles.clear();

    String query = "SELECT nom_salle, capacite, statut, activite FROM salle";
    try (Connection connection = ConnexionDatabase.getConnection();
         PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            String nomSalle = resultSet.getString("nom_salle");
            int capacite = resultSet.getInt("capacite");
            String statut = resultSet.getString("statut");
            String activite = resultSet.getString("activite");

            System.out.println("Salle chargée : " + nomSalle);

            listeSalles.add(new Salle(nomSalle, capacite, statut, activite));
        }

        tableSalles.setItems(listeSalles);
        System.out.println("Chargement terminé. Nombre de salles : " + listeSalles.size());

    } catch (SQLException e) {
        System.err.println("Erreur lors du chargement des données : " + e.getMessage());
    }
}


    /**
     * Rafraîchit la liste des salles.
     */
    @FXML
    private void rafraichirDonnees() {
        chargerDonnees();
    }

    /**
     * Action pour le bouton de retour.
     */
    
    


    
    @FXML
    private void BackAction() throws IOException {
        BackButton1 = BackButton;
        // Retour au menu principal ou à la vue précédente
        Stage stage = (Stage) BackButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }
    private Object BackButton1;
    
    

 }
package Controller;

import Model.Paiement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class PaiementController implements Initializable {

    @FXML
    private Button BackButton;  // Bouton de retour
    @FXML
    private TextField idMembreField;  // Champ ID Membre
    @FXML
    private TextField nomField;  // Champ Nom Membre
    @FXML
    private TextField montantField;  // Champ Montant
    @FXML
    private DatePicker datePaiementPicker;  // Champ Date de Paiement
    @FXML
    private Button btnAjouterPaiement;  // Bouton Ajouter Paiement
    @FXML
    private Button btnRechercherPaiement;  // Bouton Rechercher Paiement
    @FXML
    private Button btnSupprimerPaiement;  // Bouton Supprimer Paiement
    @FXML
    private TableView<Paiement> tablePaiements;  // Table des Paiements
    @FXML
    private TableColumn<Paiement, Integer> colIdPaiement;  // Colonne ID Paiement
    @FXML
    private TableColumn<Paiement, Integer> colIdMembre;  // Colonne ID Membre
    @FXML
    private TableColumn<Paiement, String> colNomMembre;  // Colonne Nom Membre
    @FXML
    private TableColumn<Paiement, Double> colMontant;  // Colonne Montant
    @FXML
    private TableColumn<Paiement, String> colDatePaiement;  // Colonne Date Paiement

    private ObservableList<Paiement> paiementList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisation des colonnes de la table
        colIdPaiement.setCellValueFactory(cellData -> cellData.getValue().idPaiementProperty().asObject());
        colIdMembre.setCellValueFactory(cellData -> cellData.getValue().idMembreProperty().asObject());
        colNomMembre.setCellValueFactory(cellData -> cellData.getValue().nomMembreProperty());
        colMontant.setCellValueFactory(cellData -> cellData.getValue().montantProperty().asObject());
        colDatePaiement.setCellValueFactory(cellData -> cellData.getValue().datePaiementProperty());

        // Initialisation de la table avec la liste vide
        tablePaiements.setItems(paiementList);
    }

    @FXML
    private void BackAction() throws IOException {
        // Retour à la vue précédente (menu principal)
        Stage stage = (Stage) BackButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void ajouterPaiement() {
        // Ajouter un paiement à la liste
        int idMembre = Integer.parseInt(idMembreField.getText());
        String nomMembre = nomField.getText();
        double montant = Double.parseDouble(montantField.getText());
        String datePaiement = datePaiementPicker.getValue().toString();

        Paiement nouveauPaiement = new Paiement(idMembre, nomMembre, montant, datePaiement);
        paiementList.add(nouveauPaiement);

        // Clear fields after adding
        idMembreField.clear();
        nomField.clear();
        montantField.clear();
        datePaiementPicker.setValue(null);
    }

    @FXML
  
private void supprimerPaiement() {
    // Supprimer le paiement sélectionné dans la table
    Paiement selectedPaiement = tablePaiements.getSelectionModel().getSelectedItem();
    if (selectedPaiement != null) {
        // Suppression de l'élément de la liste observable
        paiementList.remove(selectedPaiement);
    } else {
        // Afficher un message d'erreur si aucun paiement n'est sélectionné
        System.out.println("Aucun paiement sélectionné.");
    }
}


  @FXML  
private void rechercherPaiement() {
    // Récupérer l'ID Membre saisi par l'utilisateur
    String idMembre = idMembreField.getText();
    
    // Si l'ID Membre est vide, réinitialiser la table à la liste complète
    if (idMembre.isEmpty()) {
        tablePaiements.setItems(paiementList);  // Afficher toute la liste
        return;
    }

    // Créer une liste filtrée basée sur l'ID Membre
    ObservableList<Paiement> filteredList = FXCollections.observableArrayList();
    for (Paiement paiement : paiementList) {
        // Vérifier si l'ID Membre du paiement correspond à la recherche
        if (String.valueOf(paiement.getIdMembre()).contains(idMembre)) {
            filteredList.add(paiement);
        }
    }

    // Si la liste filtrée est vide, afficher un message de "pas de résultats"
    if (filteredList.isEmpty()) {
        System.out.println("Aucun paiement trouvé pour l'ID Membre: " + idMembre);
        // Optionnellement, vous pouvez afficher un message à l'utilisateur
        // Par exemple, en utilisant un Label pour afficher "Aucun paiement trouvé"
    }

    // Mettre à jour la table avec la liste filtrée
    tablePaiements.setItems(filteredList);
}


}

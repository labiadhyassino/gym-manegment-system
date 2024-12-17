package Controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button deconnecter;

    @FXML
    private Button tableauDeBord;

    @FXML
    private Button gestionDesMembres;

    @FXML
    private Button gestionDesSalles;

    @FXML
    private Button paiements;

    @FXML
    private Button rapports;

    @FXML
    private Button parametres;
    
     @FXML
    private Button personnels;
    
    

    @FXML
    private void deconnecter() throws IOException {
        loadPage("../View/Login.fxml", deconnecter);
    }

    @FXML
    private void navigateToTableauDeBord() throws IOException {
      //  loadPage("../View/TableauDeBord.fxml", tableauDeBord);
    }

    @FXML
    private void navigateToGestionDesMembres() throws IOException {
        loadPage("../View/GestionMembre.fxml", gestionDesMembres);
    }

    @FXML
    private void navigateToGestionDesSalles() throws IOException {
     
        loadPage("../View/GestionSalle.fxml", gestionDesSalles);
    }

    @FXML
    private void navigateToPaiements() throws IOException {
        loadPage("../View/Paiement.fxml", paiements);
    }

    @FXML
    private void navigateToRapports() throws IOException {
       loadPage("../View/Rapport.fxml", rapports);
    }

    @FXML
    private void navigateToParametres() throws IOException {
        loadPage("../View/Parametres.fxml", parametres);
    }
    
    @FXML
    private void navigateToPersonnel() throws IOException {
        loadPage("../View/Personnels.fxml",personnels);
    }
   

    private void loadPage(String fxmlPath, Button button) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent newPage = loader.load();
        Stage currentStage = (Stage) button.getScene().getWindow();
        currentStage.setScene(new Scene(newPage));
    }

    @FXML
    public void initialize() {
        // Initialization code if needed
    }
}

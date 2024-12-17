package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;
import javafx.scene.control.Button;

public class RapportController {

    @FXML
    private ListView<String> membersListView;

    @FXML
    private PieChart caloriesPieChart;

    @FXML
    private Button BackButton;

    // Données des membres et leurs calories brûlées
    private final ObservableList<String> membersList = FXCollections.observableArrayList(
            "Eya Boudidah", "Yassine Labiadh", "Ali Ben Salem", "Sarah Aloui"
    );

    // Données fictives pour les calories
    private final ObservableList<PieChart.Data> caloriesData = FXCollections.observableArrayList();

    public void initialize() {
        // Ajouter les membres à la ListView
        membersListView.setItems(membersList);

        // Configurer l'événement de clic sur un membre
        membersListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                displayCalories(newValue);
            }
        });
    }

    private void displayCalories(String member) {
        // Mettre à jour les données du graphique en fonction du membre sélectionné
        caloriesData.clear();

        switch (member) {
            case "Jean Dupont":
                caloriesData.addAll(
                        new PieChart.Data("Course", 300),
                        new PieChart.Data("Natation", 200),
                        new PieChart.Data("Musculation", 100)
                );
                break;
            case "Marie Dubois":
                caloriesData.addAll(
                        new PieChart.Data("Yoga", 150),
                        new PieChart.Data("Cyclisme", 300),
                        new PieChart.Data("Danse", 250)
                );
                break;
            case "Ali Ben Salem":
                caloriesData.addAll(
                        new PieChart.Data("Football", 500),
                        new PieChart.Data("Basketball", 200),
                        new PieChart.Data("Tennis", 150)
                );
                break;
            case "Sarah Aloui":
                caloriesData.addAll(
                        new PieChart.Data("Zumba", 400),
                        new PieChart.Data("Marche", 100),
                        new PieChart.Data("Fitness", 300)
                );
                break;
            default:
                caloriesData.addAll(
                        new PieChart.Data("Aucune donnée", 1)
                );
        }

        // Appliquer les données au graphique
        caloriesPieChart.setData(caloriesData);
        caloriesPieChart.setTitle("Calories Brûlées par " + member);
    }

    @FXML
    private void BackAction() throws IOException {
        // Retour au menu principal
        Stage stage = (Stage) BackButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Home.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }

    // Méthode utilitaire pour afficher une alerte
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

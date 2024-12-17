package Controller;

import Model.gestion_membre.Membre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;


public class ConnexionDatabase {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Modifie selon ton environnement
    private static final String USER = "gym_system";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void ajouterMembre(Membre membre) {
        String query = "INSERT INTO membre (id, nom, prenom, abonnement, telephone) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, membre.getId());
            statement.setString(2, membre.getNom());
            statement.setString(3, membre.getPrenom());
            statement.setString(4, membre.getAbonnement());
            statement.setString(5, membre.getTelephone());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Un membre a été ajouté avec succès !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package Test;

import Controller.ConnexionDatabase;
import java.sql.Connection;
import java.sql.Statement;

public class Dbtest {

    public static void main(String[] args) {
        try {
            // Test de connexion
            Connection connection = ConnexionDatabase.getConnection();
            if (connection != null) {
                System.out.println("Connexion réussie à la base de données !");
                
                // Créer une table de test
                creerTableTest(connection);
                
                connection.close();
            } else {
                System.out.println("Échec de la connexion à la base de données.");
            }
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la connexion : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void creerTableTest(Connection connection) {
        String query = "CREATE TABLE test_table (" +
                       "id INT PRIMARY KEY, " +
                       "nom VARCHAR(50), " +
                       "prenom VARCHAR(50), " +
                       "email VARCHAR(100))";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("La table 'test_table' a été créée avec succès.");
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création de la table : " + e.getMessage());
            e.printStackTrace();
        }
    }
}

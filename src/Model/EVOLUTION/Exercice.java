package Model.EVOLUTION;
import java.util.ArrayList;

public record Exercice(
        int idExercice,
        String nom,
        String description,
        String groupeMusculaireCible,
        ArrayList<String> materielsNecessaires
) {
    // Constructeur avec validation
    public Exercice {
        if (idExercice <= 0) {
            throw new IllegalArgumentException("L'identifiant de l'exercice doit être positif.");
        }
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide.");
        }
        if (materielsNecessaires == null) {
            materielsNecessaires = new ArrayList<>(); // Assure une liste non nulle
        }
    }

    // Rendre la liste des matériels immuable
    public ArrayList<String> materielsNecessaires() {
        return new ArrayList<>(materielsNecessaires);  // Renvoie une copie de la liste pour éviter la modification
    }

    // Méthode pour vérifier si un matériel est nécessaire
    public boolean estMaterielNecessaire(String materiel) {
        return materielsNecessaires.contains(materiel);
    }

    // Méthode pour ajouter un matériel si non déjà présent
    public void ajouterMateriel(String materiel) {
        if (!materielsNecessaires.contains(materiel)) {
            materielsNecessaires.add(materiel);
        }
    }

    // Méthode pour afficher les informations sur l'exercice
    public void afficherExercice() {
        System.out.println(this);
    }

    // Surcharge de la méthode toString
    @Override
    public String toString() {
        return String.format(
            "Exercice { ID: %d, Nom: '%s', Description: '%s', Groupe Musculaire: '%s', Matériels: %s }",
            idExercice, nom, description, groupeMusculaireCible, materielsNecessaires
        );
    }
}

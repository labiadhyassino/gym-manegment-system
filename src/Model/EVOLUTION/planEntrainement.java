package Model.EVOLUTION;

import java.util.ArrayList;

/**
 * Classe représentant un plan d'entraînement.
 */
public class planEntrainement implements gestionPlan {

    private int idPlan;
    private String nomPlan;
    private String description;
    private String niveau;
    private ArrayList<Exercice> exercices;

    // Constructeur
    public planEntrainement(int id, String nom, String desc, String niv) {
        idPlan = id;
        nomPlan = nom;
        description = desc;
        niveau = niv;
        exercices = new ArrayList<>();
    }

    // Ajouter un exercice au plan
    public void ajouterExercice(Exercice e) {
        exercices.add(e);
    }

    // Afficher les exercices
    public void afficherExercices() {
        for (Exercice e : exercices) {
            if (e != null) {
                System.out.println(e);
            } else {
                System.out.println("Exercice nul trouvé !");
            }
        }
    }

    // Afficher les matériels de tous les exercices
    public void afficherMaterielsTousExercices() {
        for (Exercice exercice : exercices) {
            System.out.println("Exercice: " + exercice.nom());
            System.out.println("Matériels nécessaires: " + exercice.materielsNecessaires());
        }
    }

    // Gestion d'une liste temporaire (avec classe anonyme)
    public void gererListeTemporaireAvecClasseAnonyme() {
        // Utilisation d'une classe anonyme pour gérer la liste temporaire
        ArrayList<Exercice> listeTemporaire = new ArrayList<>() {
            {
                add(new Exercice(1, "Squat", "Exercice pour les jambes", "Jambes", new ArrayList<>())) ;
                add(new Exercice(2, "Pompes", "Exercice pour les pectoraux", "Pectoraux", new ArrayList<>())) ;
            }
        };

        // Affichage des matériels de tous les exercices dans la liste temporaire
        System.out.println("\nMatériels de tous les exercices dans la liste temporaire (classe anonyme) :");
        for (Exercice e : listeTemporaire) {
            System.out.println("Exercice: " + e.nom());
            System.out.println("Matériels nécessaires: " + e.materielsNecessaires());
        }
    }

    @Override
    public void ajouterPlan(Object plan) {
        if (plan instanceof planEntrainement) {
            planEntrainement nouveauPlan = (planEntrainement) plan;
            System.out.println("Plan d'entraînement ajouté : " + nouveauPlan.nomPlan);
        } else {
            throw new IllegalArgumentException("Seuls les objets de type planEntrainement sont acceptés.");
        }
    }
}

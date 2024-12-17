package Model.EVOLUTION;

import Model.gestion_membre.Membre;
import java.util.ArrayList;
import java.util.List;


public class SuiviMembre {
    private int idSuivi;
    private Membre membre;
    private double progressPerformance;
    private String objectifAtteint;
    private List<String> objectifsAtteints;
    private List<Exercice> exercicesRecommandes;

    public SuiviMembre(int idSuivi, Membre membre) {
        this.idSuivi = idSuivi;
        this.membre = membre;
        this.objectifsAtteints = new ArrayList<>();
        this.exercicesRecommandes = new ArrayList<>();
    }

    // Générer un rapport d'évolution du membre
    public String genererRapport() {
        return "Rapport du membre: " + membre.getNom() + "\n"
                + "Performance: " + progressPerformance + "\n"
                + "Objectifs atteints: " + objectifsAtteints + "\n"
                + "Exercices recommandés: " + exercicesRecommandes;
    }

    // Analyser l'écart de calories par rapport au plan nutritionnel
    public void analyserEcartCalories(PlanNutritionnel plan, int caloriesConsommees) {
        int ecart = (int) (plan.getCaloriesTotales() - caloriesConsommees);
        if (ecart > 0) {
            System.out.println("Attention : Vous consommez moins de calories que prévu.");
        } else if (ecart < 0) {
            System.out.println("Attention : Vous consommez plus de calories que prévu.");
        } else {
            System.out.println("Calories consommées conformes au plan.");
        }
    }

    // Ajouter un objectif atteint
    public void ajouterObjectifAtteint(String objectif) {
        if (!objectifsAtteints.contains(objectif)) {
            objectifsAtteints.add(objectif);
            System.out.println("Objectif atteint ajouté : " + objectif);
        } else {
            System.out.println("Cet objectif est déjà enregistré.");
        }
    }

    // Supprimer un objectif atteint
    public void supprimerObjectifAtteint(String objectif) {
        if (objectifsAtteints.contains(objectif)) {
            objectifsAtteints.remove(objectif);
            System.out.println("Objectif supprimé : " + objectif);
        } else {
            System.out.println("Objectif non trouvé.");
        }
    }

    // Ajouter un exercice recommandé
    public void ajouterExerciceRecommande(Exercice exercice) {
        if (!exercicesRecommandes.contains(exercice)) {
            exercicesRecommandes.add(exercice);
            System.out.println("Exercice recommandé ajouté : " + exercice.nom());
        } else {
            System.out.println("Cet exercice est déjà recommandé.");
        }
    }

    // Mettre à jour la performance du membre
    public void mettreAJourPerformance(double performance) {
        progressPerformance = performance;
        System.out.println("Performance mise à jour à : " + performance);
    }

    // Vérifier si un objectif est atteint
    public boolean verifierObjectifAtteint(String objectif) {
        return objectifsAtteints.contains(objectif);
    }

    // Getters et Setters
    public int getIdSuivi() {
        return idSuivi;
    }

    public Membre getMembre() {
        return membre;
    }

    public double getProgressPerformance() {
        return progressPerformance;
    }

    public List<String> getObjectifsAtteints() {
        return objectifsAtteints;
    }

    public List<Exercice> getExercicesRecommandes() {
        return exercicesRecommandes;
    }

    public void setIdSuivi(int idSuivi) {
        this.idSuivi = idSuivi;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public void setProgressPerformance(double progressPerformance) {
        this.progressPerformance = progressPerformance;
    }

    public void setObjectifsAtteints(List<String> objectifsAtteints) {
        this.objectifsAtteints = objectifsAtteints;
    }

    public void setExercicesRecommandes(List<Exercice> exercicesRecommandes) {
        this.exercicesRecommandes = exercicesRecommandes;
    }
}

package Model.EVOLUTION;

public class PlanNutritionnel implements gestionPlan {
    private int id; // Identifiant unique du plan nutritionnel
    private String nomPlan; // Nom du plan
    private float proteines; // Quantité de protéines en grammes
    private float glucides; // Quantité de glucides en grammes
    private float lipides; // Quantité de lipides en grammes
    private float caloriesTotales; // Nombre total de calories
    private float hydration; // Niveau d'hydratation en litres

    // Constructeur
    public PlanNutritionnel(int id, String nomPlan, float proteines, float glucides, float lipides, float caloriesTotales, float hydration) {
        this.id = id;
        this.nomPlan = nomPlan;
        this.proteines = proteines;
        this.glucides = glucides;
        this.lipides = lipides;
        this.caloriesTotales = caloriesTotales;
        this.hydration = hydration;
    }

    // Getters et Setters (inchangés)

    public void modifierCalories(float nouvellesCalories) {
        this.caloriesTotales = nouvellesCalories;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "PlanNutritionnel {" +
                "id=" + id +
                ", nomPlan='" + nomPlan + '\'' +
                ", proteines=" + proteines +
                ", glucides=" + glucides +
                ", lipides=" + lipides +
                ", caloriesTotales=" + caloriesTotales +
                ", hydration=" + hydration +
                '}';
    }

    // Nouvelle méthode : Calcul des macronutriments totaux
    public float calculerMacronutrimentsTotaux() {
        return proteines + glucides + lipides;
    }

    // Nouvelle méthode : Vérification de la cohérence des calories
    public boolean verifierCalories() {
        float caloriesCalculees = (proteines * 4) + (glucides * 4) + (lipides * 9);
        return Math.abs(caloriesCalculees - caloriesTotales) < 0.01; // Tolérance pour les erreurs d'arrondi
    }

    // Nouvelle méthode : Ajuster le plan en fonction d'un objectif
    public void ajusterPlan(String objectif) {
        switch (objectif.toLowerCase()) {
            case "prise de masse":
                proteines += 50;
                glucides += 100;
                lipides += 20;
                caloriesTotales += 600;
                hydration += 0.5;
                break;
            case "perte de poids":
                proteines += 20;
                glucides -= 50;
                lipides -= 10;
                caloriesTotales -= 300;
                hydration += 0.3;
                break;
            case "maintien":
                // Pas de changement significatif
                hydration += 0.2;
                break;
            default:
                throw new IllegalArgumentException("Objectif inconnu : " + objectif);
        }
    }

    // Nouvelle méthode statique : Comparer deux plans nutritionnels
    public static PlanNutritionnel comparerPlans(PlanNutritionnel plan1, PlanNutritionnel plan2) {
        return plan1.caloriesTotales > plan2.caloriesTotales ? plan1 : plan2;
    }

    int getCaloriesTotales() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void ajouterPlan(Object plan) {
        if (plan instanceof PlanNutritionnel nouveauPlan) {
            System.out.println("Plan nutritionnel ajouté : " + nouveauPlan.toString());
        } else {
            throw new IllegalArgumentException("Seuls les objets de type PlanNutritionnel sont acceptés.");
        }
    }
}

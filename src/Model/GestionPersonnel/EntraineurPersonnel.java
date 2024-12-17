package Model.GestionPersonnel;

import java.util.List;

/**
 * Classe EntraineurPersonnel
 */
public class EntraineurPersonnel extends Entraineur {
    private String specialite;
    private float tarifHoraire;

    // Constructeur par défaut
    public EntraineurPersonnel() {
        super(); // Appelle le constructeur de la classe parent (Entraineur)
        this.specialite = "Non spécifiée"; // Valeur par défaut
        this.tarifHoraire = 0.0f; // Valeur par défaut
    }

    // Constructeur paramétré
    public EntraineurPersonnel(String nomPers, String prenomPers, String emailPers, int agePers, String numTelPers, 
                               List<String> certifications, String specialite, float tarifHoraire) {
        super(nomPers, prenomPers, emailPers, agePers, numTelPers, certifications); // Appel du constructeur parent
        this.specialite = specialite;
        this.tarifHoraire = tarifHoraire;
    }

    // Getter pour la spécialité
    public String getSpecialite() {
        return specialite;
    }

    // Setter pour la spécialité
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    // Getter pour le tarif horaire
    public float getTarifHoraire() {
        return tarifHoraire;
    }

    // Setter pour le tarif horaire
    public void setTarifHoraire(float tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    // Méthode pour créer un plan personnalisé pour un client
    public void creerPlanPersonnalise(String objectif, int dureeEnHeures) {
        System.out.println("Création d'un plan personnalisé :");
        System.out.println("Objectif : " + objectif);
        System.out.println("Durée estimée : " + dureeEnHeures + " heures");
        System.out.println("Spécialité de l'entraîneur : " + this.specialite);
        System.out.println("Tarif horaire : " + this.tarifHoraire + "€");
        System.out.println("Coût total estimé : " + (this.tarifHoraire * dureeEnHeures) + "€");
    }

    // Méthode pour vérifier si l'entraîneur est certifié pour un type de spécialité
    public boolean estCertifiePour(String specialite) {
        boolean certifie = getCertifications().toLowerCase().contains(specialite.toLowerCase());
        if (certifie) {
            System.out.println("L'entraîneur est certifié pour : " + specialite);
        } else {
            System.out.println("L'entraîneur n'est pas certifié pour : " + specialite);
        }
        return certifie;
    }

    // Méthode pour afficher le profil de l'entraîneur personnel (inclut la spécialité et le tarif horaire)
    @Override
    public void afficherProfil() {
        super.afficherProfil(); // Appel du profil de la classe parente (Entraineur)
        System.out.println("Spécialité : " + specialite);
        System.out.println("Tarif horaire : " + tarifHoraire + "€");
        System.out.println("================================");
    }
}

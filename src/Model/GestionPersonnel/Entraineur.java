package Model.GestionPersonnel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe Entraineur
 */
public class Entraineur extends Personne {
    private List<String> certifications; // Liste des certifications

    public Entraineur() {
        super();
        this.certifications = new ArrayList<>();
        this.certifications.add("Aucune");
    }

    // Constructeur paramétré
    public Entraineur(String nomPers, String prenomPers, String emailPers, int agePers, String numTelPers, List<String> certifications) {
        super(nomPers, prenomPers, emailPers, agePers, numTelPers);
        this.certifications = new ArrayList<>(certifications); // Copie défensive
    }

    // Getter pour les certifications (renvoie toutes les certifications sous forme de chaîne)
    public String getCertifications() {
        return certifications.stream()
                .collect(Collectors.joining(", "));
    }

    // Ajouter une certification
    public void ajouterCertification(String certification) {
        certifications.add(certification);
        System.out.println("Certification ajoutée : " + certification);
    }

    // Filtrer les certifications par mot-clé
    public List<String> filtrerCertifications(String motCle) {
        return certifications.stream()
                .filter(cert -> cert.contains(motCle))
                .collect(Collectors.toList());
    }

    // Méthode pour vérifier la présence
    public boolean estPresent() {
        System.out.println(getNomPers() + " est présent.");
        return true;
    }

    // Méthode pour afficher le profil de l'entraîneur
    @Override
    public void afficherProfil() {
        super.afficherProfil(); // Appelle la méthode de la classe parent
        System.out.println("Certifications: " + getCertifications());
        System.out.println("================================");
    }

    // Supprimer une certification par mot-clé
    public void supprimerCertificationsParMotCle(String motCle) {
        certifications = certifications.stream()
                .filter(cert -> !cert.contains(motCle)) // Garde les certifications qui ne contiennent pas le mot-clé
                .collect(Collectors.toList());
        System.out.println("Certifications contenant '" + motCle + "' ont été supprimées.");
    }
}

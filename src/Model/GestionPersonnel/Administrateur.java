/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionPersonnel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author pc
 */
public class Administrateur extends Personne{
    private String MotDePasse;
    private String DateCreationCompte;
    private String DerniereConnexion;
        
    // Constructeur par défaut
    public Administrateur() {
        super(); // Appelle le constructeur par défaut de Personne
        this.MotDePasse = "admin123";
        this.DateCreationCompte = getDateActuelle();
        this.DerniereConnexion = "Jamais connecté";
    }

    // Constructeur paramétré
    public Administrateur(String nomPers, String prenomPers, String emailPers, int agePers, String numTelPers, String motDePasse) {
        super(nomPers, prenomPers, emailPers, agePers, numTelPers);
        this.MotDePasse = motDePasse;
        this.DateCreationCompte = getDateActuelle();
        this.DerniereConnexion = "Jamais connecté";
    }

    // Méthode pour changer le mot de passe
    public void ChangerMotDePasse(String nouveauMotDePasse) {
        this.MotDePasse = nouveauMotDePasse;
        System.out.println("Mot de passe modifié avec succès !");
    }

    // Méthode pour notifier un membre
    public void NotifierMembre(String message, String membreEmail) {
        System.out.println("===== Notification =====");
        System.out.println("Destinataire: " + membreEmail);
        System.out.println("Message: " + message);
        System.out.println("Notification envoyée avec succès !");
    }

    // Méthode pour mettre à jour la dernière connexion
    public void mettreAJourConnexion() {
        this.DerniereConnexion = getDateActuelle();
        System.out.println("Dernière connexion mise à jour : " + DerniereConnexion);
    }

    // Méthode pour afficher le profil avec les informations d'administrateur
    @Override
    public void afficherProfil() {
        super.afficherProfil(); // Appelle la méthode de la classe parent
        System.out.println("Mot de passe: ********");
        System.out.println("Date de création du compte: " + DateCreationCompte);
        System.out.println("Dernière connexion: " + DerniereConnexion);
        System.out.println("================================");
    }

    // Méthode utilitaire pour obtenir la date actuelle au format "yyyy-MM-dd HH:mm:ss"
    private String getDateActuelle() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
  

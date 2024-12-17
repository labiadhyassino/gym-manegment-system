/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionSalle;

import java.util.Date;
/**
 *
 * @author pc
 */
public class SalleFiliale {
    private String nomSalle;
    private String adresse;
    private String typeActivite;
    private String horaireOuverture;
    private String horaireFermeture;
    
    // Constructeur pour une salle filiale
    public SalleFiliale(String nomSalle, String adresse, String typeActivite, String horaireOuverture, String horaireFermeture) {
        this.nomSalle = nomSalle;
        this.adresse = adresse;
        this.typeActivite = typeActivite;
        this.horaireOuverture = horaireOuverture;
        this.horaireFermeture = horaireFermeture;
    }

    // Getter et Setter pour les attributs
    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    public String getHoraireOuverture() {
        return horaireOuverture;
    }

    public void setHoraireOuverture(String horaireOuverture) {
        this.horaireOuverture = horaireOuverture;
    }

    public String getHoraireFermeture() {
        return horaireFermeture;
    }

    public void setHoraireFermeture(String horaireFermeture) {
        this.horaireFermeture = horaireFermeture;
    }

    // Afficher les détails de la salle
    public void afficherDetails() {
        System.out.println("Nom de la salle : " + nomSalle);
        System.out.println("Adresse : " + adresse);
        System.out.println("Type d'activité : " + typeActivite);
        System.out.println("Horaire d'ouverture : " + horaireOuverture);
        System.out.println("Horaire de fermeture : " + horaireFermeture);
    }
    public boolean verifierDisponibilite(Date date) throws SalleNonDisponibleException {
    if (!estDisponible(date)) {
        throw new SalleNonDisponibleException("La salle " + nomSalle + " n'est pas disponible à la date spécifiée : " + date);
    }
    return true;
}

    // Vérifier la disponibilité de la salle à une date spécifique
    public boolean estDisponible(Date date) {
        // Logique basique pour la disponibilité (cela pourrait être amélioré en fonction des besoins)
        return true; // Par défaut, considérons la salle comme disponible
    }

    // Historique d'entretien de la salle
    public void historiqueEntretien() {
        // Logique à définir pour afficher ou gérer l'historique des entretiens
        System.out.println("Historique d'entretien de " + nomSalle);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionSalle;

/**
 *
 * @author pc
 */
public class Materiel {
    private String Reference;
    private String Type;
    private Float Prix;
    private boolean Etat; // L'état devient un booléen
    private String NomM;
    private int Quantite;
    private String Emplacement;
    
    // Constructeur par défaut
    public Materiel() {}

    // Getter et Setter pour les attributs
    public void ajouterQuantite(int Quantite) {
        this.Quantite = Quantite;
    }

    public void mettreAJourEtat(boolean Etat) {  // Mise à jour avec un booléen
        this.Etat = Etat;
    }

    public boolean estDisponible() {  // Vérification de la disponibilité avec un booléen
        return Etat;  // Si etat est true, c'est disponible
    }

    public String afficherEmplacement() {
        return Emplacement;
    }

    // Getter et Setter pour le nom du matériel
    public String getNomM() {
        return NomM;
    }

    public void setNomM(String nomM) {
        this.NomM = nomM;
    }

    // Afficher les informations du matériel (exemple)
    public void afficherMateriel() {
        System.out.println("Nom : " + NomM);
        System.out.println("Référence : " + Reference);
        System.out.println("Type : " + Type);
        System.out.println("Prix : " + Prix);
        System.out.println("Quantité : " + Quantite);
        System.out.println("Emplacement : " + Emplacement);
        System.out.println("Disponible : " + (Etat ? "Oui" : "Non"));
    }
}

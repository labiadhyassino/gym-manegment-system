/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionSalle;

/**
 *
 * @author pc
 */
public class Produit {
    private double idProduit;
    private String description;
    private int prix;
    private int quantiteDisponible;
    private String dateExpiration;  // La date d'expiration du produit au format "yyyy-mm-dd"
    
    // Constructeur par défaut
    public Produit() {}
    
    // Constructeur paramétré pour initialiser un produit
    public Produit(double idProduit, String description, int prix, int quantiteDisponible, String dateExpiration) {
        this.idProduit = idProduit;
        this.description = description;
        this.prix = prix;
        this.quantiteDisponible = quantiteDisponible;
        this.dateExpiration = dateExpiration;
    }

    // Getter et Setter pour les attributs
    public double getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(double idProduit) {
        this.idProduit = idProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    // Méthode pour afficher les détails du produit
    public void afficherDétails() {
        System.out.println("ID Produit: " + idProduit);
        System.out.println("Description: " + description);
        System.out.println("Prix: " + prix + "€");
        System.out.println("Quantité disponible: " + quantiteDisponible);
        System.out.println("Date d'expiration: " + dateExpiration);
    }

    // Méthode pour mettre à jour la quantité disponible
    public void mettreAJourStock(int nouvelleQuantité) {
        if (nouvelleQuantité >= 0) {
            this.quantiteDisponible = nouvelleQuantité;
            System.out.println("Quantité mise à jour: " + quantiteDisponible);
        } else {
            System.out.println("Quantité invalide !");
        }
    }

    // Méthode pour calculer la valeur nutritionnelle (peut être personnalisée)
    public int calculerValeurNutritionnelle() {
        // Exemple simple, peut être remplacé par une logique plus complexe
        // Ici, on suppose que chaque produit a une valeur nutritionnelle par défaut de 5
        return 5;
    }

    // Méthode pour vérifier l'expiration du produit
    public boolean verifierExpiration() {
        // Logique pour vérifier si la date d'expiration est passée
        // Ici, on suppose que la dateExpiration est au format "yyyy-mm-dd"
        String currentDate = "2024-11-24"; // Exemple de date actuelle (vous pouvez utiliser un DateFormat réel)
        return currentDate.compareTo(dateExpiration) > 0;  // Si la date actuelle est après la date d'expiration, le produit est expiré
    }

    // Méthode pour afficher la disponibilité du produit
    public void afficherDisponibilité() {
        if (quantiteDisponible > 0) {
            System.out.println("Produit disponible en stock.");
        } else {
            System.out.println("Produit en rupture de stock.");
        }
    }

    // Méthode pour afficher la valeur nutritionnelle (en ajoutant l'interface que vous mentionnez)
    public void afficherValeurNutritionnelle() {
        System.out.println("Valeur nutritionnelle du produit: " + calculerValeurNutritionnelle() + " unités.");
    }
}

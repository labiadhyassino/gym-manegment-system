package Model.gestion_membre;

import java.util.List;

public class Membre {
    private String id;
    private String nom;
    private String prenom;
    private String abonnement;
    private String telephone;

    // Constructeur
    public Membre(String id, String nom, String prenom, String abonnement, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.abonnement = abonnement;
        this.telephone = telephone;
    }

    // Constructeur
    
    // Getter et Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
   
    // Getter pour id
    public String getId() {
        return id;
    }

    // Setter pour id
    public void setId(String id) {
        this.id = id;
    }

    // Getter pour prenom
    public String getPrenom() {
        return prenom;
    }

    // Setter pour prenom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

  
   

    // Getter pour telephone
    public String getTelephone() {
        return telephone;
    }

    // Setter pour telephone
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setAbonnement (String abonnement) {
        this.abonnement = abonnement ; 
    }
    public String getAbonnement() {
        return abonnement;
    } 
    // Pas de getter et setter pour 'nom' comme demandé


  
   
    // Méthode pour ajouter un abonnement
   
    }

    


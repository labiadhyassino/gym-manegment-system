package Model.gestion_membre;

public sealed class Abonnement permits AbonnementPremium , AbonnementStandard {
    private int idAbonnement;
    private String typeAbonnement;
    private String status;
    private int prix;
    private Membre membre;
    private DateAbonnement dateAbonnement;

    // Constructeur
    public Abonnement(int idAbonnement, String typeAbonnement, String status, int prix, Membre membre ,DateAbonnement dateAbonnement) throws IllegalArgumentException {
        if (prix <= 0) {
            throw new IllegalArgumentException("Le prix doit être un nombre positif.");
        }
        this.idAbonnement = idAbonnement;
        this.typeAbonnement = typeAbonnement;
        this.status = status;
        this.prix = prix;
        this.membre = membre;
        this.dateAbonnement = dateAbonnement;
    }

    // Méthodes communes
    public void renouvelerAbonnement() {
        this.status = "Actif";
        System.out.println("Abonnement renouvelé.");
    }

    public void annulerAbonnement() {
        this.status = "Annulé";
        System.out.println("Abonnement annulé.");
    }

    public boolean estActif() {
        return "Actif".equals(this.status);
    }

    public String obtenirStatutAbonnement() {
        return this.status;
    }

    public int getPrix() {
        return prix;
    }

    public Membre getMembre() {
        return membre;
    }
     public DateAbonnement getDateAbonnement() {
        return dateAbonnement;
    }
    public void setDateAbonnement(DateAbonnement dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }

    // Getters et Setters
    public void setPrix(int prix) {
        this.prix = prix;
    }
}

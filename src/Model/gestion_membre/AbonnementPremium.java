package Model.gestion_membre;
 
public  final class AbonnementPremium extends Abonnement {

   public AbonnementPremium(int idAbonnement, int prix, Membre membre, DateAbonnement dateAbonnement) {
        super(idAbonnement, "VIP", "Actif", prix, membre, dateAbonnement);
    }

    // Ajout de comportements spécifiques pour l'abonnement VP (par exemple, des avantages supplémentaires)
    public void offrirAvantage() {
        System.out.println("Avantage VIP offert : Accès à des contenus exclusifs !");
    }

    @Override
    public void renouvelerAbonnement() {
        // Exemple d'un comportement spécifique pour renouveler un abonnement VP
        System.out.println("Renouvellement VIP effectué avec des avantages exclusifs.");
        super.renouvelerAbonnement();
    }
}
 
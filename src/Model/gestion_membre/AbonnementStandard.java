package Model.gestion_membre;

public final class AbonnementStandard extends Abonnement {

    public AbonnementStandard(int idAbonnement, int prix, Membre membre, DateAbonnement dateAbonnement) {
        super(idAbonnement, "Normal", "Actif", prix, membre, dateAbonnement);
    }

    // Ajout de comportements spécifiques pour l'abonnement normal
    public void appliquerReduction() {
        int prixApresReduction = getPrix() - 5; // Exemple de réduction de 5 unités
        setPrix(prixApresReduction);
        System.out.println("Réduction appliquée à l'abonnement normal. Nouveau prix : " + prixApresReduction);
    }
}

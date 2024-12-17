package Model.gestion_membre;

import java.time.LocalDate;

public class DateAbonnement {
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // Constructeur
    public DateAbonnement(LocalDate dateDebut, LocalDate dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getter et Setter
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    // Méthode pour vérifier si l'abonnement est encore valide
    public boolean estValide() {
        return LocalDate.now().isBefore(dateFin) || LocalDate.now().isEqual(dateFin);
    }

    // Méthode pour afficher la durée de l'abonnement
    public String afficherDuree() {
        return "Abonnement du " + dateDebut + " au " + dateFin;
    }
}

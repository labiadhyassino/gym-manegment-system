package Model;

import javafx.beans.property.*;

public class Paiement {

    private final IntegerProperty idPaiement;
    private final IntegerProperty idMembre;
    private final StringProperty nomMembre;
    private final DoubleProperty montant;
    private final StringProperty datePaiement;

    public Paiement(int idMembre, String nomMembre, double montant, String datePaiement) {
        this.idPaiement = new SimpleIntegerProperty(idMembre);
        this.idMembre = new SimpleIntegerProperty(idMembre);
        this.nomMembre = new SimpleStringProperty(nomMembre);
        this.montant = new SimpleDoubleProperty(montant);
        this.datePaiement = new SimpleStringProperty(datePaiement);
    }

    public IntegerProperty idPaiementProperty() {
        return idPaiement;
    }

    public IntegerProperty idMembreProperty() {
        return idMembre;
    }

    public StringProperty nomMembreProperty() {
        return nomMembre;
    }

    public DoubleProperty montantProperty() {
        return montant;
    }

    public StringProperty datePaiementProperty() {
        return datePaiement;
    }

    public int getIdMembre() {
        return idMembre.get();
    }

    public String getNomMembre() {
        return nomMembre.get();
    }

    public double getMontant() {
        return montant.get();
    }

    public String getDatePaiement() {
        return datePaiement.get();
    }
}

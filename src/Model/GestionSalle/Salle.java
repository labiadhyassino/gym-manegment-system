package Model;

public class Salle {

    private String nomSalle;
    private int capacite;
    private String statut;
    private String activite;

    public Salle(String nomSalle, int capacite, String statut, String activite) {
        this.nomSalle = nomSalle;
        this.capacite = capacite;
        this.statut = statut;
        this.activite = activite;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }
}

package Model.GestionPersonnel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personnel {
    private final StringProperty nom;
    private final StringProperty role;
    private final StringProperty email;
    private final StringProperty telephone;

    public Personnel(String nom, String role, String email, String telephone) {
        this.nom = new SimpleStringProperty(nom);
        this.role = new SimpleStringProperty(role);
        this.email = new SimpleStringProperty(email);
        this.telephone = new SimpleStringProperty(telephone);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public String getTelephone() {
        return telephone.get();
    }
}

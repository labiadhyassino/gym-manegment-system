/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.GestionPersonnel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author pc
 */
public abstract class Personne {
    protected String NomPers;
    protected String PrenomPers;
    protected String EmailPers;
    protected int AgePers;
    protected String NumTelPers;
    
    public Personne() {
        this.NomPers = "Inconnu";
        this.PrenomPers = "Inconnu";
        this.EmailPers = "inconnu@email.com";
        this.AgePers = 0;
        this.NumTelPers = "0000000000";
    }
    public Personne(String nomPers, String prenomPers, String emailPers, int agePers, String numTelPers) {
        this.NomPers = nomPers;
        this.PrenomPers = prenomPers;
        this.EmailPers = emailPers;
        this.AgePers = agePers;
        this.NumTelPers = numTelPers;
    }
    public void ConsulterProfil(String fileName) {
        System.out.println("===== Consulter le Profil =====");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erreur : Impossible de lire le fichier. " + e.getMessage());
        }
        System.out.println("================================");
    }
    public void afficherProfil() {
        System.out.println("===== Affichage du Profil =====");
        System.out.println("Nom: " + NomPers);
        System.out.println("Prénom: " + PrenomPers);
        System.out.println("Email: " + EmailPers);
        System.out.println("Âge: " + AgePers);
        System.out.println("Numéro de téléphone: " + NumTelPers);
        System.out.println("================================");
    }
    public void modifierProfil(String nom, String prenom, String email, int age, String numTel, String fileName) {
        System.out.println("===== Modification du Profil =====");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
          // Met à jour les champs
          this.NomPers = nom;
          this.PrenomPers = prenom;
          this.EmailPers = email;
          this.AgePers = age;
          this.NumTelPers = numTel;

           // Écrit dans le fichier
           bw.write("Nom: " + NomPers);
           bw.newLine();
           bw.write("Prénom: " + PrenomPers);
           bw.newLine();
           bw.write("Email: " + EmailPers);
           bw.newLine();
           bw.write("Âge: " + AgePers);
           bw.newLine();
           bw.write("Numéro de téléphone: " + NumTelPers);
           bw.newLine();

           System.out.println("Profil mis à jour avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur : Impossible d'écrire dans le fichier. " + e.getMessage());
        }
        System.out.println("================================");
    }
    
    public String getNomPers() {
        return NomPers;
    }

    public void setNomPers(String nomPers) {
        this.NomPers = nomPers;
    }

    public String getPrenomPers() {
        return PrenomPers;
    }

    public void setPrenomPers(String prenomPers) {
        this.PrenomPers = prenomPers;
    }

    public String getEmailPers() {
        return EmailPers;
    }

    public void setEmailPers(String emailPers) {
        this.EmailPers = emailPers;
    }

    public int getAgePers() {
        return AgePers;
    }

    public void setAgePers(int agePers) {
        this.AgePers = agePers;
    }

    public String getNumTelPers() {
        return NumTelPers;
    }

    public void setNumTelPers(String numTelPers) {
        this.NumTelPers = numTelPers;
    }
}

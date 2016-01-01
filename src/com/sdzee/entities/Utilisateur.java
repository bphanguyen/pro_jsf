package com.sdzee.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table( name = "Utilisateur" )
public class Utilisateur {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long      id;

    @Column( name = "email" )
    @NotNull
    @Pattern( regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)",
    message = "Merci de saisir une adresse mail valide" )
    private String    email;

    @Column( name = "mot_de_passe" )
    @NotNull
    @Size( min = 3, message = "Le mot de passe doit contenir au moins 3 caractères" )
    private String    motDePasse;

    @Column( name = "nom" )
    @NotNull
    @Size( min = 3, message = "Le nom d'utilisateur doit contenir au moins 3 caractères" )
    private String    nom;

    @Column( name = "date_inscription" )
    private Timestamp dateInscription;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription( Timestamp dateInscription ) {
        this.dateInscription = dateInscription;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
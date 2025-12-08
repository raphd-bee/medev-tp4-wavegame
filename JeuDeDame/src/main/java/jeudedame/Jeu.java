/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeudedame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author michel
 */
public class Jeu implements Serializable {
    
    // --- AJOUT : Le jeu doit contenir le plateau ! ---
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;

    public Jeu() {
        // Initialisation du plateau et des joueurs par défaut
        this.plateau = new Plateau();
        this.joueur1 = new Joueur("Joueur 1", false); // Blanc
        this.joueur2 = new Joueur("Joueur 2", true);  // Noir
    }
    
    // Getter pour accéder au plateau depuis le Main
    public Plateau getPlateau() {
        return plateau;
    }
    // ------------------------------------------------

    public void sauvegarder(String nomFichier) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            out.writeObject(this);
            System.out.println(">> Partie sauvegardée avec succès : " + nomFichier);
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde : " + e.getMessage());
        }
    }

    public static Jeu charger(String nomFichier) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomFichier))) {
            return (Jeu) in.readObject();
        } catch (Exception e) {
            System.out.println("Erreur chargement : " + e.getMessage());
            return null;
        }
    }
}
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

/**
 *
 * @author michel
 */
public class Jeu {
    public void sauvegarder(String nomFichier) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            out.writeObject(this);
            System.out.println("Partie sauvegardée : " + nomFichier);
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

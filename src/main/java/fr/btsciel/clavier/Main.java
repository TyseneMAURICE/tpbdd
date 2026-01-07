package fr.btsciel.clavier;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            GestionDesVe gestionVe = new GestionDesVe();
            System.out.println("""
                    0-Quitter
                    1-Afficher la liste de voitures
                    2-Trier la liste de voitures par ordre croissant de la marque 
                    3-Trier la liste de voitures par ordre décroissant de la marque
                    4-Trier la liste de voitures par ordre croissant du nombre d'exemplaies vendus
                    5-Trier la liste de voitures par ordre décroissant du nombre d'exemplairees vendus 
                    6-Trier la liste de voitures par ordre croissant du modele 
                    7-Trier la liste de voitures par ordre décroissant du modele
                    8-Ajouter une voiture 
                    9-Supprimer uen voiture"""); //TODO 8 et 9
            boolean flag = false;
            int choix = In.readInteger();
            boolean continuer = true;
            while (continuer) {
                switch (choix) {
                    case 0:
                        continuer = false;
                        break;
                    case 1:
                        gestionVe.afficherVoitures();
                        flag = true;
                        break;
                    case 2:
                        gestionVe.trierCroissantMarque();
                        flag = true;
                        break;
                    case 3:
                        gestionVe.trierDecroissantMarque();
                        flag = true;
                        break;
                    case 4:
                        gestionVe.trierCroissantVente();
                        flag = true;
                        break;
                    case 5:
                        gestionVe.trierDecroissantVente();
                        flag = true;
                        break;
                    case 6:
                        gestionVe.trierCroissantModele();
                        flag = true;
                        break;
                    case 7:
                        gestionVe.trierDecroissantModele();
                        flag = true;
                        break;
                }
            }
            if (flag) {
                for (int i = 0; i < gestionVe.getVoiture().size(); i++) {
                    System.out.println(
                            +gestionVe.getVoiture().get(i).getId() + " "
                                    + gestionVe.getVoiture().get(i).getMarque() + " "
                                    + gestionVe.getVoiture().get(i).getModele() + " "
                                    + gestionVe.getVoiture().get(i).getNb_vente());
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
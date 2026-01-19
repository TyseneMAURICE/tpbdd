package fr.btsciel.clavier;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            GestionDesVe gestionVe = new GestionDesVe();
            boolean continuer = true;
            boolean flag = false;
            while (continuer) {
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
                    9-Supprimer uen voiture""");
            int choix = In.readInteger();



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
                        break;
                    case 3:
                        gestionVe.trierDecroissantMarque();
                        break;
                    case 4:
                        gestionVe.trierCroissantVente();
                        break;
                    case 5:
                        gestionVe.trierDecroissantVente();
                        break;
                    case 6:
                        gestionVe.trierCroissantModele();
                        break;
                    case 7:
                        gestionVe.trierDecroissantModele();
                        break;
                    case 8 :
                        System.out.println("Saisir le modèle de la voiture :");
                        String modele = In.readString();
                        System.out.println("Saisir la marque de la voiture :");
                        String marque = In.readString();
                        System.out.println("Saisir le nombre de vente de cette voiture :");
                        int vente = In.readInteger();
                        gestionVe.ajouterVoiture(modele, marque, vente);
                        break;
                    case 9 :
                        int index = 1;
                        for (Voitures v : gestionVe.getVoiture()) {
                            System.out.println(index + " - "
                                    + v.getId() + " "
                                    + v.getMarque() + " "
                                    + v.getModele() + " "
                                    + v.getNb_vente());
                            index++;
                        }
                        System.out.println("Saisir le numéro de la voiture que vous voulez supprimée :");
                        int numero = In.readInteger();
                        gestionVe.supprimerVoiture(numero);
                        break;
                }
            }

            if(flag) {
                int index = 1;
                for (Voitures v : gestionVe.getVoiture()) {
                    System.out.println(index + " - "
                            + v.getId() + " "
                            + v.getMarque() + " "
                            + v.getModele() + " "
                            + v.getNb_vente());
                    index++;
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
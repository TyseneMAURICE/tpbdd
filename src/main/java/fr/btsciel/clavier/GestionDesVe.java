package fr.btsciel.clavier;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionDesVe {
    private ArrayList<Voitures> voiture = new ArrayList();
    private Connection connexion = null;

    public GestionDesVe() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/voiture_electrique", "root", "root");

    }


    public void setVoiture(ArrayList<Voitures> voiture) {
        this.voiture = voiture;
    }

    public void afficherVoitures() throws SQLException {
        voiture.clear();
        PreparedStatement pst = connexion.prepareStatement("select * from voitures");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"),rs.getString("marque"),rs.getString("modele"),rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public ArrayList<Voitures> getVoiture() throws SQLException, ClassNotFoundException {
        return voiture;
    }

    public void trierCroissantMarque() throws SQLException {
        voiture.clear();
        PreparedStatement pst = connexion.prepareStatement("select * from id order by marque asc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"),rs.getString("marque"),rs.getString("modele"),rs.getInt("nb_vente")));
            voiture.add(v);
        }

    }

    public void trierDecroissantMarque() throws SQLException {
        voiture.clear();
        PreparedStatement pst = connexion.prepareStatement("select * from id order by marque desc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"),rs.getString("marque"),rs.getString("modele"),rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public void trierCroissantVente() throws SQLException {
        voiture.clear();
        PreparedStatement pst = connexion.prepareStatement("select * from id order by nb_vente asc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"),rs.getString("marque"),rs.getString("modele"),rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public void trierDecroissantVente() throws SQLException {
        voiture.clear();
        PreparedStatement pst = connexion.prepareStatement("select * from id order by nb_vente desc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"), rs.getString("marque"), rs.getString("modele"), rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public void trierCroissantModele() throws SQLException {
        voiture.clear();
        PreparedStatement pst = connexion.prepareStatement("select * from id order by modele asc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"), rs.getString("marque"), rs.getString("modele"), rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public void trierDecroissantModele() throws SQLException {
        voiture.clear();
        PreparedStatement pst = connexion.prepareStatement("select * from id order by nb_vente desc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"), rs.getString("marque"), rs.getString("modele"), rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public void ajouterVoiture(String marque, String modele, int nbVente) throws SQLException {
        voiture.clear();
        PreparedStatement ps = connexion.prepareStatement("INSERT INTO voitures (id, marque, modele, ventes) VALUES (NULL, ?, ?, ?)");

        ps.setString(1, marque);
        ps.setString(2, modele);
        ps.setInt(3, nbVente);

        if (ps.executeUpdate() != 0) {
            System.out.println("Voiture ajoutéé !");
        } else {
            System.out.println("Impossible d'ajouter la voiture");
        }
    }

    public void supprimerVoiture(int id) throws SQLException {
        voiture.clear();
        PreparedStatement ps = connexion.prepareStatement("DELETE FROM voitures WHERE id = ?");
        ps.setInt(1, id);
        if (ps.executeUpdate() != 0) {
            System.out.println("La voiture a été suprimmée");
        } else {
            System.out.println("Impossible de supprimer la voiture");
        }
    }

}

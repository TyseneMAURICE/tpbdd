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
        PreparedStatement pst = connexion.prepareStatement("select * from id");
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
        PreparedStatement pst = connexion.prepareStatement("select * from id order by marque asc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"),rs.getString("marque"),rs.getString("modele"),rs.getInt("nb_vente")));
            voiture.add(v);
        }

    }

    public void trierDecroissantMarque() throws SQLException {
        PreparedStatement pst = connexion.prepareStatement("select * from id order by marque desc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"),rs.getString("marque"),rs.getString("modele"),rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public void trierCroissantVente() throws SQLException {
        PreparedStatement pst = connexion.prepareStatement("select * from id order by nb_vente asc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"),rs.getString("marque"),rs.getString("modele"),rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public void trierDecroissantVente() throws SQLException {
        PreparedStatement pst = connexion.prepareStatement("select * from id order by nb_vente desc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"), rs.getString("marque"), rs.getString("modele"), rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public void trierCroissantModele() throws SQLException {
        PreparedStatement pst = connexion.prepareStatement("select * from id order by modele asc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"), rs.getString("marque"), rs.getString("modele"), rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }

    public void trierDecroissantModele() throws SQLException {
        PreparedStatement pst = connexion.prepareStatement("select * from id order by nb_vente desc");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Voitures v = (new Voitures(rs.getInt("id"), rs.getString("marque"), rs.getString("modele"), rs.getInt("nb_vente")));
            voiture.add(v);
        }
    }
}

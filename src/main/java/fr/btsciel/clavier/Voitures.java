package fr.btsciel.clavier;

public class Voitures {
    int id;
    String marque;
    String modele;
    int nb_vente;

    public Voitures(int id, String marque, String modele, int nb_vente) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.nb_vente = nb_vente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getNb_vente() {
        return nb_vente;
    }

    public void setNb_vente(int nb_vente) {
        this.nb_vente = nb_vente;
    }
}

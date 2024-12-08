import java.io.Serializable;

public class Produit implements Serializable {
    public String nom;
    private String marque;
    private double prix;
    private String description;
    private int stock;

    public Produit(String nom, String marque, double prix, String description, int stock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nombreEnStock=" + stock +
                '}';
    }
}


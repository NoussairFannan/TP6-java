import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MetierProduitImpl implements IMetier<Produit>{
    public List<Produit> produits;
    public String fileName;

    public MetierProduitImpl(String fileName) {
        this.fileName = fileName;
        loadObjectsFile();
    }

    @Override
    public Produit add(Produit o) {
        produits.add(o);
        return o;
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findByNom(String nom) {
        return produits.get(produits.stream().map(s->s.nom).toList().indexOf(nom));
    }

    @Override
    public void delete(String nom) {
        produits.remove(produits.stream().map(s->s.nom).toList().indexOf(nom));

    }

    @Override
    public void saveAll() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(produits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadObjectsFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            produits = (List<Produit>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            produits = new ArrayList<>();
        }
    }
}

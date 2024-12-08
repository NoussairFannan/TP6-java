import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MetierProduitImpl implements IMetier<Produit>{
    public ArrayList<Produit> produits;
    public String fileName;

    public MetierProduitImpl(String fileName) {
        this.produits = produits;
        this.fileName = fileName;
    }

    @Override
    public void add(Produit o) {
        produits.add(o);
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

    }
}

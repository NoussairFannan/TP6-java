import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client>{
    public ArrayList<Client> clients;
    public String fileName;

    public MetierClientImpl(String fileName) {
        this.clients = clients;
        this.fileName = fileName;
    }

    @Override
    public void add(Client o) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return List.of();
    }

    @Override
    public Client findByNom(String nom) {
        return null;
    }

    @Override
    public void delete(String nom) {

    }

    @Override
    public void saveAll() {

    }
}

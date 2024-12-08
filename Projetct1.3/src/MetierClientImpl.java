import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client>{
    public List<Client> clients;
    public String fileName;

    public MetierClientImpl(String fileName) {
        this.clients = clients;
        this.fileName = fileName;
    }

    @Override
    public Client add(Client o) {
        clients.add(o);
        return o;
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public Client findByNom(String nom) {
        return clients.get(clients.stream().map(s->s.nom).toList().indexOf(nom));
    }

    @Override
    public void delete(String nom) {
        clients.remove(clients.stream().map(s->s.nom).toList().indexOf(nom));
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadObjectsFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            clients = (List<Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            clients = new ArrayList<>();
        }
    }
}

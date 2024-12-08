import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class DossierContact {
    private Map<String, String> contactNum;

    public DossierContact(Map<String, String> contactNum) {
        this.contactNum = contactNum;
    }

    public void AjouterContact(String nom, String num) {
        contactNum.put(nom, num);
    }

    public void SupprimerContact(String nom) {
        contactNum.remove(nom);
    }

    public String RechercherNom(String nom) {
        return contactNum.getOrDefault(nom, "Contact non trouvé !");
    }

    public void ModifierNum(String nom, String nouveauNum) {
        if (contactNum.containsKey(nom)) {
            contactNum.put(nom, nouveauNum);
        } else {
            System.out.println("Contact non trouvé, modification impossible.");
        }
    }

    public void EnregistrerFileContact(String cheminRepo) throws IOException {
        for (Map.Entry<String, String> entry : contactNum.entrySet()) {
            File file = new File(cheminRepo, entry.getKey());
            if (!file.exists()) {
                file.createNewFile();
            }
            Files.write(file.toPath(), entry.getValue().getBytes());
        }
    }
}

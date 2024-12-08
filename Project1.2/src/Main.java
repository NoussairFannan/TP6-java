import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Préciser le chemin du répertoire :");
        String cheminRepo = sc.nextLine();
        File file = new File(cheminRepo);

        if (!file.exists() || !file.isDirectory()) {
            System.out.println("Le chemin spécifié n'est pas un répertoire valide !");
            return;
        }

        Map<String, String> contactMap = new HashMap<>();
        File[] contacts = file.listFiles();
        if (contacts != null) {
            for (File contact : contacts) {
                contactMap.put(contact.getName(), Files.readString(contact.toPath()));
            }
        }

        DossierContact dossierContact = new DossierContact(contactMap);
        int choice;

        do {
            System.out.println("\nChoisissez l'une des actions suivantes :");
            System.out.println("1. Chercher un numéro");
            System.out.println("2. Ajouter un contact");
            System.out.println("3. Supprimer un contact");
            System.out.println("4. Changer le numéro d'un contact");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Donner le nom du contact à chercher : ");
                    String nomRecherche = sc.nextLine();
                    System.out.println("Numéro du contact : " + dossierContact.RechercherNom(nomRecherche));
                    break;

                case 2:
                    System.out.print("Donner le nom du contact à ajouter : ");
                    String nomAjout = sc.nextLine();
                    System.out.print("Donner le numéro du contact à ajouter : ");
                    String numAjout = sc.nextLine();
                    dossierContact.AjouterContact(nomAjout, numAjout);
                    System.out.println("Le contact a été ajouté avec succès.");
                    break;

                case 3:
                    System.out.print("Donner le nom du contact à supprimer : ");
                    String nomSupprimer = sc.nextLine();
                    dossierContact.SupprimerContact(nomSupprimer);
                    System.out.println("Le contact a été supprimé avec succès.");
                    break;

                case 4:
                    System.out.print("Donner le nom du contact à modifier : ");
                    String nomModifier = sc.nextLine();
                    System.out.print("Donner le nouveau numéro : ");
                    String nouveauNum = sc.nextLine();
                    dossierContact.ModifierNum(nomModifier, nouveauNum);
                    break;

                case 5:
                    dossierContact.EnregistrerFileContact(cheminRepo);
                    System.out.println("Données sauvegardées. Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        } while (choice != 5);

        sc.close();
    }
}

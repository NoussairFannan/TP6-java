import java.util.Scanner;

public class ApplicationClients {
    public static void main(String[] args) {
        MetierClientImpl metierClient = new MetierClientImpl("clients.dat");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Afficher la liste des clients.");
            System.out.println("2. Rechercher un client par son nom.");
            System.out.println("3. Ajouter un nouveau client.");
            System.out.println("4. Supprimer un client par nom.");
            System.out.println("5. Sauvegarder les clients.");
            System.out.println("6. Quitter.");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne
            switch (choix) {
                case 1 : metierClient.getAll().forEach(System.out::println);
                case 2 :
                    System.out.print("Nom du client : ");
                    String nom = scanner.nextLine();
                    System.out.println(metierClient.findByNom(nom));
                case 3 :
                    System.out.print("Nom : ");
                    String nomAj = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String tel = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    metierClient.add(new Client(nomAj, prenom, adresse, tel, email));
                case 4 :
                    System.out.print("Nom du client à supprimer : ");
                    String nomSup = scanner.nextLine();
                    metierClient.delete(nomSup);
                case 5 : metierClient.saveAll();
                case 6 :
                    System.out.println("Programme terminé.");
                    System.exit(0);
                default : System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}

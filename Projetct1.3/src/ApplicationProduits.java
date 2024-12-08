import java.util.Scanner;

public class ApplicationProduits {
    public static void main(String[] args) {
        MetierProduitImpl metierProduit = new MetierProduitImpl("produits.dat");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son nom.");
            System.out.println("3. Ajouter un nouveau produit.");
            System.out.println("4. Supprimer un produit par nom.");
            System.out.println("5. Sauvegarder les produits.");
            System.out.println("6. Quitter.");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 : metierProduit.getAll().forEach(System.out::println);
                case 2 :
                    System.out.print("Nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.println(metierProduit.findByNom(nom));
                case 3 :
                    System.out.print("Nom : ");
                    String nomAj = scanner.nextLine();
                    System.out.print("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Nombre en stock : ");
                    int stock = scanner.nextInt();
                    metierProduit.add(new Produit(nomAj, marque, prix, description, stock));
                case 4 :
                    System.out.print("Nom du produit à supprimer : ");
                    String nomSup = scanner.nextLine();
                    metierProduit.delete(nomSup);
                case 5 : metierProduit.saveAll();
                case 6 : System.exit(0);
                default : System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}

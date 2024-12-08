# Projets Java : Généricité et Entrées/Sorties

Ce dépôt contient trois projets de programmation en Java axés sur la manipulation des fichiers, la généricité et les principes de la programmation orientée objet.

---

## Exercice 1 : Simuler la commande `ls`

### Description
Ce programme Java simule la commande Unix `ls` en listant les fichiers et répertoires d’un répertoire donné. Il explore les sous-répertoires de manière récursive et affiche :
- Le type : `<DIR>` pour les répertoires et `<FILE>` pour les fichiers.
- Les permissions : 
  - `r` pour lecture,
  - `w` pour écriture,
  - `h` pour fichier caché.

### Classes utilisées
1. **Main** : La classe principale qui gère l'entrée utilisateur et affiche la liste des fichiers/répertoires.
2. **File** : Utilisée pour accéder aux fichiers et répertoires du système de fichiers.
3. **Files** : Utilisée pour lire le contenu des fichiers et vérifier les permissions.
4. **Scanner** : Pour gérer l'entrée de l'utilisateur via le terminal.


---

## Exercice 2 : Annuaire téléphonique

### Description
Un programme Java pour gérer une liste de contacts téléphoniques. Les contacts sont enregistrés dans des fichiers individuels portant leur nom, avec le numéro de téléphone à l'intérieur. Le programme propose les fonctionnalités suivantes :
1. **Rechercher un contact** : Trouver le numéro associé à un nom.
2. **Ajouter un contact** : Ajouter un nouveau fichier pour un contact.
3. **Supprimer un contact** : Supprimer un fichier correspondant à un contact.
4. **Modifier un contact** : Mettre à jour le numéro d’un contact existant.
5. **Sauvegarder les modifications** : Enregistrer les changements dans les fichiers.

### Classes utilisées
1. **Main** : La classe principale où l'utilisateur interagit avec le programme via un menu.
2. **DossierContact** : Contient la logique pour gérer la liste des contacts, ajouter, supprimer, rechercher et modifier des contacts.
3. **File** : Utilisée pour gérer les fichiers des contacts dans le répertoire.
4. **Files** : Utilisée pour lire et écrire dans les fichiers contenant les numéros de téléphone des contacts.
- On a utilisée `map()` pour stocker les contacts sous forme de paires nom/numéro de téléphone.

---

## Exercice 3 : Gestion des produits et clients

### Description
Ce projet permet de gérer des objets sérialisés (`Produit` et `Client`) en lecture et écriture dans des fichiers. Chaque entité est manipulée à l’aide d’une interface générique. 

### Fonctionnalités
1. **Produit** :
   - Ajouter un produit.
   - Afficher tous les produits.
   - Rechercher un produit par nom.
   - Supprimer un produit.
   - Sauvegarder la liste des produits dans un fichier (`produits.dat`).

2. **Client** :
   - Ajouter un client.
   - Afficher tous les clients.
   - Rechercher un client par nom.
   - Supprimer un client.
   - Sauvegarder la liste des clients dans un fichier (`clients.dat`).

### Classes utilisées
1. **Produit** : Classe représentant un produit, avec des attributs comme `nom`, `marque`, `prix`, `description` et `quantité`.
2. **Client** : Classe représentant un client avec des attributs comme `nom`, `prénom`, `adresse`, `téléphone`, et `email`.
3. **IMetier** : Interface générique définissant les méthodes pour gérer les objets (ajout, recherche, suppression, etc.) pour les produits et les clients.
4. **MetierProduitImpl** : Implémentation de l'interface `IMetier` pour la gestion des produits.
5. **MetierClientImpl** : Implémentation de l'interface `IMetier` pour la gestion des clients.
6. **Application** : Classe principale qui présente un menu interactif pour gérer les produits.
7. **Serializable** : Interface utilisée pour sérialiser les objets `Produit` et `Client` afin de les sauvegarder dans des fichiers (`produits.dat`, `clients.dat`).
8. **File** : Utilisée pour lire et écrire les fichiers sérialisés.
9. **ObjectInputStream / ObjectOutputStream** : Classes utilisées pour la sérialisation et la désérialisation des objets `Produit` et `Client`.



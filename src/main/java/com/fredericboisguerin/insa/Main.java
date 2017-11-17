package com.fredericboisguerin.insa;


import java.util.Scanner;

public class Main {
        public static void main(String [] arguments){
        ContactsManager contactsManager = new ContactsManager();

        System.out.println("****************INTERFACE COMMAND LINE********************");
        Boolean boucle = true ;
        while(boucle){
            System.out.println(" Bienvenue dans votre Manager de Contacts. \n" +
                    "Veuillez entrer le numéro de l'action à effectuer parmi les propositions ci-dessous : \n" +
                    "1. Ajouter un nouveau contact\n" +
                    "2. Imprimer tous les contacts \n" +
                    "3. Rechercher un contact par son nom \n" +
                    "4. Exit ContactsManager");

            Scanner sc = new Scanner (System.in);
            int choice = Integer.parseInt(sc.nextLine());
            String result= "" ;
            switch (choice){
                case 1:  result = AjouterContact(contactsManager);
                    break;
                case 2: contactsManager.printAllContacts() ;
                    break ;
                case 3: ChercherContactByName(contactsManager);
                    break ;
                case 4: boucle = false ;
                System.out.println("Vous quittez le contact Manager");
                break;
            }
            System.out.println(result);

        }

    }

    private static String AjouterContact(ContactsManager cm) {
        System.out.println("Entrez le nom et prénom :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Entrez le mail :");
        String email = sc.nextLine();
        System.out.println("Entrez le numéro de téléphone :");
        String phoneNumber = sc.nextLine();
        String result = "";

        try {
            cm.addContact(name,email,phoneNumber);
            result = "vous avez ajouté le contact" ;
        }catch (InvalidEmailException  e){
            result = "---------Le mail que vous avez entré n'est pas correct -----------\n";

        }catch (InvalidContactNameException e){
            result = "---------Le nom que vous avez entré n'est pas correct--------- \n";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    private static void ChercherContactByName(ContactsManager cm){
        System.out.println("Entrez le nom de la personne que vous recherchez :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        cm.searchContactByName(name);

    }
}

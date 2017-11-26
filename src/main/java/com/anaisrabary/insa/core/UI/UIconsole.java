package com.anaisrabary.insa.core.UI;


import com.anaisrabary.insa.core.model.ManagerCSV;
import com.anaisrabary.insa.core.Service.ContactsManager;
import com.anaisrabary.insa.core.Service.InvalidContactNameException;
import com.anaisrabary.insa.core.Service.InvalidEmailException;

import java.util.Scanner;

// TODO : CF COrriger : séparer le menu !!
public class UIconsole {
    private ContactsManager contactsManager;
    private Scanner sc ;
    private ManagerCSV managerCSV;

    public UIconsole(ManagerCSV managerCSV){
        this.managerCSV = managerCSV ;
    }


    public void start(){
        System.out.println("****************INTERFACE COMMAND LINE********************");
        sc = new Scanner (System.in);
        String commande;

        printTitle();
        contactsManager = managerCSV.readData();
        printTexteBienvenu();

        do {
            System.out.print("=>");
            commande= sc.nextLine().toLowerCase().trim();
            executeCommande(commande);
        }while (!commande.toLowerCase().trim().equals("exit"));

        managerCSV.writeData(contactsManager);

        sc.close();

        printSortie();

    }


    private void executeCommande(String commande){
        //Commandes : add | print | find | exit
        switch (commande){
            case "add":
                processAjouterContact();
                break;
            case "print" :
                processPrintContact();
                break ;
            case "find":
                processChercherContactByName();
                break ;
            case "exit":
                break;
            default:
                System.out.printf("ERREUR : Command not found (\"%s\")", commande);
                System.out.println("Commandes : add | print | find | exit \n");
        }
    }


    private void processAjouterContact() {
        System.out.println("------------AJOUTER CONTACT ------------ \n");
        try {
            System.out.println("Entrez le nom et prénom :");
            String name = sc.nextLine();
            System.out.println("Entrez le mail :");
            String email = sc.nextLine();
            System.out.println("Entrez le numéro de téléphone :");
            String phoneNumber = sc.nextLine();
            contactsManager.addContact(name,email,phoneNumber);
            System.out.println("---------Vous avez ajouté le contact-------------") ;
        }catch (InvalidEmailException e){
            System.out.println("---------Le mail que vous avez entré n'est pas correct -----------");

        }catch (InvalidContactNameException e){
            System.out.println("---------Le nom que vous avez entré n'est pas correct--------- ");

        } catch (Exception e) {
            System.out.println("Autre exception :");
            System.out.println(e.getMessage());
        }finally {
            System.out.println("-----------PROCESS ADD FINISHED ------------\n");
        }
    }
    private void processPrintContact(){
        System.out.println("------------IMPRIMER LISTE CONTACTS ------------ \n");
        contactsManager.printAllContacts() ;
        System.out.println("-----------PROCESS PRINT FINISHED ------------\n");
    }



    private void processChercherContactByName(){
        System.out.println("------------TROUVER CONTACT PAR SON NOM ------------ \n");
        System.out.println("Entrez le nom de la personne que vous recherchez :");
        String name = sc.nextLine();
        contactsManager.searchContactByName(name);
        System.out.println("-----------PROCESS FIND BY NAME FINISHED ------------\n");


    }
    private void printTitle(){
        System.out.println("-----------------------------");
        System.out.println("----- Contacts manager ------");
        System.out.println("-----------------------------");
        System.out.println();
    }

   private void  printTexteBienvenu(){
       System.out.println(
               " Bienvenue dans votre Manager de Contacts. \n" +
               "Vous pouvez effectuer les actions suivantes :\n" +
               "1. Ajouter un nouveau contact (add)\n" +
               "2. Imprimer tous les contacts (print) \n" +
               "3. Rechercher un contact par son nom (find) \n" +
               "4. Exit ContactsManager(exit)");
       System.out.println("Commandes : add | print | find | exit \n");
   }

    private void printSortie(){
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("-------- AU REVOIR ----------");
        System.out.println("-----------------------------");
        System.out.println();
   }
}

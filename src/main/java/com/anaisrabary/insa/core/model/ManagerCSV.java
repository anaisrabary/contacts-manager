package com.anaisrabary.insa.core.model;

import com.anaisrabary.insa.core.Service.ContactsManager;
import com.anaisrabary.insa.core.Service.InvalidContactNameException;
import com.anaisrabary.insa.core.Service.InvalidEmailException;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;

public class ManagerCSV {

    private String outputFileName;

    public ManagerCSV(String outputFileName){
        this.outputFileName = outputFileName;
    }

    public ContactsManager readData(){
        if(!new File(outputFileName).exists()) {
            try {
                System.out.printf("------- Creating file : %s -------\n",outputFileName);
                if(new File(outputFileName).createNewFile())
                    System.out.println("SUCCES \n");
                else System.out.println("ECHEC \n");
            } catch (IOException e){
                System.out.printf("----- ERREUR à la création du fichier : %s ------\n",outputFileName);
            }
            return new ContactsManager();
        }else {
            ContactsManager cm = null;
            try {
                System.out.printf("------ Reading file : %s -------\n", outputFileName);
                cm = new ContactsManager();
                for (String[] contact : new CSVReader(new FileReader(outputFileName)).readAll()){
                    try {
                        cm.addContact(contact[0],contact[1],contact[2]);
                    }catch (ArrayIndexOutOfBoundsException e){
                        // / in case of no phoneNumber
                        try { cm.addContact(contact[0],contact[1],null);
                        }catch (Exception e1){System.out.println(e1.getMessage());
                        }
                    }catch (InvalidEmailException |InvalidContactNameException e){
                        System.out.println("ERREUR dans la tentative d'ajout d'un contact au contact manager\n");
                    }
                    catch (Exception e){System.out.println(e.getMessage());
                    }
                }
                System.out.println("CONTACTS MANAGER CREATED WITH ALL DATA\n");
            }catch (IOException e) {
                System.out.printf("----- ERREUR à la lecture du fichier : %s ------\n",outputFileName);
            }
            return cm ;
        }
    }

    public void writeData(ContactsManager cm){
        System.out.printf("-------- WRITING DATA IN : %s --------\n", outputFileName);
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(outputFileName));
            writer.writeAll(cm.recupererTousContacts());
            writer.close();
            System.out.println("-------DONE ! -------\n");
        }catch (IOException e){
            System.out.printf("ERREUR lors de l'accès au Fichier %s", outputFileName);
        }
    }
}

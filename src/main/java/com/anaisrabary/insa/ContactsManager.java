package com.anaisrabary.insa;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class ContactsManager {


    private List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String email, String phoneNumber)throws Exception{
        if (!Is_name_valid(name)) throw new InvalidContactNameException();
        else{
            if (!Is_email_invalid(email)) throw new InvalidEmailException();
            else contacts.add( new Contact(name,email,phoneNumber));
        }
    }

    public void printAllContacts() {
        Iterator<Contact> ite = contacts.iterator();
        StringJoiner sj = new StringJoiner (System.lineSeparator());
        while (ite.hasNext()) {
            //StringJoiner
            sj.add(ite.next().toString());
        }
        System.out.println(sj.toString());
    }

    public void searchContactByName(String name) {
        // c'est le debut du nom, pas le nom entier....
        Iterator<Contact> ite = contacts.iterator();
        StringJoiner sj = new StringJoiner (System.lineSeparator());
        while (ite.hasNext()) {
            Contact actu = ite.next();
            if (actu.Is_part_of_name(name)) {
                sj.add(actu.toString());
            }
        }
        System.out.println(sj.toString());
    }

    //TODO Modifier contact et Supprimer contact

    private Boolean Is_email_invalid(String email){
        if (email == null) return true;
        if (!email.matches("[A-Za-z0-9._-]+@[a-z0-9._-]{2,}.[a-z]{2,4}")) return false;
        else return true ;
    }
    private Boolean Is_name_valid(String name){
        if (name == null) return false;
        if (name.isEmpty()) return false;
        else return true;
    }
    public List<String[]> recupererTousContacts() {
        List<String[]> list = new ArrayList<>();
        for (Contact contact: this.contacts) {
            list.add(contact.toString().split(", "));
        }
        return list;
    }
    }



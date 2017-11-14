package com.fredericboisguerin.insa;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class ContactsManager {


    private List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String email, String phoneNumber) {
        contacts.add( new Contact(name,email,phoneNumber)) ;
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
}

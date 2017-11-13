package com.fredericboisguerin.insa;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactsManager {


    private List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String email, String phoneNumber) {
        contacts.add( new Contact(name,email,phoneNumber)) ;
    }

    public void printAllContacts() {
        Iterator<Contact> ite = contacts.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next().toString());
        }

    }

    public void searchContactByName(String name) {

    }
}

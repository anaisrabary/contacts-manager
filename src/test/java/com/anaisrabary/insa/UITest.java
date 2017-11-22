package com.anaisrabary.insa;

import org.junit.Test;
import org.mockito.InOrder;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

public class UITest {

    private static final String NICOLE_FERRONI_NAME = "Nicole Ferroni";
    private static final String NICOLE_FERRONI_EMAIL = "contact@nicoleferroni.fr";
    private static final String NICOLE_FERRONI_PHONE_NUMBER = "0651387945";

    private static final String GUILLAUME_MEURICE_NAME = "Guillaume Meurice";
    private static final String GUILLAUME_MEURICE_EMAIL = "contact@guillaumemeurice.fr";
    private static final String GUILLAUME_MEURICE_PHONE_NUMBER = "0615389254";

    @Test
    public void Tester_UI_when_ajouter_contact_and_find_contact ()throws Exception{
        ContactsManager contactsManager = mock(ContactsManager.class);
        ManagerCSV fileCSV = mock(ManagerCSV.class);
        String entree = "add\n"+NICOLE_FERRONI_NAME+"\n"+NICOLE_FERRONI_EMAIL+"\n"+NICOLE_FERRONI_PHONE_NUMBER+"\nfind\nnicol\nexit\n";
        System.setIn(new ByteArrayInputStream(entree.getBytes()));

        when(fileCSV.readData()).thenReturn(contactsManager);

        new UIconsole(fileCSV).start();

        InOrder inOrder = inOrder(contactsManager);
        inOrder.verify(contactsManager).addContact(NICOLE_FERRONI_NAME,NICOLE_FERRONI_EMAIL,NICOLE_FERRONI_PHONE_NUMBER);
        inOrder.verify(contactsManager).searchContactByName("nicol");
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void Tester_UI_when_print_all_contacts () throws Exception{
        ContactsManager contactsManager = mock(ContactsManager.class);
        ManagerCSV fileCSV = mock(ManagerCSV.class);
        String entree = "add\n"+NICOLE_FERRONI_NAME+"\n"+NICOLE_FERRONI_EMAIL+"\n"+NICOLE_FERRONI_PHONE_NUMBER+
                "\nadd\n"+GUILLAUME_MEURICE_NAME+"\n"+GUILLAUME_MEURICE_EMAIL+"\n"+GUILLAUME_MEURICE_PHONE_NUMBER+
                "\nprint\nexit\n";
        System.setIn(new ByteArrayInputStream(entree.getBytes()));

        when(fileCSV.readData()).thenReturn(contactsManager);

        new UIconsole(fileCSV).start();

        InOrder inOrder = inOrder(contactsManager);
        inOrder.verify(contactsManager).addContact(NICOLE_FERRONI_NAME,NICOLE_FERRONI_EMAIL,NICOLE_FERRONI_PHONE_NUMBER);
        inOrder.verify(contactsManager).addContact(GUILLAUME_MEURICE_NAME,GUILLAUME_MEURICE_EMAIL,GUILLAUME_MEURICE_PHONE_NUMBER);
        inOrder.verify(contactsManager).printAllContacts();
        inOrder.verifyNoMoreInteractions();
    }


    // TODO : finir les tests de UI ATTENTION : faire du JUnit aussi ++++++ TEster openCSV
    @Test
    public void Tester_UI_when_find_contact_not_added() throws Exception{System.out.println("TODO") ;}

    @Test
    public void tester_UI_Ajouter_mauvais_contact()throws Exception{System.out.println("TODO") ;}

    @Test
    public void tester_UI_when_une_autre_commande()throws Exception{System.out.println("TODO") ;}

}


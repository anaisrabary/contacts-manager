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
    public void Test_UI_when_ajouter_contact ()throws Exception{
        ContactsManager contactsManager = mock(ContactsManager.class);
        ManagerCSV fileCSV = mock(ManagerCSV.class);
        String entree = "add\nJames\njames@007.com\n007\nfind\njame\nexit\n";
        System.setIn(new ByteArrayInputStream(entree.getBytes()));

        when(fileCSV.readData()).thenReturn(contactsManager);

        new UIconsole(fileCSV).start();

        InOrder inOrder = inOrder(contactsManager);
        inOrder.verify(contactsManager).addContact("James","james@007.com","007" );
        inOrder.verify(contactsManager).searchContactByName("jame");
        inOrder.verifyNoMoreInteractions();

    }


    // TODO : finir les tests de UI ATTENTION : faire du JUnit aussi
    @Test
    public void tester_UI_imprimer_contacts () throws Exception{ System.out.println("TODO") ;}

    @Test
    public void tester_UI_Rechercher_contact_par_son_nom() throws Exception{System.out.println("TODO") ;}

    @Test
    public void tester_UI_Ajouter_mauvais_contact()throws Exception{System.out.println("TODO") ;}

}


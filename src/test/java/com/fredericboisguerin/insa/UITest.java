package com.fredericboisguerin.insa;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UITest {

    @Test
    public void tester_ajouter_contact ()throws Exception{
        ContactsManager contactsManager = mock(ContactsManager.class);
        String entree = "1\nJames\njames@007.com\n007\n4\n";
        System.setIn(new ByteArrayInputStream(entree.getBytes()));

        new UIconsole(contactsManager).start();
        verify(contactsManager).addContact("James","james@007.com","007" );
    }


}


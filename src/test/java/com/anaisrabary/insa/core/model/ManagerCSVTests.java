package com.anaisrabary.insa.core.model;

import com.anaisrabary.insa.core.Service.ContactsManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ManagerCSVTests {
    private static final String FILE_TMP = "tmp.csv";
    private static final String FIELD_OUTPUT_SEPARATOR = ", ";

    private static final String NICOLE_FERRONI_NAME = "Nicole Ferroni";
    private static final String NICOLE_FERRONI_EMAIL = "contact@nicoleferroni.fr";
    private static final String NICOLE_FERRONI_PHONE_NUMBER = "0651387945";

    private static final String GUILLAUME_MEURICE_NAME = "Guillaume Meurice";
    private static final String GUILLAUME_MEURICE_EMAIL = "contact@guillaumemeurice.fr";
    private static final String GUILLAUME_MEURICE_PHONE_NUMBER = "0615389254";

    private ByteArrayOutputStream out;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @After
    public void tearDouw() throws Exception{
        new File(FILE_TMP).delete();
    }

    @Test
    public void Test_when_Read_contacts_from_file()throws Exception{
       String contact1= new StringJoiner(FIELD_OUTPUT_SEPARATOR)
               .add(NICOLE_FERRONI_NAME)
               .add(NICOLE_FERRONI_EMAIL)
               .add(NICOLE_FERRONI_PHONE_NUMBER).toString();
        String contact2 = new StringJoiner(FIELD_OUTPUT_SEPARATOR)
                .add(GUILLAUME_MEURICE_NAME)
                .add(GUILLAUME_MEURICE_EMAIL).toString();

        new FileOutputStream(new File(FILE_TMP)).write((contact1+"\n"+ contact2).getBytes());

        ContactsManager cm = new ManagerCSV(FILE_TMP).readData();
        cm.addContact(NICOLE_FERRONI_NAME,NICOLE_FERRONI_EMAIL,NICOLE_FERRONI_PHONE_NUMBER);
        cm.addContact(GUILLAUME_MEURICE_NAME,GUILLAUME_MEURICE_EMAIL, null);

        cm.printAllContacts();

        String contactInfo1= NICOLE_FERRONI_NAME + FIELD_OUTPUT_SEPARATOR + NICOLE_FERRONI_EMAIL + FIELD_OUTPUT_SEPARATOR + NICOLE_FERRONI_PHONE_NUMBER;
        String contactInfo2 = GUILLAUME_MEURICE_NAME + FIELD_OUTPUT_SEPARATOR + GUILLAUME_MEURICE_EMAIL;
        assertThat(out.toString(), containsString(contactInfo1));
        assertThat(out.toString(), containsString(contactInfo2));

        assertThat(cm.recupererTousContacts().size(),equalTo(2));

    }
    // TODO : implement les tests pour vérifier le bon fonctionnement de manager CSV en read et write


}

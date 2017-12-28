package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }

            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validContactsFromXml")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("F'").withMiddleName("M1").withLastName("L1").withNickName("N1").withCompany("C1").withAddress("A1").withHomePhone("PH1").withEmail1("E1").withGroup("test1");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(before));
    }
}

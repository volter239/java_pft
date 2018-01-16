package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstName("F1").withMiddleName("M1").withLastName("L1").withNickName("N1").withCompany("C1").withAddress("A1").withHomePhone("PH1").withEmail1("E1").withGroup("test1").withPhoto(new File("src/test/resources/stru.png")));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("F2").withMiddleName("M2").withLastName("L2").withHomePhone("11 22 33").withMobilePhone("+7987").withWorkPhone("22-44-77").withNickName("N2").withCompany("C2").withAddress("A2").withEmail1("e1").withEmail2("e2").withEmail3("e3").withPhoto(new File("src/test/resources/stru.png"));
        app.goTo().homePage();
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

        verifyContactListInUI();
    }

}

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();

        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("F1").withMiddleName("M1").withLastName("L1").withNickName("N1").withCompany("C1").withAddress("A1").withPhoneHome("PH1").withEmail("E1").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size()-1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }

}

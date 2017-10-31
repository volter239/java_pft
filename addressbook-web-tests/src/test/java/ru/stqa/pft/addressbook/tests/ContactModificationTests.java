package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();

        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("F1", "M1", "L1", "N1", "C1", "A1", "PH1", "E1", "test1"));
        }

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size()-1);
        app.getContactHelper().fillContactForm(new ContactData("F2", "M2", "L2", "N2","C2","A2", null, null, null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());
    }

}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("F2", "M2", "L2", "N2","C2","A2"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }

}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("F4", "M4", "L4", "N4","C4","A4"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }

}

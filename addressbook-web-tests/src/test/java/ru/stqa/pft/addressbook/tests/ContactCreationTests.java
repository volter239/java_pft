package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("F11", "M11", "L11", "N11","C11","A11"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }

}

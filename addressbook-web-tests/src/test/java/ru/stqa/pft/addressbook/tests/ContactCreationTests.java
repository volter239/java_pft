package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("F1", "M1", "L1", "N1", "C1", "A1", "PH1", "E1", "test1"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }

}

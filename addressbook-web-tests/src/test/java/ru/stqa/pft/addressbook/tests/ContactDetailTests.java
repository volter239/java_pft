package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactDetailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();

        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("F1").withLastName("L1").withAddress("A1").withHomePhone("PH1").withEmail1("E1"));
        }
    }

    @Test
    public void testContactDetails() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);

        assertThat(mergeEdit(contactInfoFromEditForm), equalTo(mergeDetails(contactInfoFromDetailsForm)));
    }

    private String mergeEdit(ContactData contact) {
        return Arrays.asList(contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getHomePhoneWihHint(), contact.getMobilePhoneWihHint(), contact.getWorkPhoneWihHint(), contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).stream().filter((s) -> ! s.equals("")).map(ContactDetailTests::cleaned).collect(Collectors.joining(""));
    }

    private String mergeDetails(ContactData contact) {
        return Arrays.asList(contact.getAllDetails()).stream().filter((s) -> ! s.equals("")).map(ContactDetailTests::cleaned).collect(Collectors.joining("\n"));
    }

    public static String cleaned(String info) {
        return info.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}

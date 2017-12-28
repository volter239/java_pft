package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String args[]) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i=0; i<count; i++) {
            contacts.add(new ContactData().withFirstName(String.format("First%s", i)).withLastName(String.format("Last%s", i)).withEmail1(String.format("email%s@mail.ru", i)).withAddress(String.format("СПб, пр. Науки %s,\nк.%s,\nкв.%s", 100+i,200+i,300+i)).withMobilePhone(String.format("+7 %s %s %s", i,i,i)).withHomePhone(String.format("8-%s-%s-%s", i,i,i)).withGroup("test 0").withPhoto(new File("src/test/resources/stru.png")));
        }

        return contacts;
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);

        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

}

package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    private String firstName = "";

    @Column(name = "middlename")
    private String middleName = "";

    @Column(name = "lastname")
    private String lastName = "";

    @Column(name = "home")
    @Type(type = "text")
    private String homePhone = "";

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone = "";

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone = "";

    @Transient
    private String allPhones = "";

    @Transient
    private String group;

    @Transient
    private String photo;

    @Column(name = "nickname")
    private String nickName = "";

    @Column(name = "company")
    private String company = "";

    @Column(name = "address")
    @Type(type = "text")
    private String address = "";

    @Column(name = "email")
    @Type(type = "text")
    private String email1 = "";

    @Column(name = "email2")
    @Type(type = "text")
    private String email2 = "";

    @Column(name = "email3")
    @Type(type = "text")
    private String email3 = "";

    @Transient
    private String allEmails;

    @Transient
    private String allDetails;

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAllDetails(String allDetails) {
        this.allDetails = allDetails;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getHomePhoneWihHint() {
        if (homePhone.length()>0) {
            return "H:"+homePhone;
        }
        else {
            return homePhone;
        }
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getMobilePhoneWihHint() {
        if (mobilePhone.length()>0) {
            return "M:"+mobilePhone;
        }
        else {
            return mobilePhone;
        }
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getWorkPhoneWihHint() {
        if (workPhone.length()>0) {
            return "W:"+workPhone;
        }
        else {
            return workPhone;
        }
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getGroup() {
        return group;
    }

    public String getAllDetails() {
        return allDetails;
    }

    public File getPhoto() {
        if (photo == null) {
            return null;
        }
        else {
            return new File(photo);
        }
    }

    public void modifyNullStrings() {
        if (firstName == null) {
            firstName = "";
        }

        if (middleName == null) {
            middleName = "";
        }

        if (lastName == null) {
            lastName = "";
        }

        if (homePhone == null) {
            homePhone = "";
        }

        if (mobilePhone == null) {
            mobilePhone = "";
        }

        if (workPhone == null) {
            workPhone = "";
        }

        if (nickName == null) {
            nickName = "";
        }

        if (company == null) {
            company = "";
        }

        if (address == null) {
            address = "";
        }

        if (email1 == null) {
            email1 = "";
        }

        if (email2 == null) {
            email2 = "";
        }

        if (email3 == null) {
            email3 = "";
        }
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (email1 != null ? !email1.equals(that.email1) : that.email1 != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        return email3 != null ? email3.equals(that.email3) : that.email3 == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email1 != null ? email1.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        return result;
    }
}

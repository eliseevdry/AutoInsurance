package org.eliseev.autoinsurance.model;

import org.eliseev.autoinsurance.model.sub.Address;
import org.eliseev.autoinsurance.model.sub.PassportOffice;
import org.eliseev.autoinsurance.model.sub.Person;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Embeddable
public class Owner extends Person {
    private String eMail;
    private String phoneNum;
    private Address address;
    private String passportSeria;
    private String passportNumber;
    private LocalDate issueDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private PassportOffice passportOffice;

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public PassportOffice getPassportOffice() {
        return passportOffice;
    }

    public void setPassportOffice(PassportOffice passportOffice) {
        this.passportOffice = passportOffice;
    }
}

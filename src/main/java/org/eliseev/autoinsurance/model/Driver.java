package org.eliseev.autoinsurance.model;

import org.eliseev.autoinsurance.model.sub.Person;
import org.eliseev.autoinsurance.model.sub.RegisterOffice;

import javax.persistence.*;
import java.time.LocalDate;

@Embeddable
public class Driver extends Person {
    private String licenseSeria;
    private String licenseNumber;
    private LocalDate issueDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private RegisterOffice registerOffice;

    public String getLicenseSeria() {
        return licenseSeria;
    }

    public void setLicenseSeria(String licenseSeria) {
        this.licenseSeria = licenseSeria;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public RegisterOffice getRegisterOffice() {
        return registerOffice;
    }

    public void setRegisterOffice(RegisterOffice registerOffice) {
        this.registerOffice = registerOffice;
    }
}

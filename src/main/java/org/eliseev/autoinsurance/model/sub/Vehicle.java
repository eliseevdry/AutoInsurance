package org.eliseev.autoinsurance.model.sub;

import javax.persistence.Embeddable;

@Embeddable
public class Vehicle {
    private String licencePlate;
    private String identificationNumber;
    private Character category;
    private String brand;
    private String model;
    private Integer issueYear;
    private String purposeOfUsing;

    private Integer enginePower;
    private Character drive;
    private Character transmission;
    private String bodyType;
    private Integer busCapacity;
    private Integer truckMaxWeight;

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Character getCategory() {
        return category;
    }

    public void setCategory(Character category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(Integer issueYear) {
        this.issueYear = issueYear;
    }

    public String getPurposeOfUsing() {
        return purposeOfUsing;
    }

    public void setPurposeOfUsing(String purposeOfUsing) {
        this.purposeOfUsing = purposeOfUsing;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public Character getDrive() {
        return drive;
    }

    public void setDrive(Character drive) {
        this.drive = drive;
    }

    public Character getTransmission() {
        return transmission;
    }

    public void setTransmission(Character transmission) {
        this.transmission = transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Integer getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(Integer busCapacity) {
        this.busCapacity = busCapacity;
    }

    public Integer getTruckMaxWeight() {
        return truckMaxWeight;
    }

    public void setTruckMaxWeight(Integer truckMaxWeight) {
        this.truckMaxWeight = truckMaxWeight;
    }
}

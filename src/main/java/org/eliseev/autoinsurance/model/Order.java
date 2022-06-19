package org.eliseev.autoinsurance.model;

import org.eliseev.autoinsurance.model.sub.OrderStatus;
import org.eliseev.autoinsurance.model.sub.Vehicle;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "auto_insurance_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_insurance_order_id")
    private Long orderId;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "auto_insurance_status_id")
    private OrderStatus status;

    @Column(name = "auto_insurance_date")
    private LocalDateTime orderDate;

    @AttributeOverrides({
            @AttributeOverride(name = "licencePlate", column = @Column(name = "vehicle_licence_plate")),
            @AttributeOverride(name = "identificationNumber", column = @Column(name = "vehicle_identification_number")),
            @AttributeOverride(name = "category", column = @Column(name = "vehicle_category")),
            @AttributeOverride(name = "brand", column = @Column(name = "vehicle_brand")),
            @AttributeOverride(name = "model", column = @Column(name = "vehicle_model")),
            @AttributeOverride(name = "issueYear", column = @Column(name = "vehicle_issue_year")),
            @AttributeOverride(name = "purposeOfUsing", column = @Column(name = "vehicle_purpose_of_using")),
            @AttributeOverride(name = "enginePower", column = @Column(name = "auto_engine_power")),
            @AttributeOverride(name = "drive", column = @Column(name = "auto_drive")),
            @AttributeOverride(name = "transmission", column = @Column(name = "auto_transmission")),
            @AttributeOverride(name = "bodyType", column = @Column(name = "auto_body_type")),
            @AttributeOverride(name = "busCapacity", column = @Column(name = "bus_capacity")),
            @AttributeOverride(name = "truckMaxWeight", column = @Column(name = "truck_max_weight"))
    })
    private Vehicle vehicle;

    @AssociationOverrides({
            @AssociationOverride(name = "address.street", joinColumns = @JoinColumn(name = "owner_street_code")),
            @AssociationOverride(name = "passportOffice", joinColumns = @JoinColumn(name = "owner_passport_office_id"))
    })
    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "owner_sur_name")),
            @AttributeOverride(name = "givenName", column = @Column(name = "owner_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "owner_patronymic")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "owner_date_of_birth")),
            @AttributeOverride(name = "eMail", column = @Column(name = "owner_email")),
            @AttributeOverride(name = "phoneNum", column = @Column(name = "owner_phone_num")),
            @AttributeOverride(name = "address.postCode", column = @Column(name = "owner_post_index")),
            @AttributeOverride(name = "address.building", column = @Column(name = "owner_building")),
            @AttributeOverride(name = "address.extension", column = @Column(name = "owner_extension")),
            @AttributeOverride(name = "address.apartment", column = @Column(name = "owner_apartment")),
            @AttributeOverride(name = "passportSeria", column = @Column(name = "owner_passport_seria")),
            @AttributeOverride(name = "passportNumber", column = @Column(name = "owner_passport_number")),
            @AttributeOverride(name = "issueDate", column = @Column(name = "owner_passport_date"))
    })
    private Owner owner;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderDriver> driverList;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<OrderDriver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<OrderDriver> driverList) {
        this.driverList = driverList;
    }
}

package org.eliseev.autoinsurance.model;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class OrderDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long driverId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_insurance_order_id")
    private Order order;

    @AssociationOverrides({
            @AssociationOverride(name = "registerOffice", joinColumns = @JoinColumn(name = "driver_license_register_office_id"))
    })
    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "driver_sur_name")),
            @AttributeOverride(name = "givenName", column = @Column(name = "driver_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "driver_patronymic")),
            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "driver_date_of_birth")),
            @AttributeOverride(name = "licenseSeria", column = @Column(name = "driver_license_seria")),
            @AttributeOverride(name = "licenseNumber", column = @Column(name = "driver_license_number")),
            @AttributeOverride(name = "issueDate", column = @Column(name = "driver_license_date"))
    })
    private Driver driver;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

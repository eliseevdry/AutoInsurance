package org.eliseev.autoinsurance.service;

import org.eliseev.autoinsurance.model.Driver;
import org.eliseev.autoinsurance.model.Order;
import org.eliseev.autoinsurance.model.OrderDriver;
import org.eliseev.autoinsurance.model.Owner;
import org.eliseev.autoinsurance.model.sub.Address;
import org.eliseev.autoinsurance.model.sub.Street;
import org.eliseev.autoinsurance.model.sub.Vehicle;
import org.eliseev.autoinsurance.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AutoInsuranceService {
    public static final Logger LOGGER = LoggerFactory.getLogger(AutoInsuranceService.class);
    private final OrderDriverRepository orderDriverRepository;
    private final OrderRepository orderRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final PassportOfficeRepository passportOfficeRepository;
    private final RegisterOfficeRepository registerOfficeRepository;
    private final StreetRepository streetRepository;

    public AutoInsuranceService(CountryAreaRepository countryAreaRepository, OrderDriverRepository orderDriverRepository, OrderRepository orderRepository, OrderStatusRepository orderStatusRepository, PassportOfficeRepository passportOfficeRepository, RegisterOfficeRepository registerOfficeRepository, StreetRepository streetRepository) {
        this.orderDriverRepository = orderDriverRepository;
        this.orderRepository = orderRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.passportOfficeRepository = passportOfficeRepository;
        this.registerOfficeRepository = registerOfficeRepository;
        this.streetRepository = streetRepository;
    }

    @Transactional
    public void testSave() {
        Order order = new Order();
        order.setStatus(orderStatusRepository.getOne(2L));
        order.setOrderDate(LocalDateTime.now());
        order.setVehicle(buildVehicle('A'));
        order.setOwner(buildOwner());

        orderRepository.save(order);

        OrderDriver orderDriver1 = buildOrderDriver(order);
        OrderDriver orderDriver2 = buildOrderDriver(order);

        orderDriverRepository.save(orderDriver1);
        orderDriverRepository.save(orderDriver2);
    }

    @Transactional
    public void testGet() {
        List<Order> orders = orderRepository.findAll();
        LOGGER.info(orders.get(1).getOwner().geteMail());
        LOGGER.info(orders.get(1).getDriverList().get(0).getDriver().getGivenName());
        LOGGER.info(orders.get(1).getDriverList().get(1).getDriver().getGivenName());
    }

    private OrderDriver buildOrderDriver(Order order) {
        OrderDriver orderDriver = new OrderDriver();

        orderDriver.setOrder(order);

        Driver driver = new Driver();
        driver.setSurName("DRIVER");
        driver.setGivenName("Елисеев");
        driver.setPatronymic("DRIVER");
        driver.setDateOfBirth(LocalDate.of(1997, 1, 1));
        driver.setLicenseSeria("1234");
        driver.setLicenseNumber("654321");
        driver.setIssueDate(LocalDate.of(2018, 1, 25));
        driver.setRegisterOffice(registerOfficeRepository.getOne(1L));

        orderDriver.setDriver(driver);
        return orderDriver;
    }

    private Owner buildOwner() {
        Owner owner = new Owner();
        owner.setSurName("Андрей");
        owner.setGivenName("Елисеев");
        owner.setPatronymic("Сергеевич");
        owner.setDateOfBirth(LocalDate.of(1997, 1, 1));
        owner.seteMail("eliseevdry@mail.ru");
        owner.setPhoneNum("8-964-327-82-64");

        Address address = new Address();
        address.setPostCode("190000");
        address.setBuilding("21");
        address.setExtension("B");
        address.setApartment("199");
        Street one = streetRepository.getOne(1L);
        address.setStreet(one);

        owner.setAddress(address);
        owner.setPassportSeria("4016");
        owner.setPassportNumber("709748");
        owner.setIssueDate(LocalDate.of(2016, 1, 21));
        owner.setPassportOffice(passportOfficeRepository.getOne(1L));

        return owner;
    }

    private Vehicle buildVehicle(char variant) {
        Vehicle vehicle = new Vehicle();

        vehicle.setLicencePlate("У432МХ198");
        vehicle.setIdentificationNumber("1LADAVESTA12DAETO");
        vehicle.setCategory(variant);
        vehicle.setBrand("BMW");
        vehicle.setModel("L1");
        vehicle.setIssueYear(2016);
        vehicle.setPurposeOfUsing("Просто кататься хочу");

        switch (variant) {
            case 'A':
                vehicle.setEnginePower(250);
                break;
            case 'B':
                vehicle.setEnginePower(250);
                vehicle.setDrive('F');
                vehicle.setTransmission('A');
                vehicle.setBodyType("cabriolet");
                break;
            case 'C':
                vehicle.setTruckMaxWeight(4500);
                break;
            case 'D':
                vehicle.setBusCapacity(15);
                break;
            default:
                break;
        }
        return vehicle;
    }

}

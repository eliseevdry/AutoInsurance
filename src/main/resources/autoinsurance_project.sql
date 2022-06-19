DROP TABLE IF EXISTS driver;
DROP TABLE IF EXISTS auto_insurance_order;
DROP TABLE IF EXISTS passport_office;
DROP TABLE IF EXISTS register_office;
DROP TABLE IF EXISTS country_struct;
DROP TABLE IF EXISTS street;
DROP TABLE IF EXISTS order_status;

CREATE TABLE street
(
    street_code integer not null,
    street_name varchar(300),
    PRIMARY KEY (street_code)
);


CREATE TABLE country_struct
(
    area_id   char(12) not null,
    area_name varchar(200),
    PRIMARY KEY (area_id)
);


CREATE TABLE passport_office
(
    p_office_id      integer  not null,
    p_office_area_id char(12) not null,
    p_office_name    varchar(200),
    PRIMARY KEY (p_office_id),
    FOREIGN KEY (p_office_area_id) REFERENCES country_struct (area_id) ON DELETE RESTRICT
);


CREATE TABLE register_office
(
    r_office_id      integer  not null,
    r_office_area_id char(12) not null,
    r_office_name    varchar(200),
    PRIMARY KEY (r_office_id),
    FOREIGN KEY (r_office_area_id) REFERENCES country_struct (area_id) ON DELETE RESTRICT
);

CREATE TABLE order_status
(
    status_id   integer not null,
    status_name varchar(20),
    PRIMARY KEY (status_id)
);


CREATE TABLE auto_insurance_order
(
    auto_insurance_order_id       SERIAL,
    auto_insurance_status_id      int          not null,
    auto_insurance_date           timestamp    not null,

    vehicle_licence_plate         char(9)      not null,
    vehicle_identification_number char(17)     not null,
    vehicle_category              char(1)      not null,
    vehicle_brand                 varchar(100) not null,
    vehicle_model                 varchar(100) not null,
    vehicle_issue_year            integer      not null,
    vehicle_purpose_of_using      varchar(100) not null,

    auto_engine_power             integer,
    auto_drive                    char(1),
    auto_transmission             char(1),
    auto_body_type                varchar(20),
    bus_capacity                  integer,
    truck_max_weight              integer,

    owner_sur_name                varchar(100) not null,
    owner_given_name              varchar(100) not null,
    owner_patronymic              varchar(100),
    owner_date_of_birth           date         not null,
    owner_email                   varchar(100) not null,
    owner_phone_num               integer      not null,
    owner_post_index              varchar(10),
    owner_street_code             integer      not null,
    owner_building                varchar(10)  not null,
    owner_extension               varchar(10),
    owner_apartment               varchar(10),
    owner_passport_seria          varchar(10)  not null,
    owner_passport_number         varchar(10)  not null,
    owner_passport_date           date         not null,
    owner_passport_office_id      integer      not null,
    PRIMARY KEY (auto_insurance_order_id),
    FOREIGN KEY (auto_insurance_status_id) REFERENCES order_status (status_id) ON DELETE RESTRICT,
    FOREIGN KEY (owner_street_code) REFERENCES street (street_code) ON DELETE RESTRICT,
    FOREIGN KEY (owner_passport_office_id) REFERENCES passport_office (p_office_id) ON DELETE RESTRICT
);

CREATE TABLE driver
(
    driver_id                         SERIAL,
    auto_insurance_order_id           integer      not null,
    driver_sur_name                   varchar(100) not null,
    driver_given_name                 varchar(100) not null,
    driver_patronymic                 varchar(100),
    driver_date_of_birth              date         not null,
    driver_license_seria              varchar(10)  not null,
    driver_license_number             varchar(10)  not null,
    driver_license_date               date         not null,
    driver_license_register_office_id integer      not null,
    PRIMARY KEY (driver_id),
    FOREIGN KEY (auto_insurance_order_id) REFERENCES auto_insurance_order (auto_insurance_order_id) ON DELETE RESTRICT,
    FOREIGN KEY (driver_license_register_office_id) REFERENCES register_office (r_office_id) ON DELETE RESTRICT
);

CREATE INDEX idx_auto_insurance_status_id ON auto_insurance_order (auto_insurance_status_id);

CREATE INDEX idx_auto_insurance_order_id ON driver (auto_insurance_order_id);
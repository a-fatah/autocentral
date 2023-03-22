CREATE TABLE customer
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    birth_date DATE         NOT NULL
);

CREATE TABLE vehicle
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    brand      VARCHAR(255) NOT NULL,
    model      VARCHAR(255) NOT NULL,
    model_year INT          NOT NULL,
    vin        VARCHAR(255),
    price      INT       NOT NULL
);

CREATE TABLE contract
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    contract_number VARCHAR(255) NOT NULL,
    monthly_rate    INT       NOT NULL,
    customer_id     BIGINT       NOT NULL,
    vehicle_id      BIGINT       NOT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT fk_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle (id)
);
-- Seed data for vehicles
INSERT INTO vehicle (brand, model, model_year, vin, price)
VALUES ('Toyota', 'Corolla', 2022, 'JTDEPMAE1NJ159657', 20000),
       ('Honda', 'Accord', 2021, '1HGCV1F40MA020324', 25000),
       ('Chevrolet', 'Camaro', 2020, '1G1FH1R70L0100254', 35000);

-- Seed data for customers
INSERT INTO customer (first_name, last_name, birth_date)
VALUES ('John', 'Doe', '1980-01-01'),
       ('Jane', 'Doe', '1985-02-15'),
       ('Bob', 'Smith', '1990-05-20');

-- Seed data for leasing contracts
INSERT INTO contract (contract_number, monthly_rate, customer_id, vehicle_id)
VALUES ('C001', 500.0, 1, 1),
       ('C002', 600.0, 2, 2),
       ('C003', 700.0, 3, 3);
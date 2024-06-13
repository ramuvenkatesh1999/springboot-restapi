CREATE DATABASE ems_db;

USE ems_db;

-- Create the table
CREATE TABLE elements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    ip_address VARCHAR(255) NOT NULL
);

-- Insert sample data
INSERT INTO elements (name, ip_address) VALUES ('Element1', '192.168.1.1');
INSERT INTO elements (name, ip_address) VALUES ('Element2', '192.168.1.2');
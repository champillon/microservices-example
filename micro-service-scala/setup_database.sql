DROP DATABASE IF EXISTS microservices;
DROP ROLE IF EXISTS microservices;

CREATE ROLE microservices WITH LOGIN;
ALTER ROLE microservices with SUPERUSER;
CREATE DATABASE microservices;
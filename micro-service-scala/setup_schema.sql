CREATE TABLE bookings(
   id               INT,
   seat             INT,
   booker_name      VARCHAR(256),
   info             TEXT,
   CONSTRAINT     bookings_pk PRIMARY KEY (id)
 );
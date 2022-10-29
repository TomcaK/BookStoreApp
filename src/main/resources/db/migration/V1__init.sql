
CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE books (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   price INTEGER NOT NULL,
   author VARCHAR(255),
   CONSTRAINT pk_books PRIMARY KEY (id)
);
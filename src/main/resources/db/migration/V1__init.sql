create sequence  IF NOT EXISTS hibernate_sequence START with 1 INCREMENT BY 1;

create table authors (
  author_id integer not null,
   name VARCHAR(255),
   constraint pk_authors primary key (author_id)
);


create sequence  IF NOT EXISTS hibernate_sequence START with 1 INCREMENT BY 1;

create table books (
  id integer not null,
   name VARCHAR(255),
   price integer not null,
   author_id integer not null,
   constraint pk_books primary key (id)
);

alter TABLE books ADD CONSTRAINT FK_BOOKS_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES authors (author_id);


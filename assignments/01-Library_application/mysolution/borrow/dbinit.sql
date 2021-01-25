CREATE DATABASE "borrow" OWNER postgres;
\connect borrow
ALTER DATABASE "borrow" SET TIMEZONE TO 'Europe/Rome';
SET TIMEZONE TO 'Europe/Rome';

CREATE TABLE "borrows"
(
    borrow_id integer,
    customer_id character varying,
    book_Id character varying,
    notify_to_phone_nr character varying
) TABLESPACE pg_default;

ALTER TABLE "borrows"
    OWNER to postgres;

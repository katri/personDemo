DROP SCHEMA public CASCADE;
CREATE SCHEMA public
    GRANT ALL ON SCHEMA public TO postgres;
GRANT
ALL
ON SCHEMA public TO PUBLIC;

CREATE TABLE person
(
    id         serial NOT NULL,
    first_name text   NOT NULL,
    last_name  text   NOT NULL,
    birth_date date   NOT NULL
);
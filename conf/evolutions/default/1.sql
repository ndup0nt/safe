# Tasks schema

# --- !Ups

CREATE SEQUENCE controlType_id_seq;
CREATE TABLE controlType (
    id integer NOT NULL DEFAULT nextval('controlType_id_seq'),
    label varchar(255)
);

# --- !Downs

DROP TABLE controlType;
DROP SEQUENCE controlType_id_seq;

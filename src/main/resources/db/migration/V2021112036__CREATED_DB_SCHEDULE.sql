
CREATE SEQUENCE db_schedule_seq INCREMENT 1;

CREATE TABLE IF NOT EXISTS db_schedule
(
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('db_schedule_seq'),
    name VARCHAR(150) NOT NULL ,
    description VARCHAR(255) NOT NULL ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);


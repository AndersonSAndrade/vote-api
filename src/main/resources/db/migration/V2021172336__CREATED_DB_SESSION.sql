CREATE SEQUENCE db_session_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999999999
    START 1;

CREATE TABLE IF NOT EXISTS db_session
(
    id BIGINT NOT NULL DEFAULT nextval('db_session_seq'),
    schedule_id BIGINT NOT NULL ,
    start_session TIMESTAMP NOT NULL ,
    end_session TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    PRIMARY KEY(id),
    FOREIGN KEY (schedule_id) REFERENCES db_schedule(id)
);

CREATE SEQUENCE db_vote_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9999999999
    START 1;

CREATE TABLE IF NOT EXISTS db_vote
(
    id BIGINT NOT NULL DEFAULT nextval('db_vote_seq'),
    associate_id VARCHAR(255) NOT NULL,
    session_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    PRIMARY KEY(id),
        FOREIGN KEY (session_id) REFERENCES db_session(id) ON DELETE CASCADE ON UPDATE CASCADE
);




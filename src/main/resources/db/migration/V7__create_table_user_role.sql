CREATE TABLE person_role(
    id BIGINT NOT NULL AUTO_INCREMENT,
    person_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(person_id) REFERENCES person(id),
    FOREIGN KEY(role_id) REFERENCES role(id)
);

INSERT INTO person_role (id, person_id, role_id) VALUES (1, 1, 1);
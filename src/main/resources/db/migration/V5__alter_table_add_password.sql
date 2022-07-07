ALTER TABLE person ADD COLUMN password text;

UPDATE person SET password = '$2a$12$SomP1fKai6HLjexe4Z91zeZzbwGxlM55M9K7QmAPlcvi9fyUOovgu' WHERE id = 1;
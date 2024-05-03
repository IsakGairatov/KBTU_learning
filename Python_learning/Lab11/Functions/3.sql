CREATE OR REPLACE PROCEDURE insList(x varchar, y varchar) AS $$
DECLARE
    n_id int;
BEGIN
     INSERT INTO phonebook(users, number)
     VALUES(x, y)
     RETURNING id INTO n_id;

END;
$$ LANGUAGE plpgsql;


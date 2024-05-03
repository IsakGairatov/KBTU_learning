CREATE OR REPLACE PROCEDURE InOrUp(
	new_user varchar,
	new_num varchar
)
AS $$
DECLARE
	n_userId INT;
BEGIN
    IF NOT EXISTS(SELECT * FROM phonebook WHERE users = new_user) THEN
	    INSERT INTO phonebook(users, number)
	    VALUES(new_user, new_num)
	    RETURNING id INTO n_userId;
	ELSE
	    UPDATE phonebook
        SET number = new_num
	    WHERE users = new_user;
    END IF;
END;
$$
LANGUAGE PLPGSQL;

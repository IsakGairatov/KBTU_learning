CREATE OR REPLACE FUNCTION getPattern(let CHAR)
RETURNS TABLE(id int, users1 VARCHAR, number VARCHAR) AS
$$
BEGIN
    RETURN QUERY
    SELECT * FROM phonebook
    WHERE users LIKE let;

END; $$

LANGUAGE plpgsql;

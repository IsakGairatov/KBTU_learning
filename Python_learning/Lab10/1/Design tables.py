import psycopg2
from config import config

command = """
        CREATE TABLE phonebook (
            id SERIAL PRIMARY KEY,
            users VARCHAR(255),
            number VARCHAR(255)
        )
        """
conn = None
try:
    # read the connection parameters
    params = config()
    # connect to the PostgreSQL server
    conn = psycopg2.connect(**params)
    cur = conn.cursor()
    # create table
    cur.execute(command)
    # close communication with the PostgreSQL database server
    cur.close()
    # commit the changes
    conn.commit()
except (Exception, psycopg2.DatabaseError) as error:
    print(error)
finally:
    if conn is not None:
        conn.close()
import psycopg2
from config import config

command = """
        CREATE TABLE snakeStats(
            id SERIAL PRIMARY KEY,
            username VARCHAR(255),
            level int,
            score int
            )
        """

conn = None
try:
    params = config()

    # connect to the PostgreSQL server
    conn = psycopg2.connect(**params)
    cur = conn.cursor()

    cur.execute(command)
    cur.close()
    conn.commit()
except (Exception, psycopg2.DatabaseError) as error:
    print(error)
finally:
    if conn is not None:
        conn.close()

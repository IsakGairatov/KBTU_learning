import psycopg2
from config import config


def update_book(mode, var, newVal):
    sql = (""" UPDATE phonebook
                SET number = {}
                WHERE users = '{}'""",
           """ UPDATE phonebook
                SET users = '{}'
                WHERE number = '{}'""")
    conn = None
    updated_rows = 0
    try:
        # read database configuration
        params = config()
        # connect to the PostgreSQL database
        conn = psycopg2.connect(**params)
        # create a new cursor
        cur = conn.cursor()
        # execute the UPDATE  statement
        cur.execute(sql[mode].format(newVal, var))
        # get the number of updated rows
        updated_rows = cur.rowcount
        # Commit the changes to the database
        conn.commit()
        # Close communication with the PostgreSQL database
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return updated_rows


mode = int(input('change number by username (input 0), change username by number (input 1):\n'))
var = ('username:\n', 'number:\n')

update_book(mode, input(var[mode]), input(var[::-1][mode]))

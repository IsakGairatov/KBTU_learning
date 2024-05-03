import psycopg2
from config import config
import csv


def insert_one(username, p_number):

    sql = """INSERT INTO phonebook(users, number)
             VALUES('{}', {}) RETURNING users, number;"""


    conn = None
    vendor_id = None
    try:
        # read database configuration
        params = config()
        # connect to the PostgreSQL database
        conn = psycopg2.connect(**params)
        # create a new cursor
        cur = conn.cursor()
        # execute the INSERT statement
        cur.execute(sql.format(username, p_number))
        # get the generated id back
        vendor_id = cur.fetchone()[0]
        # commit the changes to the database
        conn.commit()
        # close communication with the database
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return username, p_number


def insert_list(list0):
    sql = """INSERT INTO phonebook(users, number)
             VALUES('{}', {}) RETURNING users, number;"""
    conn = None
    try:
        # read database configuration
        params = config()
        # connect to the PostgreSQL database
        conn = psycopg2.connect(**params)
        # create a new cursor
        cur = conn.cursor()
        # execute the INSERT statement
        for i in list0:
            cur.execute(sql.format(i[0], i[1]))
        # commit the changes to the database
        conn.commit()
        # close communication with the database
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()


def csvTolist(filename):
    with open(filename, newline='') as f:
        reader = csv.reader(f)
        data = list(reader)
    return data


Do = input('By console(1) or by csv(2)\n')
if Do == '1':
    insert_one(input('username:\n'), input('phone number:\n'))
elif Do == '2':
    insert_list(csvTolist(input('filename:\n')))

import psycopg2
from config import config


def show_byCapital():
    sql = """
        SELECT * FROM phonebook WHERE users LIKE '{}%'
    """
    conn = None
    try:
        # read database configuration
        params = config()
        # connect to the PostgreSQL database
        conn = psycopg2.connect(**params)
        # create a new cursor
        cur = conn.cursor()
        cur.execute(sql.format(input('input capital of user:\n').capitalize()))
        myresult = cur.fetchall()
        for x in myresult:
            print(x)
        # close communication with the database
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()


def show_firstN():
    sql = """
        SELECT * FROM phonebook WHERE id <= {}; 
    """
    conn = None
    try:
        # read database configuration
        params = config()
        # connect to the PostgreSQL database
        conn = psycopg2.connect(**params)
        # create a new cursor
        cur = conn.cursor()
        cur.execute(sql.format(input('input id of last:\n')))
        myresult = cur.fetchall()
        for x in myresult:
            print(x)
        # close communication with the database
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()



def show_NtoM():
    sql = """
        SELECT * FROM phonebook WHERE id >= {} AND id < {};
    """
    conn = None
    try:
        # read database configuration
        params = config()
        # connect to the PostgreSQL database
        conn = psycopg2.connect(**params)
        # create a new cursor
        cur = conn.cursor()
        cur.execute(sql.format(input('id of first:\n'), input('id of last:\n')))
        myresult = cur.fetchall()
        for x in myresult:
            print(x)
        # close communication with the database
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()


mode = input("""Fileter by:
input 1, if by capital
input 2, if you want first n rows
input 3, if you want rows by numbers n to m\n""")

if mode == '1': show_byCapital()
elif mode == '2': show_firstN()
elif mode == '3': show_NtoM()
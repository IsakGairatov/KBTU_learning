import psycopg2
from config import config

list1 = [('Megan', '23456545'), ('Gleb', '34565456'), ('Nancy', '6789976588'), ('Felix', '34567656')]


def insList1(list0):
    conn = None
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        for i in list0:
            cur.execute("CALL insList(%s, %s)", (i[0], i[1]))
        cur.close()
        conn.commit()
    except(Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()


insList1(list1)
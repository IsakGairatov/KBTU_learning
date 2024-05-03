import psycopg2
from config import config


def AddUp(username, num):
    conn = None
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute("CALL InOrUp(%s, %s)", (username, num))
        cur.close()
        conn.commit()
    except(Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()


AddUp(input('user:\n'), input('number:\n'))
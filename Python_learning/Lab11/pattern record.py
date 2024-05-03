import psycopg2
from config import config


def showByLetter(let):
    conn = None
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.callproc('getPattern', (let.capitalize() + '%',))
        rows = cur.fetchall()
        for i in rows:
            print(i)
        cur.close()
    except(Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()


showByLetter(input('input first of name letter:\n'))
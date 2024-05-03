from configparser import ConfigParser
import psycopg2


def config(filename = 'data.ini', section = 'postsql'):
    parser = ConfigParser()
    parser.read(filename)

    db = {}
    if parser.has_section(section):
        params = parser.items(section)
        for i in params:
            db[i[0]] = i[1]
    else:
        raise Exception('Section {0} not found in the {1} file'.format(section, filename))
    return db
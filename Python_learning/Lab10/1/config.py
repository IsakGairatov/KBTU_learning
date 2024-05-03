from configparser import ConfigParser

import psycopg2


def config(filename = 'data.ini', section = 'postsql'):
    # create parser
    parser = ConfigParser()
    # read parser
    parser.read(filename)

    # get section default for postgress
    db = {}
    if parser.has_section(section):
        params = parser.items(section)
        for p in params:
            db[p[0]] = p[1]
    else:
        raise Exception('Section {0} not found in the {1} file'.format(section, filename))
    return db
    
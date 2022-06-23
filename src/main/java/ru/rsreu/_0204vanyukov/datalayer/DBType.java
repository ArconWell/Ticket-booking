package ru.rsreu._0204vanyukov.datalayer;

import ru.rsreu._0204vanyukov.datalayer.oracledb.factory.OracleDBDAOFactory;

import java.sql.Connection;
import java.sql.SQLException;

public enum DBType {
    ORACLE {
        @Override
        public DAOFactory getDAOFactory() {
            DAOFactory oracleDBDAOFactory = null;
            oracleDBDAOFactory = OracleDBDAOFactory.getInstance();
            return oracleDBDAOFactory;
        }
    };

    public static DBType getTypeByName(String dbType) {
        try {
            return DBType.valueOf(dbType.toUpperCase());
        } catch (Exception e) {
            throw new DBTypeException();
        }
    }

    public abstract DAOFactory getDAOFactory();
    }

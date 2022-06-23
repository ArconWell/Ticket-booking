package ru.rsreu._0204vanyukov.datalayer.oracledb.connectionpool;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class OracleConnectionPool {
    static DataSource ds;

    static {
            Context envCtx = null;
            try {
                envCtx = (Context) new InitialContext().lookup("java:comp/env");
                ds = (DataSource) envCtx.lookup("jdbc/oracle");
            } catch (NamingException e) {
                e.printStackTrace();
            }
    }

    private OracleConnectionPool() { }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

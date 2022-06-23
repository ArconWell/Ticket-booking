package ru.rsreu._0204vanyukov.datalayer.oracledb.factory;

import ru.rsreu._0204vanyukov.datalayer.DAOFactory;
import ru.rsreu._0204vanyukov.datalayer.IDAO.*;
import ru.rsreu._0204vanyukov.datalayer.oracledb.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class OracleDBDAOFactory extends DAOFactory {
    private static volatile OracleDBDAOFactory instance;
  //  private Connection connection;

    private OracleDBDAOFactory() {
    }

    public static OracleDBDAOFactory getInstance() {
        OracleDBDAOFactory factory = instance;
        if (instance == null) {
            synchronized (OracleDBDAOFactory.class) {
                instance = factory = new OracleDBDAOFactory();
            }
        }
        return factory;
    }

//    public void setConnection(Connection connection){
//        this.connection = connection;
//    }
//    public static OracleDBDAOFactory getInstance()
//            throws ClassNotFoundException, SQLException {
//        OracleDBDAOFactory factory = instance;
//        if (instance == null) {
//            synchronized (OracleDBDAOFactory.class) {
//                instance = factory = new OracleDBDAOFactory();
//                factory.connected();
//            }
//        }
//        return factory;
//    }

//    private void connected() throws ClassNotFoundException, SQLException {
//        Locale.setDefault(Locale.ENGLISH);
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        String url = "jdbc:oracle:thin:@localhost:1521:XE";
//        String user = "SYS as sysdba";
//        String password = "12345";
//        connection = DriverManager.getConnection(url, user, password);
//        System.out.println("Connected to oracle DB!");
//    }

    @Override
    public UsersDAO getUsersDAO() {
        return new OracleUsersDAO(connection);
    }

    @Override
    public UserGroupsDAO getUserGroupsDAO() {
        return new OracleUserGroupsDAO(connection);
    }

    @Override
    public CardInformationDAO getCardInformationDAOO() {
        return new OracleCardInformationDAO(connection);
    }

    @Override
    public DocumentsDAO getDocumentsDAO() {
        return new OracleDocumentsDAO(connection);
    }

    @Override
    public TicketsDAO getTicketsDAO() {
        return new OracleTicketsDAO(connection);
    }

    @Override
    public FlightsDAO getFlightsDAO() {
        return new OracleFlightsDAO(connection);
    }

    @Override
    public CitiesDAO getCitiesDAO() {
        return new OracleCitiesDAO(connection);
    }

    @Override
    public CountriesDAO getCountriesDAO() {
        return new OracleCountriesDAO(connection);
    }
}
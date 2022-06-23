package ru.rsreu._0204vanyukov.datalayer;

import oracle.net.nt.ConnectDescription;
import ru.rsreu._0204vanyukov.datalayer.IDAO.*;

import java.sql.Connection;

public abstract class DAOFactory {
    protected Connection connection;

    public static DAOFactory getInstance(DBType dbType) {
        DAOFactory result = dbType.getDAOFactory();
        return result;
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    public abstract UsersDAO getUsersDAO();
    public abstract UserGroupsDAO getUserGroupsDAO();
    public abstract CardInformationDAO getCardInformationDAOO();
    public abstract DocumentsDAO getDocumentsDAO();
    public abstract TicketsDAO getTicketsDAO();
    public abstract FlightsDAO getFlightsDAO();
    public abstract CitiesDAO getCitiesDAO();
    public abstract CountriesDAO getCountriesDAO();


}

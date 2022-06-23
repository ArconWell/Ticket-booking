package ru.rsreu._0204vanyukov.logic;

import ru.rsreu._0204vanyukov.datalayer.IDAO.CitiesDAO;
import ru.rsreu._0204vanyukov.datalayer.IDAO.FlightsDAO;
import ru.rsreu._0204vanyukov.datalayer.oracledb.connectionpool.OracleConnectionPool;
import ru.rsreu._0204vanyukov.model.Cities;
import ru.rsreu._0204vanyukov.model.Flights;

import java.sql.Connection;
import java.util.List;

public class CitiesLogic extends Logic{
    public static List<Cities> GetCities(){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        CitiesDAO citiesDAO = DAOFactory.getCitiesDAO();

        List<Cities> cities = citiesDAO.getCities();

        OracleConnectionPool.closeConnection(connection);
        return cities;
    }
}

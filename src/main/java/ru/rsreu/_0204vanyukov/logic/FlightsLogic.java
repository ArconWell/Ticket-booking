package ru.rsreu._0204vanyukov.logic;

import ru.rsreu._0204vanyukov.datalayer.IDAO.FlightsDAO;
import ru.rsreu._0204vanyukov.datalayer.IDAO.UsersDAO;
import ru.rsreu._0204vanyukov.datalayer.oracledb.connectionpool.OracleConnectionPool;
import ru.rsreu._0204vanyukov.model.Flights;
import ru.rsreu._0204vanyukov.model.Users;

import java.sql.Connection;
import java.util.List;

public class FlightsLogic extends Logic{

    public static void AddFlight(Flights flight){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        FlightsDAO flightsDAO = DAOFactory.getFlightsDAO();

        flightsDAO.addFlight(flight);

        OracleConnectionPool.closeConnection(connection);
    }

    public static List<Flights> GetFlights(){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        FlightsDAO flightsDAO = DAOFactory.getFlightsDAO();

        List<Flights> flights = flightsDAO.getFlights();

        OracleConnectionPool.closeConnection(connection);
        return flights;
    }
}

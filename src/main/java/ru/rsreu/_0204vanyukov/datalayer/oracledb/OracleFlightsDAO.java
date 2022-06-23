package ru.rsreu._0204vanyukov.datalayer.oracledb;

import ru.rsreu._0204vanyukov.datalayer.IDAO.FlightsDAO;
import ru.rsreu._0204vanyukov.model.Flights;
import ru.rsreu._0204vanyukov.resource.SQLQueriesManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleFlightsDAO implements FlightsDAO {

    private Connection connection;

    public OracleFlightsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Flights> getFlights() {
        List<Flights> flightsList = new ArrayList<>();
        Flights flight = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.flights");
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flight = new Flights(resultSet.getInt("id"),
                        resultSet.getInt("city_id"),
                        resultSet.getTimestamp("departure_date_time"),
                        resultSet.getInt("cost"));
                flightsList.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightsList;
    }

    @Override
    public void addFlight(Flights flight) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.add.flights");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, flight.getCity_id());
            preparedStatement.setTimestamp(2, flight.getDeparture_date_time());
            preparedStatement.setInt(3, flight.getCost());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFlight(Flights flight) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.flights");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, flight.getCity_id());
            preparedStatement.setTimestamp(2, flight.getDeparture_date_time());
            preparedStatement.setInt(3, flight.getCost());
            preparedStatement.setInt(4, flight.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFlight(Flights flight) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.delete.flights");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, flight.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

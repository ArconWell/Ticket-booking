package ru.rsreu._0204vanyukov.datalayer.oracledb;

import ru.rsreu._0204vanyukov.datalayer.IDAO.CitiesDAO;
import ru.rsreu._0204vanyukov.model.Cities;
import ru.rsreu._0204vanyukov.resource.SQLQueriesManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleCitiesDAO implements CitiesDAO {

    private Connection connection;

    public OracleCitiesDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Cities> getCities() {
        List<Cities> citiesList = new ArrayList<>();
        Cities city = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.cities");
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                city = new Cities(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("country_id"));
                citiesList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citiesList;
    }

    @Override
    public void addCity(Cities city) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.add.cities");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getCountry_id());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCity(Cities city) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.cities");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getCountry_id());
            preparedStatement.setInt(3, city.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(Cities city) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.delete.cities");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, city.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

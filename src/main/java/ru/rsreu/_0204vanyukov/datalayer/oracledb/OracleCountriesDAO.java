package ru.rsreu._0204vanyukov.datalayer.oracledb;

import ru.rsreu._0204vanyukov.datalayer.IDAO.CountriesDAO;
import ru.rsreu._0204vanyukov.model.Cities;
import ru.rsreu._0204vanyukov.model.Countries;
import ru.rsreu._0204vanyukov.resource.SQLQueriesManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleCountriesDAO implements CountriesDAO {

    private Connection connection;

    public OracleCountriesDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Countries> getCountries() {
        List<Countries> countriesList = new ArrayList<>();
        Countries country = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.countries");
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                country = new Countries(resultSet.getInt("id"),
                        resultSet.getString("name"));
                countriesList.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countriesList;
    }

    @Override
    public void addCountry(Countries country) {
        ;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.add.countries");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCountry(Countries country) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.countries");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCountry(Countries country) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.delete.countries");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, country.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

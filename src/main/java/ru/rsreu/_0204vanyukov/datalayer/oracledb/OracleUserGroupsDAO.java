package ru.rsreu._0204vanyukov.datalayer.oracledb;

import ru.rsreu._0204vanyukov.datalayer.IDAO.UserGroupsDAO;
import ru.rsreu._0204vanyukov.model.UserGroups;
import ru.rsreu._0204vanyukov.resource.SQLQueriesManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleUserGroupsDAO implements UserGroupsDAO {

    private Connection connection;

    public OracleUserGroupsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<UserGroups> getUserGroups() {
        List<UserGroups> userGroupsList = new ArrayList<>();
        UserGroups userGroup = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.user_groups");
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userGroup = new UserGroups(resultSet.getInt("id"),
                        resultSet.getString("name"));
                userGroupsList.add(userGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userGroupsList;
    }

    @Override
    public void addUserGroup(UserGroups userGroup) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.add.user_groups");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userGroup.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserGroup(UserGroups userGroup) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.user_groups");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userGroup.getName());
            preparedStatement.setInt(2, userGroup.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserGroup(UserGroups userGroup) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.delete.user_groups");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userGroup.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

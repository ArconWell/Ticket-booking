package ru.rsreu._0204vanyukov.datalayer.oracledb;

import ru.rsreu._0204vanyukov.datalayer.IDAO.UsersDAO;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.resource.SQLQueriesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleUsersDAO implements UsersDAO {
    private Connection connection;

    public OracleUsersDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void logiIn(Users user) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.user_authorized_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logOut(Users user) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.user_authorized_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users getUserByLogin(String login) {
        Users user = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.user_by_login");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new Users(resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("patronymic"),
                        resultSet.getDate("date_of_birth"),
                        resultSet.getInt("user_group_id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("authorized"),
                        resultSet.getBoolean("blocked"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//         finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return user;
    }

    @Override
    public void block(Users user) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.user_blocked_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unblock(Users user) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.user_blocked_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Users> getUsers() {
        List<Users> users = new ArrayList<>();
        Users user = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.users");
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new Users(resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("patronymic"),
                        resultSet.getDate("date_of_birth"),
                        resultSet.getInt("user_group_id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("authorized"),
                        resultSet.getBoolean("blocked"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Users> getAuthorizedUsers() {
        List<Users> users = new ArrayList<>();
        Users user = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.authorized_users");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new Users(resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("patronymic"),
                        resultSet.getDate("date_of_birth"),
                        resultSet.getInt("user_group_id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("authorized"),
                        resultSet.getBoolean("blocked"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Users> getBlockedUsers() {
        List<Users> users = new ArrayList<>();
        Users user = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.blocked_users");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new Users(resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("patronymic"),
                        resultSet.getDate("date_of_birth"),
                        resultSet.getInt("user_group_id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("authorized"),
                        resultSet.getBoolean("blocked"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Users> getNotBlockedUsers() {
        List<Users> users = new ArrayList<>();
        Users user = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.blocked_users");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 0);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new Users(resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("patronymic"),
                        resultSet.getDate("date_of_birth"),
                        resultSet.getInt("user_group_id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("authorized"),
                        resultSet.getBoolean("blocked"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void addUser(Users user) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.add.user");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getSurname());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPatronymic());
            preparedStatement.setDate(4, (Date) user.getDate_of_birth());
            preparedStatement.setInt(5, user.getUser_group_id());
            preparedStatement.setString(6, user.getLogin());
            preparedStatement.setString(7, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(Users user) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.user");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getSurname());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPatronymic());
            preparedStatement.setDate(4, (Date) user.getDate_of_birth());
            preparedStatement.setInt(5, user.getUser_group_id());
            preparedStatement.setString(6, user.getLogin());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setInt(8, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Users user) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.delete.user");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

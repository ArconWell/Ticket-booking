package ru.rsreu._0204vanyukov.logic;

import ru.rsreu._0204vanyukov.datalayer.IDAO.UsersDAO;
import ru.rsreu._0204vanyukov.datalayer.oracledb.connectionpool.OracleConnectionPool;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.model.enums.UserGroupsEnum;

import java.sql.Connection;
import java.util.List;

public class UsersLogic extends Logic{

    public static UserGroupsEnum GetUserGroupEnumValue(String login) {
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        Users user = usersDAO.getUserByLogin(login);
        int userGroupId = user.getUser_group_id();
        return UserGroupsEnum.getUserGroupEnumFromUserGroupId(userGroupId);
    }

    public static boolean CheckLogin(String login, String password) {
        Users user = GetUserByLogin(login);
        return user != null && password.equals(user.getPassword());
    }

    public static boolean IsUserBlocked(String login) {
        Connection connection = OracleConnectionPool.getConnection();

//        DAOFactory DAOFactory = ru.rsreu._0204vanyukov.datalayer.DAOFactory.getInstance(DBType.ORACLE);
        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        Users user = usersDAO.getUserByLogin(login);

        OracleConnectionPool.closeConnection(connection);
        return user.getBlocked();
    }

    public static void SetUserAuthorized(Users user) {
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        usersDAO.logiIn(user);

        OracleConnectionPool.closeConnection(connection);
    }

    public static void SetUserNotAuthorized(Users user) {
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        usersDAO.logOut(user);

        OracleConnectionPool.closeConnection(connection);
    }

    public static Users GetUserByLogin(String login) {
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        Users user = usersDAO.getUserByLogin(login);

        OracleConnectionPool.closeConnection(connection);
        return user;
    }

    public static List<Users> GetUsers(){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        List<Users> users = usersDAO.getUsers();

        OracleConnectionPool.closeConnection(connection);
        return users;
    }

    public static List<Users> GetAuthorizedUsers(){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        List<Users> users = usersDAO.getAuthorizedUsers();

        OracleConnectionPool.closeConnection(connection);
        return users;
    }

    public static void DeleteUserById(int userId){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        Users user = new Users();
        user.setId(userId);

        usersDAO.deleteUser(user);

        OracleConnectionPool.closeConnection(connection);
    }

    public static void AddUser(Users user){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        usersDAO.addUser(user);

        OracleConnectionPool.closeConnection(connection);
    }

    public static void BlockUserById(int userId){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        Users user = new Users();
        user.setId(userId);

        usersDAO.block(user);

        OracleConnectionPool.closeConnection(connection);
    }

    public static void UnBlockUserById(int userId){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        Users user = new Users();
        user.setId(userId);

        usersDAO.unblock(user);

        OracleConnectionPool.closeConnection(connection);
    }

    public static List<Users> GetBlockedUsers(){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        List<Users> users = usersDAO.getBlockedUsers();

        OracleConnectionPool.closeConnection(connection);
        return users;
    }

    public static List<Users> GetNotBlockedUsers(){
        Connection connection = OracleConnectionPool.getConnection();

        DAOFactory.setConnection(connection);
        UsersDAO usersDAO = DAOFactory.getUsersDAO();

        List<Users> users = usersDAO.getNotBlockedUsers();

        OracleConnectionPool.closeConnection(connection);
        return users;
    }
}

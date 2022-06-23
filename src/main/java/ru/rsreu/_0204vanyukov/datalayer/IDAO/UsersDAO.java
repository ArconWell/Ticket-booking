package ru.rsreu._0204vanyukov.datalayer.IDAO;

import ru.rsreu._0204vanyukov.model.Users;

import java.util.List;

public interface UsersDAO {
    void logiIn(Users user);
    void logOut(Users user);
    Users getUserByLogin(String login);
    void block(Users user);
    void unblock(Users user);
    List<Users> getUsers();
    List<Users> getAuthorizedUsers();
    List<Users> getBlockedUsers();
    List<Users> getNotBlockedUsers();
    void addUser(Users user);
    void updateUser(Users user);
    void deleteUser(Users user);
}

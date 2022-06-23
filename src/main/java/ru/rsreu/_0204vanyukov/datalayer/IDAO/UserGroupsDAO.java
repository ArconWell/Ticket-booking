package ru.rsreu._0204vanyukov.datalayer.IDAO;

import ru.rsreu._0204vanyukov.model.UserGroups;

import java.util.List;

public interface UserGroupsDAO {
    List<UserGroups> getUserGroups();
    void addUserGroup(UserGroups userGroup);
    void updateUserGroup(UserGroups userGroup);
    void deleteUserGroup(UserGroups userGroup);
}

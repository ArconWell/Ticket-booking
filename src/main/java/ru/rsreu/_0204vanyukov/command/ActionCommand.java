package ru.rsreu._0204vanyukov.command;

import ru.rsreu._0204vanyukov.model.UserGroups;
import ru.rsreu._0204vanyukov.model.enums.UserGroupsEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class ActionCommand {

    private List<UserGroupsEnum> allowedUsersGroups;

    public abstract String execute(HttpServletRequest request);

    public List<UserGroupsEnum> getAllowedUsersGroups() {
        return allowedUsersGroups;
    }

    protected void setAllowedUsersGroups(List<UserGroupsEnum> allowedUsersGroups) {
        this.allowedUsersGroups = allowedUsersGroups;
    }
}

package ru.rsreu._0204vanyukov.command.commandsRealisation.usersCommands;

import ru.rsreu._0204vanyukov.command.ActionCommand;
import ru.rsreu._0204vanyukov.logic.UsersLogic;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.model.enums.UserGroupsEnum;
import ru.rsreu._0204vanyukov.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class LogoutCommand extends ActionCommand {
    public LogoutCommand(){
        List<UserGroupsEnum> allowedUserGroups = new ArrayList<>();
        allowedUserGroups.add(UserGroupsEnum.USER);
        allowedUserGroups.add(UserGroupsEnum.MODERATOR);
        allowedUserGroups.add(UserGroupsEnum.ADMINISTRATOR);
        this.setAllowedUsersGroups(allowedUserGroups);
    }

    @Override
    public String execute(HttpServletRequest request){
        Users user = (Users) request.getSession().getAttribute("user");
        UsersLogic.SetUserNotAuthorized(user);
        request.getSession().invalidate();
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}

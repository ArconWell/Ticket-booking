package ru.rsreu._0204vanyukov.command.commandsRealisation.usersCommands;

import ru.rsreu._0204vanyukov.command.ActionCommand;
import ru.rsreu._0204vanyukov.logic.UsersLogic;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.model.enums.UserGroupsEnum;
import ru.rsreu._0204vanyukov.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class DeleteUserCommand extends ActionCommand {

    public DeleteUserCommand() {
        List<UserGroupsEnum> allowedUserGroups = new ArrayList<>();
        allowedUserGroups.add(UserGroupsEnum.ADMINISTRATOR);
        this.setAllowedUsersGroups(allowedUserGroups);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String userId = request.getParameter("user_id");
        Users curUser = (Users) request.getSession().getAttribute("user");

        if (curUser.getId() != Integer.parseInt(userId))
            UsersLogic.DeleteUserById(Integer.parseInt(userId));

        String page_path = UserGroupsEnum.ADMINISTRATOR.getPage();
        request.setAttribute("users", UsersLogic.GetUsers());
        request.setAttribute("authorized_users", UsersLogic.GetAuthorizedUsers());
        page = ConfigurationManager.getProperty(page_path);

        return page;
    }
}

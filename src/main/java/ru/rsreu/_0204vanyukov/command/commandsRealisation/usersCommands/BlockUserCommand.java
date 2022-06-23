package ru.rsreu._0204vanyukov.command.commandsRealisation.usersCommands;

import ru.rsreu._0204vanyukov.command.ActionCommand;
import ru.rsreu._0204vanyukov.logic.UsersLogic;
import ru.rsreu._0204vanyukov.model.enums.UserGroupsEnum;
import ru.rsreu._0204vanyukov.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class BlockUserCommand extends ActionCommand {
    public BlockUserCommand() {
        List<UserGroupsEnum> allowedUserGroups = new ArrayList<>();
        allowedUserGroups.add(UserGroupsEnum.MODERATOR);
        this.setAllowedUsersGroups(allowedUserGroups);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String userId = request.getParameter("user_id");

        UsersLogic.BlockUserById(Integer.parseInt(userId));

        String page_path = UserGroupsEnum.MODERATOR.getPage();

        request.setAttribute("blocked_users", UsersLogic.GetBlockedUsers());
        request.setAttribute("not_blocked_users", UsersLogic.GetNotBlockedUsers());
        page = ConfigurationManager.getProperty(page_path);

        return page;
    }
}

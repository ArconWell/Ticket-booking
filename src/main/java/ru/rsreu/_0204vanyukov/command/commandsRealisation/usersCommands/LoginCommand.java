package ru.rsreu._0204vanyukov.command.commandsRealisation.usersCommands;

import ru.rsreu._0204vanyukov.FrontController;
import ru.rsreu._0204vanyukov.command.ActionCommand;
import ru.rsreu._0204vanyukov.datalayer.DAOFactory;
import ru.rsreu._0204vanyukov.logic.CitiesLogic;
import ru.rsreu._0204vanyukov.logic.FlightsLogic;
import ru.rsreu._0204vanyukov.logic.UsersLogic;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.model.enums.UserGroupsEnum;
import ru.rsreu._0204vanyukov.resource.ConfigurationManager;
import ru.rsreu._0204vanyukov.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand extends ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public LoginCommand() {
        List<UserGroupsEnum> allowedUserGroups = new ArrayList<>();
        allowedUserGroups.add(UserGroupsEnum.USER);
        allowedUserGroups.add(UserGroupsEnum.MODERATOR);
        allowedUserGroups.add(UserGroupsEnum.ADMINISTRATOR);
        this.setAllowedUsersGroups(allowedUserGroups);
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);

        if (UsersLogic.CheckLogin(login, password)) {
            if (UsersLogic.IsUserBlocked(login)) {
                request.setAttribute("userBlockedMessage",
                        MessageManager.getProperty("message.userblockederror"));
                page = ConfigurationManager.getProperty("path.page.login");
            } else /* not blocked */ {
                HttpSession session = request.getSession();
                Users user = UsersLogic.GetUserByLogin(login);
                session.setAttribute("user", user);
                UsersLogic.SetUserAuthorized(user);

                UserGroupsEnum userGroupEnumValue = UsersLogic.GetUserGroupEnumValue(login);
                String page_path = userGroupEnumValue.getPage();
//                switch (userGroupEnumValue) {
//                    case USER:
//                        List<Users> users = UsersLogic.GetUsers();///////////
//                        request.setAttribute("flights", users);///////////
//                        page_path = "path.page.user_main";
//                        break;
//                    case MODERATOR:
//                        page_path = "path.page.moderator_main";
//                        break;
//                    case ADMINISTRATOR:
//                        page_path = "path.page.administrator_main";
//                        break;
//                    default:
//                        page_path = "path.page.error";
//                        break;
//                }
                request.setAttribute("user_name", user.getName());

                //для пользователей
                request.setAttribute("flights", FlightsLogic.GetFlights());

                //для модератора
                request.setAttribute("blocked_users", UsersLogic.GetBlockedUsers());
                request.setAttribute("not_blocked_users", UsersLogic.GetNotBlockedUsers());
                request.setAttribute("cities", CitiesLogic.GetCities());

                //для администратора
                request.setAttribute("users", UsersLogic.GetUsers());
                request.setAttribute("authorized_users", UsersLogic.GetAuthorizedUsers());
                page = ConfigurationManager.getProperty(page_path);
            }
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}

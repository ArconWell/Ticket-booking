package ru.rsreu._0204vanyukov.command.commandsRealisation.usersCommands;

import ru.rsreu._0204vanyukov.command.ActionCommand;
import ru.rsreu._0204vanyukov.logic.UsersLogic;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.model.enums.UserGroupsEnum;
import ru.rsreu._0204vanyukov.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class AddUserCommand extends ActionCommand {

    public AddUserCommand() {
        List<UserGroupsEnum> allowedUserGroups = new ArrayList<>();
        allowedUserGroups.add(UserGroupsEnum.ADMINISTRATOR);
        this.setAllowedUsersGroups(allowedUserGroups);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String patronymic = request.getParameter("patronymic");
        Date date_of_birth = Date.valueOf(request.getParameter("date_of_birth"));
        int user_group_id = Integer.parseInt(request.getParameter("user_group_id"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Users user = new Users(surname, name, patronymic, date_of_birth, user_group_id, login, password);
        UsersLogic.AddUser(user);

        String page_path = UserGroupsEnum.ADMINISTRATOR.getPage();
        request.setAttribute("users", UsersLogic.GetUsers());
        request.setAttribute("authorized_users", UsersLogic.GetAuthorizedUsers());
        page = ConfigurationManager.getProperty(page_path);

        return page;
    }
}

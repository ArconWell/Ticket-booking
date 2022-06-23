package ru.rsreu._0204vanyukov.command.commandsRealisation.flightsCommands;

import ru.rsreu._0204vanyukov.command.ActionCommand;
import ru.rsreu._0204vanyukov.logic.CitiesLogic;
import ru.rsreu._0204vanyukov.logic.FlightsLogic;
import ru.rsreu._0204vanyukov.logic.UsersLogic;
import ru.rsreu._0204vanyukov.model.Flights;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.model.enums.UserGroupsEnum;
import ru.rsreu._0204vanyukov.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AddFlightCommand extends ActionCommand {

    public AddFlightCommand() {
        List<UserGroupsEnum> allowedUserGroups = new ArrayList<>();
        allowedUserGroups.add(UserGroupsEnum.MODERATOR);
        this.setAllowedUsersGroups(allowedUserGroups);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        int city = Integer.parseInt(request.getParameter("city"));
        String departure_date_time_String = request.getParameter("departure_date_time").replace("T"," ") + ":00";
        Timestamp departure_date_time = Timestamp.valueOf(departure_date_time_String);
        int cost = Integer.parseInt(request.getParameter("cost"));

        Flights flight = new Flights(city, departure_date_time, cost);
        FlightsLogic.AddFlight(flight);

        String page_path = UserGroupsEnum.MODERATOR.getPage();
        request.setAttribute("blocked_users", UsersLogic.GetBlockedUsers());
        request.setAttribute("not_blocked_users", UsersLogic.GetNotBlockedUsers());
        request.setAttribute("cities", CitiesLogic.GetCities());
        page = ConfigurationManager.getProperty(page_path);

        return page;
    }
}

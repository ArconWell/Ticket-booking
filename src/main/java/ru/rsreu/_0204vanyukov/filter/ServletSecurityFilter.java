package ru.rsreu._0204vanyukov.filter;

import ru.rsreu._0204vanyukov.command.ActionCommand;
import ru.rsreu._0204vanyukov.command.CommandEnum;
import ru.rsreu._0204vanyukov.command.factory.ActionFactory;
import ru.rsreu._0204vanyukov.logic.UsersLogic;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.model.enums.UserGroupsEnum;
import ru.rsreu._0204vanyukov.resource.ConfigurationManager;
import ru.rsreu._0204vanyukov.resource.MessageManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

@WebFilter(urlPatterns = {"/*"})
public class ServletSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Users user = (Users) request.getSession().getAttribute("user");
        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.defineCommand(request);

        //проверяем является ли текущая команда командой логина
        boolean isCommandLogin = true;
        if (request.getParameter("command") != null) {
            String loginCommandName = CommandEnum.LOGIN.name();
            String currentCommandName = request.getParameter("command").toUpperCase();
            isCommandLogin = loginCommandName.equals(currentCommandName);
        }
        //если пользователь незалогинен
        if (user == null) {
            //если это не команда логина
            if (!isCommandLogin) {
                request.getSession().invalidate();
                String page = ConfigurationManager.getProperty("path.page.login");
                if (user != null) {
                    request.setAttribute("userBlockedMessage",
                            MessageManager.getProperty("message.userblockederror"));
                }
                response.sendRedirect(request.getContextPath() + page);
            }
        } else {
            /*если пользователь заблокирован*/
            if (UsersLogic.IsUserBlocked(user.getLogin())) {
                request.getSession().invalidate();
                String page = ConfigurationManager.getProperty("path.page.login");
                if (user != null) {
                    request.setAttribute("userBlockedMessage",
                            MessageManager.getProperty("message.userblockederror"));
                }
                response.sendRedirect(request.getContextPath() + page);
            } else /*если пользователь не заблокирован*/ {
                List<UserGroupsEnum> allowedUserGroupsEnum = command.getAllowedUsersGroups();
                UserGroupsEnum currentUserGroupEnum = UserGroupsEnum.getUserGroupEnumFromUserGroupId(user.getUser_group_id());
                //если у пользователя нет прав на доступ к команде
                if (allowedUserGroupsEnum == null || !allowedUserGroupsEnum.contains(currentUserGroupEnum)) {
                    request.getSession().invalidate();
                    String page = ConfigurationManager.getProperty("path.page.login");
                    request.setAttribute("notAllowedActionForUser",
                            MessageManager.getProperty("message.notallowedaction"));
                    response.sendRedirect(request.getContextPath() + page);
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

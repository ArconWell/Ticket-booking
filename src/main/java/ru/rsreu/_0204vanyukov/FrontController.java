package ru.rsreu._0204vanyukov;

import ru.rsreu._0204vanyukov.command.ActionCommand;
import ru.rsreu._0204vanyukov.command.factory.ActionFactory;
import ru.rsreu._0204vanyukov.datalayer.DAOFactory;
import ru.rsreu._0204vanyukov.datalayer.DBType;
import ru.rsreu._0204vanyukov.datalayer.oracledb.connectionpool.OracleConnectionPool;
import ru.rsreu._0204vanyukov.logic.Logic;
import ru.rsreu._0204vanyukov.logic.UsersLogic;
import ru.rsreu._0204vanyukov.resource.ConfigurationManager;
import ru.rsreu._0204vanyukov.resource.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/frontController")
public class FrontController extends HttpServlet {

    public static final String DAO_FACTORY_CONTEXT_ATTRIBUTE = "dao_factory";

    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().setAttribute(DAO_FACTORY_CONTEXT_ATTRIBUTE, DAOFactory.getInstance(DBType.ORACLE));
        Logic.setDAOFactory((DAOFactory) getServletContext().getAttribute(DAO_FACTORY_CONTEXT_ATTRIBUTE));
    }

    protected void goGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        String page = ConfigurationManager.getProperty("path.page.login");
        request.setAttribute("notAllowedActionForUser",
                MessageManager.getProperty("message.notallowedaction"));
        response.sendRedirect(request.getContextPath() + page);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.defineCommand(request);
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}

package ru.rsreu._0204vanyukov.session;

import ru.rsreu._0204vanyukov.logic.UsersLogic;
import ru.rsreu._0204vanyukov.model.Users;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se){
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        Users sessionUser = (Users) session.getAttribute("user");

        if(sessionUser != null){
            UsersLogic.SetUserNotAuthorized(sessionUser);
        }
    }
}

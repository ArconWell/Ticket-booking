package ru.rsreu._0204vanyukov.command;

import ru.rsreu._0204vanyukov.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand extends ActionCommand{
    @Override
    public String execute(HttpServletRequest request){
        // в случае ошибки или прямого обращения к контроллеру переадресация на страницу ввода лоигна
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}

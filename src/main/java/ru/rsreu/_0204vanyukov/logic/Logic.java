package ru.rsreu._0204vanyukov.logic;

import ru.rsreu._0204vanyukov.datalayer.DAOFactory;

public abstract class Logic {
    protected static DAOFactory DAOFactory;

    public static void setDAOFactory(DAOFactory daoFactory) {
        Logic.DAOFactory = daoFactory;
    }
}

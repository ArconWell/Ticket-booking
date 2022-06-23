package ru.rsreu._0204vanyukov.datalayer.IDAO;

import ru.rsreu._0204vanyukov.model.Cities;

import java.util.List;

public interface CitiesDAO {
    List<Cities> getCities();
    void addCity(Cities city);
    void updateCity(Cities city);
    void deleteCity(Cities city);
}

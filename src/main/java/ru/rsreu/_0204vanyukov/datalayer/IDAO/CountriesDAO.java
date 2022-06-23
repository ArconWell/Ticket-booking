package ru.rsreu._0204vanyukov.datalayer.IDAO;

import ru.rsreu._0204vanyukov.model.Countries;

import java.util.List;

public interface CountriesDAO {
    List<Countries> getCountries();
    void addCountry(Countries country);
    void updateCountry(Countries country);
    void deleteCountry(Countries country);
}

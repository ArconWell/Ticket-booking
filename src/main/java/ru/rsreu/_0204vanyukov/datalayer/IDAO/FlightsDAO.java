package ru.rsreu._0204vanyukov.datalayer.IDAO;

import ru.rsreu._0204vanyukov.model.Flights;

import java.util.List;

public interface FlightsDAO {
    List<Flights> getFlights();
    void addFlight(Flights flight);
    void updateFlight(Flights flight);
    void deleteFlight(Flights flight);
}

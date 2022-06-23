package ru.rsreu._0204vanyukov.model;

import java.sql.Timestamp;

public class Flights {
    int id;
    int city_id;
    Timestamp departure_date_time;
    int cost;

    public Flights(int city_id, Timestamp departure_date_time, int cost) {
        this.city_id = city_id;
        this.departure_date_time = departure_date_time;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public Timestamp getDeparture_date_time() {
        return departure_date_time;
    }

    public void setDeparture_date_time(Timestamp departure_date_time) {
        this.departure_date_time = departure_date_time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Flights(int id, int city_id, Timestamp departure_date_time, int cost) {
        this.id = id;
        this.city_id = city_id;
        this.departure_date_time = departure_date_time;
        this.cost = cost;
    }
}

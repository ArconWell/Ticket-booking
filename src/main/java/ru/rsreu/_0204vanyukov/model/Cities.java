package ru.rsreu._0204vanyukov.model;

public class Cities {
    int id;
    String name;
    int country_id;

    public Cities(int id, String name, int country_id) {
        this.id = id;
        this.name = name;
        this.country_id = country_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}


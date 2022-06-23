package ru.rsreu._0204vanyukov.model;

import java.sql.Date;

public class Users {
    int id;
    String surname;
    String name;
    String patronymic;
    Date date_of_birth;
    int user_group_id;
    String login;
    String password;
    Boolean authorized;
    Boolean blocked;

    public Users(int id, String surname, String name, String patronymic, Date date_of_birth,
                 int user_group_id, String login, String password, Boolean authorized, Boolean blocked) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.date_of_birth = date_of_birth;
        this.user_group_id = user_group_id;
        this.login = login;
        this.password = password;
        this.authorized = authorized;
        this.blocked = blocked;
    }

    public Users() {
    }

    public Users(String surname, String name, String patronymic, Date date_of_birth, int user_group_id, String login, String password) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.date_of_birth = date_of_birth;
        this.user_group_id = user_group_id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getUser_group_id() {
        return user_group_id;
    }

    public void setUser_group_id(int user_group_id) {
        this.user_group_id = user_group_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }
}

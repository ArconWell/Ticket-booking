package ru.rsreu._0204vanyukov.model;

import java.util.Date;

public class CardInformation {
    int id;
    int user_id;
    String card_number;
    Date card_date;
    int card_cvv;

    public CardInformation(int id, int user_id, String card_number, Date card_date, int card_cvv) {
        this.id = id;
        this.user_id = user_id;
        this.card_number = card_number;
        this.card_date = card_date;
        this.card_cvv = card_cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Date getCard_date() {
        return card_date;
    }

    public void setCard_date(Date card_date) {
        this.card_date = card_date;
    }

    public int getCard_cvv() {
        return card_cvv;
    }

    public void setCard_cvv(int card_cvv) {
        this.card_cvv = card_cvv;
    }
}

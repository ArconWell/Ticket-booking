package ru.rsreu._0204vanyukov.model;

public class Documents {
    int id;
    String document_number;
    int country_id;
    int user_id;
    String docyment_type;
    Boolean document_correct;

    public Documents(int id, String document_number, int country_id, int user_id, String docyment_type, Boolean document_correct) {
        this.id = id;
        this.document_number = document_number;
        this.country_id = country_id;
        this.user_id = user_id;
        this.docyment_type = docyment_type;
        this.document_correct = document_correct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDocyment_type() {
        return docyment_type;
    }

    public void setDocyment_type(String docyment_type) {
        this.docyment_type = docyment_type;
    }

    public Boolean getDocument_correct() {
        return document_correct;
    }

    public void setDocument_correct(Boolean document_correct) {
        this.document_correct = document_correct;
    }
}

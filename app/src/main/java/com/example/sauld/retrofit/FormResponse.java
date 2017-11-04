package com.example.sauld.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sauld on 4/11/2017.
 */

class FormResponse {


    @SerializedName("message")
    @Expose
    private String message;

    @Override
    public String toString() {
        return "FormResponse{" +
                "message='" + message + '\'' +
                ", form=" + form +
                '}';
    }

    @SerializedName("form")
    @Expose
    private Form form;
}

class Form {

    public String description;
    public String name;

    @Override
    public String toString() {
        return "Form{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}


package com.virtusa.voda.core.data;

import com.google.gson.Gson;

import java.lang.reflect.Field;

public class BaseData {
    public BaseData() {
        super();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

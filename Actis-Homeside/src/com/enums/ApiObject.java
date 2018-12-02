package com.enums;

import com.interfaces.PathElementInterface;

public enum ApiObject implements PathElementInterface {
    NONE(""),
    COMMAND("command/");

    @Override
    public String getPathValue() {
        return value;
    }

    private String value;

    ApiObject(String value) {
        this.value = value;
    }
}

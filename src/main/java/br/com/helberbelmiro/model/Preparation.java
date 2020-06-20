package br.com.helberbelmiro.model;

public class Preparation {

    private final int code;

    private final String description;

    public Preparation(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

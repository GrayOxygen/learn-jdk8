package com.shineoxygen.study.model;

public class Pear {
    private String type;
    private String color;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Pear{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

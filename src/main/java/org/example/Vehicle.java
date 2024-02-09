package org.example;

public record Vehicle(String type, String registration, String color) {

    @Override
    public String toString() {
        return color + " " + type + " with registration " + registration;
    }
}

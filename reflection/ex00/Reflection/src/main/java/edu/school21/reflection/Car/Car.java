package edu.school21.reflection.Car;

import java.util.StringJoiner;

public class Car {
    private String concern;
    private String model;
    private Integer price;

    public Car() {
        this.concern = "Default concern name";
        this.model = "Default model name";
        this.price = 0;
    }

    public Car(String concern, String model, Integer price) {
        this.concern = concern;
        this.model = model;
        this.price = price;
    }

    public Integer newPrice(Integer value) {
        this.price = value;
        return price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("concern='" + concern + "'")
                .add("model='" + model + "'")
                .add("price=" + price)
                .toString();
    }
}

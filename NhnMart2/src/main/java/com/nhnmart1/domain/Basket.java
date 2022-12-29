package com.nhnmart1.domain;


import java.util.ArrayList;

public class Basket {
    private final ArrayList<Food> basket = new ArrayList<>();

    public void add(Food food) {
        basket.add(food);
    }
    public ArrayList<Food> getBasket(){
        return basket;
    }
}

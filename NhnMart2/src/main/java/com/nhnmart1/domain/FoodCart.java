package com.nhnmart1.domain;

import java.util.ArrayList;

public class FoodCart {
    private final ArrayList<Food> myFoodList = new ArrayList<>();

    public void add(Food onion1) {
        myFoodList.add(onion1);
    }
    public void minus(Food onion1){
        myFoodList.remove(onion1);
    }

    public ArrayList<Food> getFoods(){
        return myFoodList;
    }


}

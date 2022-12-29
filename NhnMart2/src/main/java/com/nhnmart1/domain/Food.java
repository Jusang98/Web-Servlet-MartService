package com.nhnmart1.domain;


    public class Food {
        private String name;
        private int price;

        public Food(String name, int price) {
            super();
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
        public void setName(){
            this.name = name;
        }
        public void setPrice(){
            this.price = price;
        }
        @Override
        public String toString() {

            return name + price;
        }
    }


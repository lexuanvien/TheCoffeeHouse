package com.example.thecoffeehouse.gridviewadapter;

public class TheCoffeeHouse {
    String title, price;
    int images;

    public TheCoffeeHouse(String title, String price, int image) {
        this.images = image;
        this.title = title;
        this.price = price;
    }

    public int getImage() {
        return images;
    }

    public void setImage(int image) {
        this.images = image;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

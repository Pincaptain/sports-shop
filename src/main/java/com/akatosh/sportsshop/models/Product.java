package com.akatosh.sportsshop.models;

public class Product {
    private long id;
    private String name;
    private String description;
    private String link;
    private Category category;
    private Manufacturer manufacturer;

    public Product(long id, String name, String description, String link, Category category, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.link = link;
        this.category = category;
        this.manufacturer = manufacturer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}

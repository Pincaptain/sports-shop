package com.akatosh.sportsshop.models.view_models;

public class ProductViewModel {
    private long id;
    private String name;
    private String description;
    private String link;
    private long category;
    private long manufacturer;

    public ProductViewModel(long id, String name, String description, String link, long category, long manufacturer) {
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

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public long getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(long manufacturer) {
        this.manufacturer = manufacturer;
    }
}

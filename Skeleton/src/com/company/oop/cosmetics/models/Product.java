package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public abstract class Product implements com.company.oop.cosmetics.models.contracts.Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;

    public static final int MIN_PRICE = 0;

    private String name;
    private String brandName;
    private double price;
    private GenderType genderType;

    public Product(String name, String brandName, double price, GenderType genderType) {
        setName(name);
        setPrice(price);
        setBrandName(brandName);
        setGenderType(genderType);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Name");
        this.name = name;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        ValidationHelpers.validateStringLength(brandName,BRAND_NAME_MIN_LENGTH, BRAND_NAME_MAX_LENGTH, "Brand");
        this.brandName = brandName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("Price should be non negative.");
        }
        this.price = price;
    }

    @Override
    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {

        this.genderType = genderType;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(getName()).append(" ").append(getBrandName()).append(System.lineSeparator());
        sb.append(" #Price: $").append(getPrice()).append(System.lineSeparator());
        sb.append(" #Gender: ").append(getGenderType()).append(System.lineSeparator());
        return sb.toString();
    }
}

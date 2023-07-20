package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.Collections;
import java.util.List;

public class ToothpasteImpl extends Product implements Toothpaste {

    /*    public static final int NAME_MIN_LENGTH = 3;
        public static final int NAME_MAX_LENGTH = 10;
        public static final int BRAND_NAME_MIN_LENGTH = 2;
        public static final int BRAND_NAME_MAX_LENGTH = 10;*/
    public List<String> ingredients;

    public ToothpasteImpl(String name, String brandName, double price, GenderType genderType, List<String> ingredients) {
        super(name, brandName, price, genderType);
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.print());
        sb.append(" #Ingredients: ").append(ingredients);
        return sb.toString();
    }


    //This method should be uncommented when you are done with the class.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToothpasteImpl toothpaste = (ToothpasteImpl) o;
        return getName().equals(toothpaste.getName()) &&
                getBrandName().equals(toothpaste.getBrandName()) &&
                getPrice() == toothpaste.getPrice() &&
                this.getGenderType().equals(toothpaste.getGenderType()) &&
                getIngredients().equals(toothpaste.getIngredients());
    }
}

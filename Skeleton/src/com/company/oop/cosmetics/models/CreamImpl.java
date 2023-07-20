package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;

public class CreamImpl extends Product implements Cream {

    private ScentType scentType;

    public CreamImpl(String name, String brandName, double price, GenderType genderType, ScentType scentType) {
        super(name, brandName, price, genderType);
        setScentType(scentType);
    }


    public void setScentType(ScentType scentType) {
        this.scentType = scentType;
    }


    @Override
    public String print() {
        super.print();
        StringBuilder sb = new StringBuilder();
        sb.append(" #Scent: ").append(getScent()).append(System.lineSeparator());
        return sb.toString();
    }



    @Override
    public ScentType getScent() {
        return scentType;
    }
}

package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateShampooCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;
    private static final String SHAMPOO_CREATED = "Shampoo with name %s was created!";
    private static final String SHAMPOO_ALREADY_EXISTS = "Shampoo with name %s already exists!";

    private final CosmeticsRepository cosmeticsRepository;

    public CreateShampooCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    private String createShampoo(List<String> parameters) {
        if (cosmeticsRepository.productExist(parameters.get(0))) {
            throw new IllegalArgumentException(String.format(SHAMPOO_ALREADY_EXISTS, parameters.get(0)));
        }
        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        int milliliters = Integer.parseInt(parameters.get(4));
        UsageType usageType = ParsingHelpers.tryParseUsageType(parameters.get(5));

        cosmeticsRepository.createShampoo(name, brand, price, genderType, milliliters, usageType);

        return String.format(SHAMPOO_CREATED, name);
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return createShampoo(parameters);
    }

}

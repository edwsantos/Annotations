package com.infinity.annotation.processingexample;

import com.infinity.annotationprocessor.definition.FactoryElement;

@FactoryElement(id = "Amex", type = CreditCard.class)
public class AmericanExpress implements CreditCard {
    public AmericanExpress() {
    }

    public String getType() {
        return "American Express credit card";
    }
}

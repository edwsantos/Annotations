package com.infinity.annotation.processingexample;

import com.infinity.annotationprocessor.definition.FactoryElement;

@FactoryElement(id = "Visa", type = CreditCard.class)
public class Visa implements CreditCard {
    public Visa() {
    }

    public String getType() {
        return "Visa credit card";
    }
}

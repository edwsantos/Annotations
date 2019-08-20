package com.infinity.annotation.processingexample;

import com.infinity.annotationprocessor.definition.FactoryElement;

@FactoryElement(id = "Master", type = CreditCard.class)
public class MasterCard implements CreditCard {
    public MasterCard() {
    }

    public String getType() {
        return "MasterCard credit card";
    }
}

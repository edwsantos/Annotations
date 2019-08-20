package com.infinity.annotation.processingexample;



public class AnnotationProcessingApplication {

    public static void main(String[] args){
        CreditCardFactory creditCardFactory = new CreditCardFactory();
        final CreditCard creditCard = creditCardFactory.getCreditCard("visa");
        System.out.println(creditCard.getType());
    }
}

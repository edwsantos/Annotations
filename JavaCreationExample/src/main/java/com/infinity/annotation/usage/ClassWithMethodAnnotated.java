package com.infinity.annotation.usage;

import com.infinity.annotation.definition.MyPersonalAnnotationForMethod;

public class ClassWithMethodAnnotated {
    private String testAttribute;

    @MyPersonalAnnotationForMethod()
    public String testAnnotatedMethod(){
        return "This is an annotated test method";
    }

    @MyPersonalAnnotationForMethod("I can override the default value of an annotation")
    public String testOverridingAnnotatedMethod(){
        return "This is an annotated test method overriding the default value of the annotation";
    }
}

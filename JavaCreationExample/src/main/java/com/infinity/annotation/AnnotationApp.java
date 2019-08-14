package com.infinity.annotation;

import com.infinity.annotation.usage.ClassAnnotated;
import com.infinity.annotation.usage.ClassWithMethodAnnotated;

public class AnnotationApp {

    public static void main(String[] args){
        ClassAnnotated classAnnotated = new ClassAnnotated();
        classAnnotated.testMethod();

        ClassWithMethodAnnotated classWithMethodAnnotated = new ClassWithMethodAnnotated();
        classWithMethodAnnotated.testAnnotatedMethod();
        classWithMethodAnnotated.testOverridingAnnotatedMethod();
    }
}

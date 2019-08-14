package com.infinity.annotation.usage;

import com.infinity.annotation.definition.MyPersonalAnnotationForClasses;

@MyPersonalAnnotationForClasses(classAuthorName = "Test author", authorAge = 30)
public class ClassAnnotated {
    private String testAttribute;

    public String testMethod(){
        return "This is a test method";
    }
}

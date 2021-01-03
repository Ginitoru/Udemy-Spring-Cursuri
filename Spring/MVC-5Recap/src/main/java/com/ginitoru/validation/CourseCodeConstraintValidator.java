package com.ginitoru.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<Course, String> {

    private String prefix;

    @Override
    public void initialize(Course constraintAnnotation) {
        prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        if(theCode !=null){
           return  theCode.startsWith(prefix);
        }

        return false;
    }
}

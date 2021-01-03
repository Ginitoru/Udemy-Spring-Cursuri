package com.ginitoru.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Course {

    public String value() default "i";

    public String message() default "must start with i";
    //defineste default groups
    public Class <?>[] groups() default {};

    //defineste default payloads
    public Class<? extends Payload>[] payload() default {};


}

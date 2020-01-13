package com.example.ValidationDemo.customValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Documented
@Constraint(validatedBy = ServiceCodeInListValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public  @interface ServiceCodeInListConstraint {
	    String message() default "Invalid Service Code";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	    //String pattern();

}

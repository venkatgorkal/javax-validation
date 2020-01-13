package com.example.ValidationDemo.customValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Documented
@Constraint(validatedBy = ClaimTypeRequiredValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public  @interface ClaimTypeRequired {
	    String message() default "Claim Type Mandatory for Plan Type other than NS or CE";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	    String pattern();

}

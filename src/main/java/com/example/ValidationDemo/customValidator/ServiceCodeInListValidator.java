package com.example.ValidationDemo.customValidator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class ServiceCodeInListValidator  implements ConstraintValidator<ServiceCodeInListConstraint, Integer> {

	private String pattern;
	
    @Override
    public void initialize(ServiceCodeInListConstraint serviceCodeInListConstraint) {
    	//this.pattern = claimTypeRequired.pattern();
    }

    public boolean isValid(Integer value, ConstraintValidatorContext cxt) {
        //return contactField != null && contactField.matches("[0-9]+") && (contactField.length() > 8) && (contactField.length() < 14);
 
    	return (value != null && value == 11 || value == 12 || value == 21 || value == 41);
           
    }

}

package com.example.ValidationDemo.customValidator;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class ClaimTypeRequiredValidator  implements ConstraintValidator<ClaimTypeRequired, Object> {

	private String pattern;
	
    @Override
    public void initialize(ClaimTypeRequired claimTypeRequired) {
    	this.pattern = claimTypeRequired.pattern();
    }

    public boolean isValid(Object value, ConstraintValidatorContext cxt) {
        //return contactField != null && contactField.matches("[0-9]+") && (contactField.length() > 8) && (contactField.length() < 14);
    	
    	return true;
    }

}

package com.example.ValidationDemo.customValidator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class ClaimTypeInListValidator  implements ConstraintValidator<ClaimTypeInListConstraint, String> {

	private String pattern;
	
    @Override
    public void initialize(ClaimTypeInListConstraint claimTypeInListConstraint) {
    	//this.pattern = claimTypeRequired.pattern();
    }

    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        //return contactField != null && contactField.matches("[0-9]+") && (contactField.length() > 8) && (contactField.length() < 14);
    
    	List<String> claimTypeList = Arrays.asList("ELECTRONIC","PAPER","REKEY");
    	
    	if(value == null || value.isEmpty()) {
    		return true;
    	} else {
    		 return claimTypeList.contains(value);
    	}
    	//return (value != null && value.isEmpty() &&  claimTypeList.contains(value));
           
    }

}

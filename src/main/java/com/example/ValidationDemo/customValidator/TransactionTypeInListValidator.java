package com.example.ValidationDemo.customValidator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class TransactionTypeInListValidator  implements ConstraintValidator<TransactionTypeInListConstraint, String> {

	private String pattern;
	
    @Override
    public void initialize(TransactionTypeInListConstraint transactionTypeInListConstraint) {
    	//this.pattern = claimTypeRequired.pattern();
    }

    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        //return contactField != null && contactField.matches("[0-9]+") && (contactField.length() > 8) && (contactField.length() < 14);
    
    	List<String> transactionTypeList = Arrays.asList("837I","837P");
    	return (value != null &&  !transactionTypeList.contains(value));
           
    }

}

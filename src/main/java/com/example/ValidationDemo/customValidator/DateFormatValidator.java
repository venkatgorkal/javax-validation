package com.example.ValidationDemo.customValidator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class DateFormatValidator  implements ConstraintValidator<DateFormatConstraint, String> {
	
	static Date minimumDate= null;
	static Date maximumDate= null;
	static {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, Calendar.JANUARY, 1); //Year, month and day of month
		minimumDate = cal.getTime();
		cal.set(2026, Calendar.DECEMBER, 31); 
		maximumDate = cal.getTime();
				
	}

	private String pattern;
	
    @Override
    public void initialize(DateFormatConstraint dateFormatConstraint) {
    	this.pattern = dateFormatConstraint.pattern();
    }

    @Override
    public boolean isValid(String dateValue, ConstraintValidatorContext cxt) {
        //return contactField != null && contactField.matches("[0-9]+") && (contactField.length() > 8) && (contactField.length() < 14);
    	
    	if ( dateValue == null || dateValue.isEmpty()) {
            return true;
        }
        try {
            Date claimReceivedDate = new SimpleDateFormat(pattern).parse(dateValue);
            Date currentDate = new Date();
            if(claimReceivedDate.after(currentDate) ||  claimReceivedDate.before(DateFormatValidator.minimumDate)) {
            	return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

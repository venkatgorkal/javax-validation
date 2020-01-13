package com.example.ValidationDemo.customValidator;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClaimTypeRequiedForOtherPlanTypeValidator implements ConstraintValidator<ClaimTypeRequiredForOtherPlanType, Object>
{
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final ClaimTypeRequiredForOtherPlanType constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {
        try
        {
        	
            final Object claimType =  new BeanWrapperImpl(value).getPropertyValue( firstFieldName);
            final Object planType =  new BeanWrapperImpl(value).getPropertyValue( secondFieldName);
            if(claimType == null || claimType.toString().isEmpty() && !planType.toString().equals("NS")) {
            	return false;
            }
            return true;

            //return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
            // ignore
        }
        return true;
    }
}
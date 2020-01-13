package com.example.ValidationDemo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.ValidationDemo.customValidator.ClaimTypeInListConstraint;
import com.example.ValidationDemo.customValidator.ClaimTypeRequired;
import com.example.ValidationDemo.customValidator.DateFormatConstraint;
import com.example.ValidationDemo.customValidator.ServiceCodeInListConstraint;
import com.example.ValidationDemo.customValidator.TransactionTypeInListConstraint;
import com.example.ValidationDemo.customValidator.ClaimTypeRequiredForOtherPlanType;

@ClaimTypeRequiredForOtherPlanType.List({ @ClaimTypeRequiredForOtherPlanType(first = "claimType", second = "planType", message = "ClaimType Required if plan type other than NS or CE") })
public class ClaimNumberRequest {

	
	/*
	 * @Enumerated(EnumType.STRING) private ClaimType claimType;
	 */
	//@Pattern(regexp = "PAPER|REKEY|ELECTROINC", flags = Pattern.Flag.CASE_INSENSITIVE,message = "claim type should be PAPER or REKEY or ELECTROINC")
	@ClaimTypeInListConstraint
	private String claimType;


	
	@NotNull(message = "Plan Type cannot be null")
	@NotEmpty(message = "Plan Type cannot be empty")
	@Size(min = 2,message = "Plan Type length should not be less than 2")
	@Size(max = 2,message = "Plan Type length should not be greater than 2")
	private String planType;
    
	@DateFormatConstraint(pattern="yyyyMMdd")
	private String claimReceivedDate;
	
	
	private int billType;

	@Size(max = 15,message = "ISA Sender ID length must be less than or 15")
	private String isaSenderId;
	
	//@Pattern(regexp = "837I|837P", message = "Transaction type should be either 837I or 837P")
	
	@TransactionTypeInListConstraint
	private String transactionType;

	@ServiceCodeInListConstraint
	private int serviceCode;
	

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getClaimReceivedDate() {
		return claimReceivedDate;
	}

	public void setClaimReceivedDate(String claimReceivedDate) {
		this.claimReceivedDate = claimReceivedDate;
	}

	public String getIsaSenderId() {
		return isaSenderId;
	}

	public void setIsaSenderId(String isaSenderId) {
		this.isaSenderId = isaSenderId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(int serviceCode) {
		this.serviceCode = serviceCode;
	}


	
	

}



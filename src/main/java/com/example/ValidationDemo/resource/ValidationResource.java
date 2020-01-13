package com.example.ValidationDemo.resource;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ValidationDemo.model.ClaimNumberRequest;


@RestController
public class ValidationResource {
	 @PostMapping("/claim/create")
	   public ResponseEntity<Object> createClaim(@Valid @RequestBody ClaimNumberRequest claimNumberRequest) {
		   System.out.println("claimNumberRequest"+claimNumberRequest);
		   return ResponseEntity.noContent().build();
	}

}

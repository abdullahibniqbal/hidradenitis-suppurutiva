package com.shady.hidradenitis.suppurativa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shady.hidradenitis.suppurativa.aggregates.medicines.MedicinesAggregate;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.PrescribedMedicine;
import com.shady.hidradenitis.suppurativa.services.medicines.MedicinesService;

@RestController
@RequestMapping("/medicines")
public class MedicinesController {
	@Autowired
	private MedicinesService service;
	
	 @GetMapping("")
	 public MedicinesAggregate getMedicines() {
		 return service.getMedicines();
	 }
	 
	 @GetMapping("/prescriptions")
	 public MedicinesAggregate getPrescriptions() {
		 return service.getPrescriptions();
	 }
	 
	 @PutMapping("/prescriptions/prescribedMedicine")
	 public MedicinesAggregate updatePrescription(@RequestBody PrescribedMedicine prescribedMedicine) {
		 return service.updatePrescription(prescribedMedicine);
	 }
	 
	 @PostMapping("/prescriptions/prescribedMedicine")
	 public MedicinesAggregate addPrescribedMedicine(@RequestBody PrescribedMedicine prescribedMedicine) {
		 return service.addToPrescription(prescribedMedicine);
	 }
}

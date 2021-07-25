package com.shady.hidradenitis.suppurutiva.dtos.aggregates;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.shady.hidradenitis.suppurutiva.domain.medicines.Medicine;
import com.shady.hidradenitis.suppurutiva.domain.medicines.prescriptions.Prescription;

@JsonRootName("medicinesDetail")
@JsonInclude(Include.NON_NULL)
public class MedicinesAggregate {
	public List<Medicine> medicines;
	public Prescription prescription;
	
	public MedicinesAggregate(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	public MedicinesAggregate(Prescription prescription) {
		this.prescription = prescription;
	}
	
	public MedicinesAggregate() {}
}

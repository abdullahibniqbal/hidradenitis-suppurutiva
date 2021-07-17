package com.shady.hidradenitis.suppurativa.aggregates.medicines;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.shady.hidradenitis.suppurativa.domain.medicines.Medicine;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.Prescription;

@JsonRootName("medicinesDetail")
@JsonInclude(Include.NON_NULL)
public class MedicinesAggregate {
	public List<Medicine> medicines;
	public Prescription prescription;
}

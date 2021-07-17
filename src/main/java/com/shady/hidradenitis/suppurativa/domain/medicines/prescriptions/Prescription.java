package com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.shady.hidradenitis.suppurativa.domain.doctors.Doctor;
import com.shady.hidradenitis.suppurativa.domain.hospitals.Hospital;

public class Prescription {
	private List<PrescribedMedicine> prescribedMedicines = new ArrayList<PrescribedMedicine>();
	public Date creationDate;
	public Doctor doctor;
	public Hospital hospital;
	
	public void addPrescribedMedcine(PrescribedMedicine prescribedMedicine) {
		prescribedMedicines.add(prescribedMedicine);
	}
	
	public void deletePrescribedMedicine(String medicineName) {
		prescribedMedicines = 
				prescribedMedicines
				.stream()
				.filter(prescribedMedicine -> !prescribedMedicine.medicine.name.equals(medicineName))
				.collect(Collectors.toList());
	}
	
	public List<PrescribedMedicine> getPrescribedMedicines() {
		return prescribedMedicines;
	}
}

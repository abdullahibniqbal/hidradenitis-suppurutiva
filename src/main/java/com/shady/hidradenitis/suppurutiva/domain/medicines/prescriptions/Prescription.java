package com.shady.hidradenitis.suppurutiva.domain.medicines.prescriptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.shady.hidradenitis.suppurutiva.domain.doctors.Doctor;
import com.shady.hidradenitis.suppurutiva.domain.hospitals.Hospital;

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
	
	public void updatePrescribedMedicine(PrescribedMedicine newPrescribedMedicine) {
		prescribedMedicines = 
				prescribedMedicines
				.stream()
				.map(prescribedMedicine -> mapper(prescribedMedicine, newPrescribedMedicine))
				.collect(Collectors.toList());
	}
	
	public PrescribedMedicine mapper(PrescribedMedicine old, PrescribedMedicine toUpdate) {
		return old.medicine.name.equals(toUpdate.medicine.name)?
				toUpdate:
				old;
	}
}

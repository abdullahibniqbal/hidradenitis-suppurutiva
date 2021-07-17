package com.shady.hidradenitis.suppurativa.services.medicines.impls;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shady.hidradenitis.suppurativa.aggregates.medicines.MedicinesAggregate;
import com.shady.hidradenitis.suppurativa.domain.Quantity;
import com.shady.hidradenitis.suppurativa.domain.doctors.Doctor;
import com.shady.hidradenitis.suppurativa.domain.hospitals.Hospital;
import com.shady.hidradenitis.suppurativa.domain.medicines.Medicine;
import com.shady.hidradenitis.suppurativa.domain.medicines.Tablet;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.AmountAtTimeOfDay;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.PrescribedMedicine;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.Prescription;
import com.shady.hidradenitis.suppurativa.services.medicines.MedicinesService;

@Service
public class MedicinesServiceMock implements MedicinesService {

	@Override
	public MedicinesAggregate getMedicines() {
		List<Medicine> medicines = new LinkedList<Medicine>();
		medicines.add(new Tablet("Lasix", new Quantity(20f, "mg")));
		medicines.add(new Tablet("Neodipar", new Quantity(10f, "mg")));
		
		MedicinesAggregate medicinesAggregate = new MedicinesAggregate();
		medicinesAggregate.medicines = medicines;
		
		return medicinesAggregate;
	}

	@Override
	public MedicinesAggregate getPrescriptions() {
		Prescription prescription = new Prescription();
		prescription.creationDate = new Date();
		prescription.doctor = new Doctor("Rizwan Akram", 30);
		prescription.hospital = new Hospital("Agha Khan");
		
		PrescribedMedicine danzen = new PrescribedMedicine();
		danzen.medicine = new Tablet("Danzen", new Quantity(50f, "mg"));
		danzen.timesOfDay.add(new AmountAtTimeOfDay("Morning", new Quantity(1f, "tablet")));
		danzen.timesOfDay.add(new AmountAtTimeOfDay("Night", new Quantity(1f, "tablet")));
		danzen.prescribeTillDays(7);
		
		PrescribedMedicine lasix = new PrescribedMedicine();
		lasix.medicine = new Tablet("Lasix", new Quantity(20f, "mg"));
		lasix.timesOfDay.add(new AmountAtTimeOfDay("Morning", new Quantity(1f, "tablet")));
		lasix.timesOfDay.add(new AmountAtTimeOfDay("Night", new Quantity(1f, "tablet")));
		lasix.prescribeTillDays(7);
		
		prescription.addPrescribedMedcine(danzen);
		prescription.addPrescribedMedcine(lasix);
		
		MedicinesAggregate medicinesAggregate = new MedicinesAggregate();
		medicinesAggregate.prescription = prescription;
		
		return medicinesAggregate;
	}
}

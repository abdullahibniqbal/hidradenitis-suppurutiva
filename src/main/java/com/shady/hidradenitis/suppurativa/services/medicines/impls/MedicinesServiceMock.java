package com.shady.hidradenitis.suppurativa.services.medicines.impls;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shady.hidradenitis.suppurativa.aggregates.medicines.MedicinesAggregate;
import com.shady.hidradenitis.suppurativa.domain.Quantity;
import com.shady.hidradenitis.suppurativa.domain.medicines.Medicine;
import com.shady.hidradenitis.suppurativa.domain.medicines.Tablet;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.PrescribedMedicine;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.Prescription;
import com.shady.hidradenitis.suppurativa.services.medicines.MedicinesService;

@Service
public class MedicinesServiceMock implements MedicinesService {
	@Resource(name = "mockPrescription")
	private Prescription prescription;

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
		MedicinesAggregate medicinesAggregate = new MedicinesAggregate();
		medicinesAggregate.prescription = prescription;
		
		return medicinesAggregate;
	}

	@Override
	public MedicinesAggregate updatePrescription(PrescribedMedicine prescribedMedicine) {
		prescription.updatePrescribedMedicine(prescribedMedicine);
		
		return new MedicinesAggregate(prescription);
	}

	@Override
	public MedicinesAggregate addToPrescription(PrescribedMedicine prescribedMedicine) {
		prescription.addPrescribedMedcine(prescribedMedicine);
		
		return new MedicinesAggregate(prescription);
	}
}

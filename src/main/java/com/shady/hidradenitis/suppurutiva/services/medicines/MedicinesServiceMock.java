package com.shady.hidradenitis.suppurutiva.services.medicines;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.shady.hidradenitis.suppurutiva.dtos.aggregates.MedicinesAggregate;
import com.shady.hidradenitis.suppurutiva.domain.medicines.Medicine;
import com.shady.hidradenitis.suppurutiva.domain.medicines.prescriptions.PrescribedMedicine;
import com.shady.hidradenitis.suppurutiva.domain.medicines.prescriptions.Prescription;

@Service
public class MedicinesServiceMock implements MedicinesService {
	@Lazy
	@Resource(name = "mockPrescription")
	private Prescription prescription;

	@Lazy
	@Autowired
	private List<Medicine> medicines;

	@Override
	public MedicinesAggregate getMedicines() {
		return new MedicinesAggregate(medicines);
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

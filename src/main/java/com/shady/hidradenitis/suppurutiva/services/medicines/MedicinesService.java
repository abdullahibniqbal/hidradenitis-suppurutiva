package com.shady.hidradenitis.suppurutiva.services.medicines;

import com.shady.hidradenitis.suppurutiva.dtos.aggregates.MedicinesAggregate;
import com.shady.hidradenitis.suppurutiva.domain.medicines.prescriptions.PrescribedMedicine;

public interface MedicinesService {
	MedicinesAggregate getMedicines();
	MedicinesAggregate getPrescriptions();
	MedicinesAggregate updatePrescription(PrescribedMedicine prescribedMedicine);
	MedicinesAggregate addToPrescription(PrescribedMedicine prescribedMedicine);
}

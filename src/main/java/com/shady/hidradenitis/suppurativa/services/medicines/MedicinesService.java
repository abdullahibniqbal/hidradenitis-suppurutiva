package com.shady.hidradenitis.suppurativa.services.medicines;

import com.shady.hidradenitis.suppurativa.aggregates.medicines.MedicinesAggregate;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.PrescribedMedicine;

public interface MedicinesService {
	MedicinesAggregate getMedicines();
	MedicinesAggregate getPrescriptions();
	MedicinesAggregate updatePrescription(PrescribedMedicine prescribedMedicine);
	MedicinesAggregate addToPrescription(PrescribedMedicine prescribedMedicine);
}

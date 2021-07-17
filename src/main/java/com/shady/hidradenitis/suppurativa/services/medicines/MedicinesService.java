package com.shady.hidradenitis.suppurativa.services.medicines;

import com.shady.hidradenitis.suppurativa.aggregates.medicines.MedicinesAggregate;

public interface MedicinesService {
	MedicinesAggregate getMedicines();
	MedicinesAggregate getPrescriptions();
}

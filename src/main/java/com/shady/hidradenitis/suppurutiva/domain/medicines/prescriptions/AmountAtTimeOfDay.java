package com.shady.hidradenitis.suppurutiva.domain.medicines.prescriptions;

import com.shady.hidradenitis.suppurutiva.domain.Quantity;

public class AmountAtTimeOfDay {
	public String timeOfDay;
	public Quantity quantity;
	
	public AmountAtTimeOfDay(String timeOfDay, Quantity quantity) {
		super();
		this.timeOfDay = timeOfDay;
		this.quantity = quantity;
	}
}

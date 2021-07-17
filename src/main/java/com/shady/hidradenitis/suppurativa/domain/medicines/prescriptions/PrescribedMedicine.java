package com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import com.shady.hidradenitis.suppurativa.domain.medicines.Medicine;

public class PrescribedMedicine {
	public Medicine medicine;
	public List<AmountAtTimeOfDay> timesOfDay = new LinkedList<AmountAtTimeOfDay>();
	private Calendar prescribedTill;
	
	public void prescribeTillDays(Integer days) {
		prescribedTill = Calendar.getInstance();
		prescribedTill.add(Calendar.DAY_OF_WEEK, days);
	}
	
	public Calendar getPrescribedTill() {
		return prescribedTill;
	}
}

package com.shady.hidradenitis.suppurativa.domain.medicines;

import com.shady.hidradenitis.suppurativa.domain.Quantity;

public abstract class Medicine {
	public String name;
	public Quantity dosage;
	public Medicine(String name, Quantity dosage) {
		super();
		this.name = name;
		this.dosage = dosage;
	}
}

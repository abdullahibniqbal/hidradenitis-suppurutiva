package com.shady.hidradenitis.suppurutiva.domain.medicines;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.shady.hidradenitis.suppurutiva.domain.Quantity;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
	@JsonSubTypes.Type(name = "ointment", value = Ointment.class),
	@JsonSubTypes.Type(name = "powder", value = Powder.class),
	@JsonSubTypes.Type(name = "syrup", value = Syrup.class),
	@JsonSubTypes.Type(name = "tablet", value = Tablet.class)
})
public abstract class Medicine {
	public String name;
	public Quantity dosage;
	public Medicine(String name, Quantity dosage) {
		super();
		this.name = name;
		this.dosage = dosage;
	}
}

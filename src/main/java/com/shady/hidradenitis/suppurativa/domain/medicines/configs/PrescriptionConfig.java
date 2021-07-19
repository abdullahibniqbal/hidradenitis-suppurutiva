package com.shady.hidradenitis.suppurativa.domain.medicines.configs;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.shady.hidradenitis.suppurativa.domain.Quantity;
import com.shady.hidradenitis.suppurativa.domain.doctors.Doctor;
import com.shady.hidradenitis.suppurativa.domain.hospitals.Hospital;
import com.shady.hidradenitis.suppurativa.domain.medicines.Tablet;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.AmountAtTimeOfDay;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.PrescribedMedicine;
import com.shady.hidradenitis.suppurativa.domain.medicines.prescriptions.Prescription;

@Configuration
public class PrescriptionConfig {
	@Bean(name = "mockPrescribedMedicines")
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public List<PrescribedMedicine> getMockPrescribedMedicines() {
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
		
		List<PrescribedMedicine> prescribedMedicines = new LinkedList<PrescribedMedicine>();
		prescribedMedicines.add(danzen);
		prescribedMedicines.add(lasix);
		
		return prescribedMedicines;
	}
	
	@Bean(name = "mockPrescription")
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public Prescription getMockPrescription(List<PrescribedMedicine> prescribedMedicines) {
		System.out.println("prescribed Medicines: " + prescribedMedicines);
		
		Prescription prescription = new Prescription();
		prescribedMedicines.forEach(prescribedMedicine -> prescription.addPrescribedMedcine(prescribedMedicine));
		prescription.creationDate = new Date();
		prescription.doctor = new Doctor("Rizwan Akram", 30);
		prescription.hospital = new Hospital("Agha Khan");
		
		return prescription;
	}
}

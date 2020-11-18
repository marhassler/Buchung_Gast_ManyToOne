package com.hassler.BuchungPOS;

import com.hassler.BuchungPOS.domain.Buchung;
import com.hassler.BuchungPOS.domain.Gast;
import com.hassler.BuchungPOS.repository.GastRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BuchungPosApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(BuchungPosApplication.class, args);
		GastRepository gastRepository = configurableApplicationContext.getBean(GastRepository.class);

		Gast gast = new Gast("Marco Hassler");
		Buchung buchung1= new Buchung("12234",gast);
		Buchung buchung2= new Buchung("24324",gast);
		List<Buchung> buchungen = Arrays.asList(buchung1,buchung2);
		gast.setBuchungen(buchungen);
		gastRepository.save(gast);
	}

}

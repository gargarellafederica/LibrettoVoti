package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {
	public static void main(String [] args) {
		Libretto libr = new Libretto();
		
		libr.add(new Voto(30, "Analisi I", LocalDate.of(2017, 1, 15)));
		libr.add(new Voto(25, "Chimica", LocalDate.of(2017, 1, 28)));
		libr.add(new Voto(21, "Fisica I", LocalDate.of(2017, 7, 16)));
		libr.add(new Voto(18, "Informatica", LocalDate.of(2017, 6, 25)));
		libr.add(new Voto(28, "Analisi II", LocalDate.of(2018, 2, 15)));
		libr.add(new Voto(25, "Fisica II", LocalDate.of(2018, 2, 23)));
		libr.add(new Voto(25, "Geometria", LocalDate.of(2017, 9, 10)));
		libr.add(new Voto(27, "Programmazione a Oggetti", LocalDate.of(2019, 7, 3)));
		libr.add(new Voto(24, "Economia", LocalDate.of(2019, 9, 5)));
		libr.add(new Voto(20, "Ricerca Operativa", LocalDate.of(2018, 7, 21)));

		List<Voto> venticinque =libr.cercaVoti(25);
		System.out.println(venticinque);
		
		Voto a1 = libr.cercaEsame("Analisi I");
		Voto a3 = libr.cercaEsame("Analisi III");
		System.out.println(a1);
		System.out.println(a3);

		//verifichiamo se esistono già i voti
		
		Voto giusto = new Voto(25, "Geometria", LocalDate.now());
		Voto sbagliato = new Voto(18, "Geometria", LocalDate.now());
		Voto mancante = new Voto(30, "Analisi III", LocalDate.now());

		System.out.format("Il voto %s è %s\n", giusto.toString(), libr.esisteVoto(giusto));
		System.out.format("Il voto %s è %s\n", sbagliato.toString(), libr.esisteVoto(sbagliato));
		System.out.format("Il voto %s è %s\n", mancante.toString(), libr.esisteVoto(mancante));

		System.out.format("Il voto %s è in conflitto: %s\n", giusto.toString(), libr.conflittoVoto(giusto));
		System.out.format("Il voto %s è in conflitto: %s\n", sbagliato.toString(), libr.conflittoVoto(sbagliato));
		System.out.format("Il voto %s è in conflitto: %s\n", mancante.toString(), libr.conflittoVoto(mancante));

	}

}

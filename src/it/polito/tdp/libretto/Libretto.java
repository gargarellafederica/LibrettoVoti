package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;

	public Libretto() {
		this.voti =new ArrayList<Voto>();
	}
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 * @return {@code true} se ha aggiunto il voto, 
	 * {@code false} altrimenti
	 */
	public boolean add(Voto v) {
		//aggiungo se non esiste già o se non genera conflitto
		if(!this.esisteVoto(v) && !this.conflittoVoto(v)) {
			voti.add(v);
			return true;
		}
		else return false;
	}
	
	//ritorno una lista e non la stampa della stringa per rendere il programma in modo più generale possibile 
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
	 * @param punti punteggio da ricercare
	 * @return lista di {@link Voto } aventi quel punteggio (eventualmente vuota)
	 */
	public List<Voto> cercaVoti(int voto) {
		
		List<Voto> result= new ArrayList<Voto>();
		for(Voto v:voti)
			if(v.getPunti()==voto)
				result.add(v);
		return result;
	}
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@code null} se non esistente
	 */
	public Voto cercaEsame(String nomeEsame) {
		Voto voto= new Voto(0, nomeEsame, null);
		int pos = this.voti.indexOf(voto);
		if (pos==-1)
			return null;
		else return this.voti.get(pos);
	}
	
	/**
	 * Dato un {@link Voto} determina se esiste già un voto con uguale
	 * corso e punteggio
	 * 
	 * @param v voto da trovare
	 * @return {@code true}, se ha trovato un corso e punteggio uguali,
	 * {@code false} se non ha trovato il corso, oppure l'ha trovato con voto diverso
	 */
	boolean esisteVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		if (pos==-1)
			return false;
		else return this.voti.get(pos).getPunti()==v.getPunti();
	}

	/**
	 * Dato un {@link Voto} {@code v} dice se è in conflitto con i voti esistenti
	 * Se il voto non esiste non c'è conflitto, se esiste ed ha voto diverso c'è conflitto
	 * 
	 * @param v voto da trovare
	 * @return {@code true}, se ha trovato un conflitto,
	 * {@code false} se non ha trovato conflitto, quindi il voto non esiste oppure esiste con lo stesso punteggio
	 */
	boolean conflittoVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		if (pos==-1)
			return false;
		else return this.voti.get(pos).getPunti()!=v.getPunti();
	}

	public String toString() {
		return this.voti.toString();
	}
	
	
}

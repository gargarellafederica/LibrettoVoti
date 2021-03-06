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
		//aggiungo se non esiste gi� o se non genera conflitto
		if(!this.esisteVoto(v) && !this.conflittoVoto(v)) {
			this.voti.add(v);
			return true;
		}
		else return false;
	}
	
	//ritorno una lista e non la stampa della stringa per rendere il programma in modo pi� generale possibile 
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
	 * @param punti punteggio da ricercare
	 * @return lista di {@link Voto } aventi quel punteggio (eventualmente vuota)
	 */
	public List<Voto> cercaVoti(int voto) {
		
		List<Voto> result= new ArrayList<Voto>();
		for(Voto v:this.voti)
			if(v.getPunti()==voto)
				result.add(v);
		return result;
	}
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui � specificato il nome
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
	 * Dato un {@link Voto} determina se esiste gi� un voto con uguale
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
	 * Dato un {@link Voto} {@code v} dice se � in conflitto con i voti esistenti
	 * Se il voto non esiste non c'� conflitto, se esiste ed ha voto diverso c'� conflitto
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
	
	public Libretto LibrettoMigliorato() {
		Libretto nuovoLib= new Libretto();
		for(Voto v: this.voti) {
			nuovoLib.add(v.clone());
		}
		for(Voto v: nuovoLib.voti) {
			if(v.getPunti()>=18 && v.getPunti()<24)
				v.setPunti(v.getPunti()+1);
			else if(v.getPunti()>=24 && v.getPunti()<29)
				v.setPunti(v.getPunti()+2);
		}
		return nuovoLib;
	}
	
	//non devo ritornare il libretto perch� lo sto semplicemente modificando non ne sto creando uno nuovo
	public void rimuoviVoto(int voto) {
		List<Voto> cancellare= new ArrayList<>();
		for (Voto v: this.voti)
			if (v.getPunti()<voto)
				cancellare.add(v);
		this.voti.removeAll(cancellare);
	}
}

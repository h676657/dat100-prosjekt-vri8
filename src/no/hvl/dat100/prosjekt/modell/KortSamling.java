package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		
		// TODO - START
		samling = new Kort[MAKS_KORT];
		antall = 0;
		
		// TODO - END
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		
		return samling;
		
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		// TODO - START
		return antall;
		
		
		// TODO - END
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		
		// TODO - START
		return (antall == 0);
		
		
		// TODO - END
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		
		// TODO - START
		if(antall < MAKS_KORT) {
			samling[antall] = kort;
			antall++;
		}
		//throw new UnsupportedOperationException(TODO.method());
		// TODO - END
		
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {
		
		// TODO - START
		// Husk: bruk Regler.MAKS_KORT_FARGE for å få antall kort per farge
	    int antallKort = 0;

	    for (int farge = 0; farge < 4; farge++) {
	        for (int verdi = 1; verdi <= Regler.MAKS_KORT_FARGE; verdi++) {
	        	Kort kort = new Kort(Kortfarge.values()[farge], verdi);	
	            samling[antallKort] = kort;
	            antallKort++;
	        }
	    }

	    antall = antallKort;
		

		//throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		
		// TODO - START
		for(int i = 0; i < antall; i++) {
			samling[i] = null;
		}
		antall = 0;
		//throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}
	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		
		// TODO - START
		if (antall > 0){
			return samling[antall - 1];
					
		}else {
			return null;
		}
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - END
		
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		
		// TODO - START
		if(antall > 0) {
			Kort sisteKort = samling[antall - 1];
			samling[antall - 1] = null;
			antall--;
			return sisteKort;
		}else {
			return null;
		}
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
	}
	
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		// TODO - START
		for(int i = 0; i < antall; i++) {
			if(samling[i].equals(kort)) {
				return true;
			}
		}
		return false;
		//throw new UnsupportedOperationException(TODO.method());
		// return false;
		// TODO - END
		
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) {
		
		// TODO - START
		for(int i = 0; i < antall; i++) {
			if(samling[i].equals(kort)) {
				//Bytter kort for å fylle tomrommet
				for(int j = i; j < antall - 1; j++) {
					samling[j] = samling[j + 1];
				}
				samling[antall - 1] = null;
				antall--;
				return true;
			}
		}
		return false;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {
		
		// TODO - START
	    Kort[] alleKort = new Kort[antall];
	    for (int i = 0; i < antall; i++) {
	        alleKort[i] = samling[i];
	    }
	    return alleKort;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	
	}
	
}

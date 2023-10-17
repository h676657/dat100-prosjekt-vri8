package no.hvl.dat100.prosjekt.modell;

import java.util.Random;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortSamling;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		// TODO - START
		Kort[] kort = samling.getSamling();
		int antallKort = samling.getAntalKort();
		
		
		for(int i = 0; i < antallKort - 1; i++) {
			for(int j = 0; j < antallKort - i - 1; j++) {
				if(kort[j].compareTo(kort[j + 1]) > 0) {
					Kort temp = kort[j];
					kort[j] = kort[j +1];
					kort[j + 1] = temp;
				}
			}
		}
		//throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		// TODO - START
		Kort[] kort = samling.getSamling();
		int antallKort = samling.getAntalKort();
		Random rand = new Random();
		for (int i = 0; i < antallKort; i++) {
			int tilfeldigIndex = rand.nextInt(antallKort);
			Kort temp = kort[i];
			kort[i] = kort[tilfeldigIndex];
			kort[tilfeldigIndex] = temp;
		}
		//throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}
	
}

package niv;

import java.util.ArrayList;

public interface Menuable {
	void addInstruments(ArrayList<MusicalInstrument> allInstruments, MusicalInstrument addedInstrument);

	boolean removeInstruments(ArrayList<MusicalInstrument> allInstruments, MusicalInstrument removedInstrument);

	void removeAll(ArrayList<MusicalInstrument> allInstruments);

}

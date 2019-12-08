package niv;

import java.util.ArrayList;

public class AfekaInventory implements Menuable {
	ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
	private Number totalPrice;
	private boolean isSort;

	public AfekaInventory() {

	}

	public ArrayList<MusicalInstrument> getAllInstruments() {
		return allInstruments;
	}

	public void setAllInstruments(ArrayList<MusicalInstrument> allInstruments) {
		this.allInstruments = allInstruments;
	}

	@Override
	public void addInstruments(ArrayList<MusicalInstrument> allInstrumenst, MusicalInstrument musicalInstrumenst) {
		allInstrumenst.add(musicalInstrumenst);

	}

	@Override
	public boolean removeInstruments(ArrayList<MusicalInstrument> allInstruments,
			MusicalInstrument musicalInstrumenst) {
		allInstruments.remove(musicalInstrumenst);

		return true;

	}

	@Override
	public void removeAll(ArrayList<MusicalInstrument> mus) {
		mus.clear();
		isSort = false;
	}

	//public String toString() {
		//return String.format("Total Price: %7.2f     Sorted: %b ", SetTotalPrice(totalPrice), isSort);
//	}

}
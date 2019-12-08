package niv;

import java.util.InputMismatchException;
import java.util.Scanner;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class Stringinstrument extends MusicalInstrument {
	private int numOfStrings;
	Alert alert = new Alert(AlertType.ERROR);
	public Stringinstrument(String brand, Number price, int numOfStrings) {
		super(brand, price);
		setNumOfStrings(numOfStrings);
	}

	public Stringinstrument(Scanner scanner) {
		super(scanner);
		int numOfStrings;
		numOfStrings = scanner.nextInt();
		setNumOfStrings(numOfStrings);
	}

	public void setNumOfStrings(int numOfStrings) {
		if (numOfStrings < 1) {
			alert.setTitle("Eror");
			alert.setHeaderText("Eror");
			alert.setContentText("Number of String cannot be nagative! ");
			alert.showAndWait();
		}
		else if (numOfStrings>8) {
			alert.setTitle("Eror");
			alert.setHeaderText("Eror");
			alert.setContentText("Number of String can be number between 6-8  ");
			alert.showAndWait();
			
		}
		this.numOfStrings = numOfStrings;
	}

	public int getNumOfStrings() {
		return numOfStrings;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		if (!(o instanceof Stringinstrument))
			return false;

		return getNumOfStrings() == ((Stringinstrument) o).getNumOfStrings();
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" Number of strings: %2d| ", getNumOfStrings());
	}

	@Override
	public Stringinstrument clone() throws CloneNotSupportedException {
		return (Stringinstrument) super.clone();
	}
}

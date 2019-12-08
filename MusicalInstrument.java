package niv;

import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class MusicalInstrument implements InstrumentsFunc {
	private Number price;
	private String brand;
	Alert alert = new Alert(AlertType.ERROR);

	public MusicalInstrument(String brand, Number price) {
		setBrand(brand);
		setPrice(price);
	}

	public MusicalInstrument(Scanner scanner) {
		Number price = 0;
		String brand;

		try {
			price = scanner.nextDouble();
		} catch (InputMismatchException ex) {
			throw new InputMismatchException("Price not found!");
		}
		setPrice(price);
		scanner.nextLine();
		brand = scanner.nextLine();
		setBrand(brand);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Number getPrice() {

		return price;
	}

	public void setPrice(Number price) {
		if (price.doubleValue() < 0) {
			alert.setTitle("Eror");
			alert.setHeaderText("Eror");
			alert.setContentText("Price must be positive number ");
			alert.showAndWait();
		}
		this.price = (Number) price;
	}

	protected boolean isValidType(String[] typeArr, String material) {
		for (int i = 0; i < typeArr.length; i++) {
			if (material.equals(typeArr[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MusicalInstrument))
			return false;
		MusicalInstrument other = (MusicalInstrument) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-8s %-9s| Price: %7.1f,", getBrand(), getClass().getSimpleName(), getPrice());
	}

	@Override
	public int compareTo(MusicalInstrument other) {
		if (other.getBrand().compareTo(this.getBrand()) < 0)
			return 1;
		if (other.getBrand().compareTo(this.getBrand()) > 0)
			return -1;

		if (other.getPrice().doubleValue() < this.getPrice().doubleValue())
			return 1;

		if (other.getPrice().doubleValue() > this.getPrice().doubleValue())
			return -1;

		return 0;
	}

	@Override
	public MusicalInstrument clone() throws CloneNotSupportedException {
		return (MusicalInstrument) super.clone();

	}

}

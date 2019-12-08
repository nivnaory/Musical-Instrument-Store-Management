package niv;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Center_Top_Buttons {
	ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
	GridPane gridPane = new GridPane();
	HBox hbox = new HBox();
	static TextField textfiled = new TextField();
	static TextField textfiled1 = new TextField();
	static TextField textfiled2 = new TextField();
	TextField searchinstrument = new TextField();
	Stage stage = new Stage();
	Button add = new Button("Add");
	Label typename = new Label("Type: ");
	Label brandname = new Label("Brand: ");
	Label price = new Label("Price: ");
	private String type;
	private String brand;
	private Number price2;
	private static int index = 0;

	public Center_Top_Buttons(ArrayList<MusicalInstrument> allInstruments) {
		setAllInstruments(allInstruments);

	}

	public GridPane setGridPane(GridPane gridPane) {
		Scene scene = new Scene(gridPane);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(5, 10, 10, 10));
		
		getInstrumesnt(getAllInstruments());
		GridPane.setConstraints(typename, 0, 0);
		GridPane.setConstraints(textfiled, 2, 0);

		GridPane.setConstraints(brandname, 0, 1);
		GridPane.setConstraints(textfiled1, 2, 1);

		GridPane.setConstraints(price, 0, 2);
		GridPane.setConstraints(textfiled2, 2, 2);

		stage.setScene(scene);
		gridPane.getChildren().addAll(typename, textfiled, brandname, textfiled1, price, textfiled2);
		return gridPane;
	}

	public void getInstrumesnt(ArrayList<MusicalInstrument> allInstruments) {
		if (allInstruments.size() != 0) {

			if (index == allInstruments.size()) {
				index = 0;
			} else if (index == -1) {
				index = allInstruments.size() - 1;

			}
			textfiled.setText(allInstruments.get(index).getClass().getSimpleName());
			textfiled.setEditable(false);
			textfiled1.setText(allInstruments.get(index).getBrand());
			textfiled1.setEditable(false);
			textfiled2.setText(String.valueOf(allInstruments.get(index).getPrice()));
			textfiled2.setEditable(false);
		} else {
			textfiled.setText("no items");
			textfiled.setEditable(false);
			textfiled1.setText("no items");
			textfiled1.setEditable(false);
			textfiled2.setText("no items");
			textfiled2.setEditable(false);
		}
	}

	public void switchInstruments(boolean forword) {
		if (forword == true) {
			index++;
			getInstrumesnt(getAllInstruments());
		} else {
			index--;
			getInstrumesnt(getAllInstruments());

		}
	}

	public VBox setOnRight(VBox vbox) {
		vbox = new VBox(5);
		Button right = new Button(">");
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setAlignment(Pos.CENTER_RIGHT);
		right.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				switchInstruments(true);

			}
		});

		vbox.getChildren().add(right);
		return vbox;
	}

	public VBox setOnLeft(VBox vbox) {
		vbox = new VBox(5);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		Button left = new Button("<");
		vbox.setAlignment(Pos.CENTER_LEFT);
		left.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				switchInstruments(false);

			}
		});

		vbox.getChildren().add(left);
		return vbox;
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public HBox getTopwindow(HBox layout) {
		Scene scene = new Scene(layout);
		searchinstrument.setPromptText("search");
		searchinstrument.setPrefWidth(640);
		Button Gobuttom = new Button("Go!");
		searchinstrument.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent enterpress) {
				if (enterpress.getCode().equals(KeyCode.ENTER)) {
					searchInstrumnent();
				}
			}
		});
		Gobuttom.setOnAction(e -> searchInstrumnent());
		Gobuttom.setAlignment(Pos.TOP_RIGHT);
		hbox.setSpacing(5);
		hbox.setPadding(new Insets(10, 0, 5, 10));
		stage.setScene(scene);
		hbox.getChildren().addAll(searchinstrument, Gobuttom);
		return hbox;
	}

	public void searchInstrumnent() {
		for (index = 0; index < allInstruments.size(); index++) {
			type = allInstruments.get(index).getClass().getSimpleName();
			brand = allInstruments.get(index).getBrand();
			price2 = allInstruments.get(index).getPrice();
			String searchPrice = String.valueOf(price2);
			if (type.contains(searchinstrument.getText())) {
				getInstrumesnt(allInstruments);
				break;
			} else if (brand.contains(searchinstrument.getText())) {
				getInstrumesnt(allInstruments);
				break;
			} else if (searchPrice.contains(searchinstrument.getText())) {
				getInstrumesnt(allInstruments);
				break;

			}
		}

	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		Center_Top_Buttons.index = index;
	}

	public ArrayList<MusicalInstrument> getAllInstruments() {
		return allInstruments;
	}

	public void setAllInstruments(ArrayList<MusicalInstrument> allInstruments) {
		this.allInstruments = allInstruments;
	}
}

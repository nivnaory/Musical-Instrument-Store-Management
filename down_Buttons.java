package niv;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
//import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
//import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class down_Buttons {
	ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
	Center_Top_Buttons center = new Center_Top_Buttons(allInstruments);
	AfekaInventory afeka = new AfekaInventory();
	BorderPane borderpane = new BorderPane();
	VBox vbox = new VBox();
	HBox hbox = new HBox();
	GridPane grid = new GridPane();
	HBox layout = new HBox();
	Text slidetext = new Text();
	PathTransition transition = new PathTransition();
	Path path = new Path();
	Button add = new Button("Add");
	Button delete = new Button("Delete");
	Button clear = new Button("Clear");
	Label brandname = new Label("Brand:");
	Label price = new Label("Price: ");
	ComboBox<String> guitarcombobox = new ComboBox<String>();
	ComboBox<String> metcombobox = new ComboBox<String>();
	ComboBox<String> typeflutecombobox = new ComboBox<String>();
	ComboBox<String> combobox = new ComboBox<String>();
	CheckBox box1 = new CheckBox();
	TextField textfiled = new TextField();
	TextField textfiled1 = new TextField();
	TextField textfiled2 = new TextField();
	Stage stage = new Stage();
	Alert alert = new Alert(AlertType.ERROR);

	public down_Buttons(ArrayList<MusicalInstrument> allInstruments) {
		setAllInstruments(allInstruments);

	}

	public ArrayList<MusicalInstrument> getAllInstruments() {
		return allInstruments;
	}

	public void setAllInstruments(ArrayList<MusicalInstrument> allInstruments) {
		this.allInstruments = allInstruments;
	}

	public VBox getButtons(VBox vbox) {
		Date date = new Date();
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
			SimpleDateFormat ft = new SimpleDateFormat("yyy-MM-dd ");
			slidetext.setText(ft.format(date) + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
					+ " Afeka Instruments Music Store $$$ ON SALE!!!$$$ Guitars,Bass, flute,Saxophone and more!!");
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		slidetext.setOnMouseEntered(e -> transition.pause());
		slidetext.setOnMouseExited(e -> transition.play());
		Line line = new Line(0, 0, 500, 0);
		slidetext.setFill(Color.RED.brighter());
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.setSpacing(30);
		layout.setPadding(new Insets(10, 10, 10, 10));
		hbox.setPadding(new Insets(0, 0, 10, 0));
		delete.setOnAction(e -> deleteInstruments());
		clear.setOnAction(e -> clearInstruments());
		add.setOnAction(e -> addButtonChoose());
		transition.setPath(path);
		transition.setNode(slidetext);
		transition.setAutoReverse(true);
		transition.setCycleCount(Animation.INDEFINITE);
		transition.setDuration(Duration.seconds(10));
		transition.setPath(line);
		transition.play();
		hbox.getChildren().addAll(add, delete, clear);
		layout.getChildren().add(slidetext);
		vbox.setSpacing(5);
		vbox.getChildren().addAll(hbox, layout);
		return vbox;

	}

	public void addButtonChoose() {
		BorderPane borderpane = new BorderPane();
		grid.setAlignment(Pos.CENTER);
		Scene scene = new Scene(borderpane);
		borderpane.setPrefSize(300, 300);
		stage.setTitle("afeka instrumetn- add new instruments");
		combobox.setPromptText("Choose Instrument type here");
		combobox.getItems().addAll("Gutiar", "Bass", "flute", "Saxophone");
		combobox.setOnAction(e -> ChooseInstruments());
		grid.getChildren().add(combobox);
		borderpane.setCenter(grid);
		stage.setScene(scene);
		stage.show();

	}

	public void deleteInstruments() {
		try {
			afeka.removeInstruments(getAllInstruments(), getAllInstruments().get(center.getIndex()));
			center.setIndex(center.getIndex());
			center.getInstrumesnt(getAllInstruments());
		} catch (IndexOutOfBoundsException e) {
			alert.setTitle("Eror");
			alert.setHeaderText("Eror");
			alert.setContentText(" the array is empty no Instruments to delete!!! ");
			alert.showAndWait();
		}

	}

	public void clearInstruments() {
		afeka.removeAll(getAllInstruments());
		center.setAllInstruments(getAllInstruments());
		center.getInstrumesnt(getAllInstruments());
		center.setIndex(0);

	}

	public void ChooseInstruments() {
		if (combobox.getValue() == "Gutiar") {
			GutiarChoose();
		} else if (combobox.getValue() == "Bass") {
			BassChoose();

		} else if (combobox.getValue() == "flute") {
			fluteChoose();

		} else if (combobox.getValue() == "Saxophone") {
			saxophoneChooe();

		}

	}

	public void GutiarChoose() {
		Button add = new Button("Add");
		Label numOfStrig = new Label("Number Of String");
		Label guitartype = new Label("Gutiar Type");
		BorderPane borderPane = new BorderPane();
		HBox hbox = new HBox();
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(15);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		grid.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.TOP_CENTER);
		guitarcombobox.getItems().addAll("Classic", "Acoustic", "Electric");
		guitarcombobox.setValue("Type");
		Scene scene = new Scene(borderPane);
		add.setOnAction(e -> addGuitar());

		GridPane.setConstraints(brandname, 0, 0);
		GridPane.setConstraints(textfiled, 3, 0);
		GridPane.setConstraints(price, 0, 1);
		GridPane.setConstraints(textfiled1, 3, 1);
		GridPane.setConstraints(numOfStrig, 0, 2);
		GridPane.setConstraints(textfiled2, 3, 2);
		GridPane.setConstraints(guitartype, 0, 3);
		GridPane.setConstraints(guitarcombobox, 3, 3);
		GridPane.setConstraints(add, 3, 4);
		textfiled.setPromptText("EX: Yamaha");
		textfiled1.setPromptText("Ex: 3500");
		textfiled2.setPromptText("EX: 6");

		borderPane.setPrefSize(350, 300);
		hbox.getChildren().add(combobox);
		grid.getChildren().addAll(brandname, textfiled, price, textfiled1, numOfStrig, textfiled2, guitartype,
				guitarcombobox, add);
		borderPane.setTop(hbox);
		borderPane.setCenter(grid);

		stage.setScene(scene);
		stage.show();
	}

	public void fluteChoose() {
		Button add = new Button("Add");
		Label material = new Label("Mateiral");
		Label flutetype = new Label("Flute Type");
		BorderPane borderPane = new BorderPane();
		HBox hbox = new HBox();
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(15);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		grid.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.TOP_CENTER);
		metcombobox.getItems().addAll("Wood", "Metal", "Plastic");
		metcombobox.setValue("Material");
		typeflutecombobox.getItems().addAll("Flute", "Recorder", "Bass");
		typeflutecombobox.setValue("Type");
		Scene scene = new Scene(borderPane);
		add.setOnAction(e -> addFlute());

		GridPane.setConstraints(brandname, 0, 0);
		GridPane.setConstraints(textfiled, 3, 0);
		GridPane.setConstraints(price, 0, 1);
		GridPane.setConstraints(textfiled1, 3, 1);
		GridPane.setConstraints(material, 0, 2);
		GridPane.setConstraints(metcombobox, 3, 2);
		GridPane.setConstraints(flutetype, 0, 3);
		GridPane.setConstraints(typeflutecombobox, 3, 3);
		GridPane.setConstraints(add, 3, 4);
		textfiled.setPromptText("EX: Levit");
		textfiled1.setPromptText("Ex: 300");

		borderPane.setPrefSize(350, 300);
		hbox.getChildren().add(combobox);
		grid.getChildren().addAll(brandname, textfiled, price, textfiled1, material, flutetype, metcombobox,
				typeflutecombobox, add);
		borderPane.setTop(hbox);
		borderPane.setCenter(grid);
		stage.setScene(scene);
		stage.show();

	}

	public void saxophoneChooe() {
		Button add = new Button("Add");
		BorderPane borderPane = new BorderPane();
		HBox hbox = new HBox();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(15);
		grid.setVgap(15);
		borderPane.setPrefSize(350, 300);
		Scene scene = new Scene(borderPane);
		add.setOnAction(e -> addSaxophone());

		GridPane.setConstraints(brandname, 0, 0);
		GridPane.setConstraints(textfiled, 3, 0);
		GridPane.setConstraints(price, 0, 1);
		GridPane.setConstraints(textfiled1, 3, 1);
		GridPane.setConstraints(add, 3, 2);
		textfiled.setPromptText("EX: jupitar");
		textfiled1.setPromptText("Ex: 5490");

		borderPane.setPrefSize(350, 300);
		hbox.getChildren().add(combobox);
		grid.getChildren().addAll(brandname, textfiled, price, textfiled1, add);
		borderPane.setTop(hbox);
		borderPane.setCenter(grid);
		stage.setScene(scene);
		stage.show();

	}

	public void BassChoose() {

		Button add = new Button("Add");
		Label numOfStrig = new Label("Number Of String");
		Label fretless = new Label("Fretless");
		BorderPane borderpane = new BorderPane();
		HBox hbox = new HBox();
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(15);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		grid.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.TOP_CENTER);
		Scene scene = new Scene(borderpane);
		add.setOnAction(e -> addBass());

		GridPane.setConstraints(brandname, 0, 0);
		GridPane.setConstraints(textfiled, 3, 0);
		GridPane.setConstraints(price, 0, 1);
		GridPane.setConstraints(textfiled1, 3, 1);
		GridPane.setConstraints(numOfStrig, 0, 2);
		GridPane.setConstraints(textfiled2, 3, 2);
		GridPane.setConstraints(fretless, 0, 3);
		GridPane.setConstraints(box1, 3, 3);
		GridPane.setConstraints(add, 3, 4);

		textfiled.setPromptText("EX: Fender");
		textfiled1.setPromptText("Ex: 3500");
		textfiled2.setPromptText("EX: 5");

		borderpane.setPrefSize(350, 300);
		hbox.getChildren().add(combobox);
		grid.getChildren().addAll(brandname, textfiled, price, textfiled1, numOfStrig, textfiled2, fretless, box1, add);
		borderpane.setTop(hbox);
		borderpane.setCenter(grid);
		stage.setScene(scene);
		stage.show();

	}

	public void addGuitar() {
		String type = guitarcombobox.getValue();
		String brand = textfiled.getText();
		double price = Double.valueOf(textfiled1.getText());
		int numOfString = Integer.valueOf(textfiled2.getText());
		Guitar newGutiar = new Guitar(brand, price, numOfString, type);
		afeka.addInstruments(getAllInstruments(), newGutiar);
		center.getInstrumesnt(getAllInstruments());
		reset();
		stage.close();

	}

	public void addFlute() {
		String brand = textfiled.getText();
		double price = Double.valueOf(textfiled1.getText());
		String material = metcombobox.getValue();
		String fluteType = typeflutecombobox.getValue();
		flute newflute = new flute(brand, price, material, fluteType);
		afeka.addInstruments(getAllInstruments(), newflute);
		center.getInstrumesnt(getAllInstruments());
		reset();
		stage.close();

	}

	public void addSaxophone() {
		String brand = textfiled.getText();
		double price = Double.valueOf(textfiled1.getText());
		Saxophone newsaxophone = new Saxophone(brand, price);
		afeka.addInstruments(getAllInstruments(), newsaxophone);
		center.getInstrumesnt(getAllInstruments());
		reset();
		stage.close();
	}

	public void addBass() {
		String brand = textfiled.getText();
		double price = Double.valueOf(textfiled1.getText());
		int numberofstring = Integer.valueOf(textfiled2.getText());
		boolean isFretless = false;
		if (box1.isSelected() == true) {
			isFretless = true;
		}
		Bass newbass = new Bass(brand, price, numberofstring, isFretless);
		afeka.addInstruments(getAllInstruments(), newbass);
		center.getInstrumesnt(getAllInstruments());
		reset();
		stage.close();

	}

	public void reset() {
		textfiled.clear();
		textfiled1.clear();
		textfiled2.clear();
		combobox.getSelectionModel().clearSelection();
		combobox.getItems().clear();
		typeflutecombobox.getItems().clear();
		guitarcombobox.getItems().clear();
		metcombobox.getItems().clear();

	}
}

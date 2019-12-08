package niv;

import java.io.File;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import javafx.animation.PathTransition;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Button.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPane.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.util.Duration;

public class javafx extends Application {
	BorderPane borderPane = new BorderPane();
	AfekaInstruments afeka = new AfekaInstruments();
	GridPane gridpane = new GridPane();
	HBox hbox = new HBox();
	VBox vbox = new VBox();
	VBox vbox1 = new VBox();
	static AfekaInventory newAfeka = new AfekaInventory();
	static ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
	File file;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		file = getInstrumentsFileFromUser();
		AfekaInstruments.loadInstrumentsFromFile(file, allInstruments);
		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Afeka Instruments Music Store");
		setCenter();
		setTop();
		setBottum();
		borderPane.setPrefSize(700, 300);
		primaryStage.show();

	}

	public static File getInstrumentsFileFromUser() {
		boolean stopLoop = true;
		File file;

		do {

			TextInputDialog dialog = new TextInputDialog("filename");
			dialog.setTitle("Confirmation");
			dialog.setHeaderText("Loud Instrument From file");
			dialog.setContentText("Please enter file name:");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent() == false) {
				System.exit(2);
			}
			file = new File(result.get());
			if (!file.exists() && file.canRead() == false) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Eror!");
				alert.setHeaderText("File Eror!");
				alert.setContentText("Cannot read from the file,please try again ");
				alert.showAndWait();
				stopLoop = false;

			} else {
				stopLoop = true;
			}

		} while (!stopLoop);
		return file;
	}

	private void setTop() {
		Center_Top_Buttons center = new Center_Top_Buttons(allInstruments);
		borderPane.setTop(center.getTopwindow(hbox));
	}

	private void setCenter() {
		Center_Top_Buttons center = new Center_Top_Buttons(allInstruments);
		borderPane.setCenter(center.setGridPane(gridpane));
		borderPane.setRight(center.setOnRight(vbox));
		borderPane.setLeft(center.setOnLeft(vbox1));
	}

	private void setBottum() {
		vbox.setPadding(new Insets(10, 10, 10, 10));
		down_Buttons downbuttons = new down_Buttons(allInstruments);
		borderPane.setBottom(downbuttons.getButtons(vbox));
	}
}

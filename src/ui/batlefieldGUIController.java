package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import model.Battlefield;

public class BatlefieldGUIController {

	private Battlefield battlefield;
	private boolean theLastBattleMatrixHasBeenCreated = false;
	private boolean theCoefficientMatrixHasBeenCreated = false;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField numberOfRowsInTheLastBattleMatrix;

	@FXML
	private TextField numberOfColumnsInTheLastBattleMatrix;

	@FXML
	private CheckBox repeatNumbersInTheLastBattleMatrix;

	@FXML
	private CheckBox repeatNumbersInTheCoefficientMatrix;

	@FXML
	private TextField numberOfRowsInTheCoefficientMatrix;

	@FXML
	private TextField numberOfColumnsInTheCoefficientMatrix;

	@FXML
	private GridPane currentBattleMatrix;

	@FXML
	private ColumnConstraints CurrentBattleMatrix;

	@FXML
	private void generateCurrentBattleMatrix(ActionEvent event) {
		if (theLastBattleMatrixHasBeenCreated && theCoefficientMatrixHasBeenCreated) {
			try {
				battlefield.multiplyMatrices();
				numberOfRowsInTheLastBattleMatrix.setText("");
				numberOfColumnsInTheLastBattleMatrix.setText("");
				numberOfRowsInTheCoefficientMatrix.setText("");
				numberOfColumnsInTheCoefficientMatrix.setText("");
				printCurrentMatrix();
			} catch (Exception e) {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("ERROR");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText(
						"It is impossible to multiply the matrices created, since the number of rows in the past battle matrix is different from the number of columns in the coefficient matrix");
				info.show();
			}
		} else {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText(
					"In order to make the product of the matrices, both have to be created, and the number of rows of the last matrix must be equal to the number of columns of the coefficient matrix");
			info.show();
		}

	}

	@FXML
	private void generateLastBattleMatrix(ActionEvent event) {
		try {
			int rows = Integer.parseInt(numberOfRowsInTheLastBattleMatrix.getText());
			int columns = Integer.parseInt(numberOfColumnsInTheLastBattleMatrix.getText());
			boolean repeatNumbers = repeatNumbersInTheLastBattleMatrix.isSelected();
			battlefield.generateTheLastBattleMatrix(rows, columns, repeatNumbers);
			theLastBattleMatrixHasBeenCreated = true;
		} catch (NumberFormatException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please enter a couple of integers greater than zero (One number for each box)");
			info.show();
		}
	}

	@FXML
	private void generateMatrixOfCoefficients(ActionEvent event) {
		try {
			int rows = Integer.parseInt(numberOfRowsInTheCoefficientMatrix.getText());
			int columns = Integer.parseInt(numberOfColumnsInTheCoefficientMatrix.getText());
			boolean repeatNumbers = repeatNumbersInTheLastBattleMatrix.isSelected();
			battlefield.generateTheCoefficientMatrix(rows, columns, repeatNumbers);
			theCoefficientMatrixHasBeenCreated = true;
		} catch (NumberFormatException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please enter a couple of integers greater than zero (One number for each box)");
			info.show();
		}
	}

	@FXML
	private void initialize() {
		battlefield = new Battlefield();
	}

	protected void printCurrentMatrix() {
		currentBattleMatrix.getChildren().clear();

		for (int I = 0; I < battlefield.getPositionOfTheEnemyShips().size(); I++) {
			System.out.println("si cumple la condicion del for");
			String[] temp = battlefield.getPositionOfTheEnemyShips().get(I).split(" ");
			System.out.println("si hace el split 1");
			int positionShipRow = Integer.parseInt(temp[0]);
			int positionShipColumn = Integer.parseInt(temp[1]);
			System.out.println("si hace el split");
			Image img = new Image("images/ship.png");
			ImageView imageView = new ImageView();
			imageView.setImage(img);
			imageView.setFitHeight(20);
			imageView.setFitWidth(20);
			System.out.println("si carga imagen");
			Button button = new Button("");
			button.setGraphic(imageView);
			System.out.println("si se coloca la imagen bien");
			GridPane.setConstraints(button, positionShipRow, positionShipColumn, 1, 1);
			System.out.println("si se crea el grid pane");
			currentBattleMatrix.getChildren().addAll(button);
			System.out.println("si se agregan botones");
		}
	}
}
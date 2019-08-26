package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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
	void generateCurrentBattleMatrix(ActionEvent event) {
		if (theLastBattleMatrixHasBeenCreated && theCoefficientMatrixHasBeenCreated) {
			try {
				battlefield.multiplyMatrices();
				numberOfRowsInTheLastBattleMatrix.setText("");
				numberOfColumnsInTheLastBattleMatrix.setText("");
				numberOfRowsInTheCoefficientMatrix.setText("");
				numberOfColumnsInTheCoefficientMatrix.setText("");
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
	void generateLastBattleMatrix(ActionEvent event) {
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
	void generateMatrixOfCoefficients(ActionEvent event) {
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
	void initialize() {
		battlefield = new Battlefield();
	}
}
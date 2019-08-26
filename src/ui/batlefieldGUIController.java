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

public class batlefieldGUIController {
	
	private Battlefield battlefield;
	
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
    	
    }

    @FXML
    void generateLastBattleMatrix(ActionEvent event) {
    	int value=0;
		try {
			value = Integer.parseInt(numberOfRowsInTheLastBattleMatrix.getText());
			
		} catch (NumberFormatException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please enter an integer greater than zero");
			info.show();
		}
    }

    @FXML
    void generateMatrixOfCoefficients(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
    	
    }
}
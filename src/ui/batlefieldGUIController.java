package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Battlefield;

public class batlefieldGUIController implements Initializable {
	
	Battlefield battleField;
	

    @FXML
    private Button producButon;

    @FXML
    private GridPane actualMatriz;

    @FXML
    private GridPane producMatrix;

    @FXML
    private GridPane resultMatrix;

	
	
	public void fillMatrix(int[][]A,GridPane r) {
		for (int i = 0; i < A.length-1; i++) {
			for (int j = 0; j < A.length-1; j++) {
				TextField m = new TextField();
				m.setText(""+A[i][j]);
				r.add(m,j,i);
			}
		}
	}
	
	public void fillAcutalPotitionsMatrix(int[][]A,GridPane r) {
		for (int i = 0; i < A.length-1; i++) {
			for (int j = 0; j < A.length-1; j++) {
				if(battleField.isPrime(A[i][j])) {
				TextField m = new TextField();
				m.setText(""+A[i][j]);
				r.add(m,j,i);
				}
				else {
				TextField m = new TextField();
				r.add(m,j,i);
				}
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		battleField = new Battlefield();
	}

}

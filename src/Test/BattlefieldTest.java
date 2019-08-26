package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Battlefield;

class BattlefieldTest {
	
	
	Battlefield battlefield;
	
	@BeforeEach
	void setUp() {
		battlefield = new Battlefield();
	}
	
	
	@Test
	 void generateTheLastBattleMatrixTest() {
		setUp();
		int [][] A = battlefield.generateTheCoefficientMatrix(10,10,true);
		int [][] B = battlefield.generateTheCoefficientMatrix(10,10,true);
		assertFalse(Arrays.deepEquals(A, B));
	}
	
	@Test
	void generateTheCoefficientMatrixTest() {
		setUp();
		int [][] A = battlefield.getCoefficientMatrix();
		assertTrue(A!=battlefield.generateTheCoefficientMatrix(10,10,true));
	}
	
	@Test
	void multiplyMatricesTest() {
		setUp();
		int[][] matriz1 = { { 1, 1, 1 }, { 1, 2, 2}, { 1, 2, 3 } };
		int[][] matriz2 = { { 2, 3, 1 }, { 3, 2, 1}, { 4, 5, -3 } };
		
		int[][] matriz1xmatriz2 = { { 9, 10, -1 }, { 16, 17,-3}, { 20, 22, -6 } };
		
		assertTrue(Arrays.deepEquals((battlefield.multiplyMatrices(matriz1, matriz2)),matriz1xmatriz2));
		
		
	}
}

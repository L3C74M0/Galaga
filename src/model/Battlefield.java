package model;

import java.util.ArrayList;
import java.util.Random;

public class Battlefield {

	private ArrayList<int[][]> arrayArrangement;

	private int[][] coefficientMatrix;
	private int[][] lastBattleMatrix;
	private int[][] currentBattleMatrix;

	
	/*
	 * 
	 * The constructor method
	 * 
	 */
	public Battlefield() {

	}
	
	
	
	/*
	 * 
	 * The method serves to instantiate a past battle matrix and fill it with random values
	 * @param Int number of rows, number of columns . This to know what size to generate the last battle matrix
	 * @return The last battle matrix, filled with random integers between 1 and 51
	 * Pre: Have created an object type BattleField
	 * 
	 */
	public int[][] generateTheLastBattleMatrix(int numberOfRows, int numberOfColumns) {
		Random r = new Random();
		lastBattleMatrix = new int[numberOfRows][numberOfColumns];

		for (int I = 0; I < lastBattleMatrix.length -1; I++) {
			for (int J = 0; J < lastBattleMatrix[I].length -1; J++) {
				lastBattleMatrix[I][J] = r.nextInt(100) + 1;
			}
		}
		return lastBattleMatrix;
	}
	
	
	/*
	 * 
	 * The method serves to instantiate a coefficient battle matrix and fill it with random values
	 * @param Int number of rows, number of columns . This to know what size to generate the last battle matrix
	 * @return The last battle matrix, filled with random integers between 1 and 51
	 * Pre: Have created an object type BattleField
	 * 
	 */
	public int[][] generateTheCoefficientMatrix(int numberOfRows, int numberOfColumns) {
		Random r = new Random();
		coefficientMatrix = new int[numberOfRows][numberOfColumns];

		for (int I = 0; I < coefficientMatrix.length -1; I++) {
			for (int J = 0; J < coefficientMatrix[I].length -1; J++) {
				coefficientMatrix[I][J] = r.nextInt(100) + 1;
			}
		}
		return coefficientMatrix;
	}
	
	
	
	
	
	
	
	
	

	// Getters and Setters

	public int[][] getCoefficientMatrix() {
		return coefficientMatrix;
	}

	public void setCoefficientMatrix(int[][] coefficientMatrix) {
		this.coefficientMatrix = coefficientMatrix;
	}

	public int[][] getLastBattleMatrix() {
		return lastBattleMatrix;
	}

	public void setLastBattleMatrix(int[][] lastBattleMatrix) {
		this.lastBattleMatrix = lastBattleMatrix;
	}

	public int[][] getCurrentBattleMatrix() {
		return currentBattleMatrix;
	}

	public void setCurrentBattleMatrix(int[][] currentBattleMatrix) {
		this.currentBattleMatrix = currentBattleMatrix;
	}

	public ArrayList<int[][]> getArrayArrangement() {
		return arrayArrangement;
	}

	public void setArrayArrangement(ArrayList<int[][]> arrayArrangement) {
		this.arrayArrangement = arrayArrangement;
	}
}

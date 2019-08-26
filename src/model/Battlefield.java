package model;

import java.util.ArrayList;
import java.util.Random;

public class Battlefield {

	private int[][] coefficientMatrix;
	private int[][] lastBattleMatrix;
	private int[][] currentBattleMatrix;
	private ArrayList<String> positionOfTheEnemyShips;

	/*
	 * 
	 * The constructor method The largest possible product can be 51x51 = 2601, we
	 * look for a list of the lesser cousins to that number, and add them to a
	 * primeNumbers array
	 * 
	 */
	public Battlefield() {

	}

	/*
	 * 
	 * The method serves to instantiate a past battle matrix and fill it with random
	 * values
	 * 
	 * @param Int number of rows , which indicates the number of rows in the array
	 * to create
	 * 
	 * @param int number of columns , which indicates the number of columns in the
	 * array to create
	 * 
	 * @param boolean which indicates if the matrix values can be repeated
	 * 
	 * @return The last battle matrix, filled with random integers between 1 and 51
	 * 
	 */
	public int[][] generateTheLastBattleMatrix(int numberOfRows, int numberOfColumns, boolean repeatedValues) {
		Random random = new Random();
		lastBattleMatrix = new int[numberOfRows][numberOfColumns];

		if (repeatedValues) {
			for (int I = 0; I < lastBattleMatrix.length - 1; I++) {
				for (int J = 0; J < lastBattleMatrix[I].length - 1; J++) {
					lastBattleMatrix[I][J] = random.nextInt(100) + 1;
				}
			}
		} else {
			int[] numbers = new int[numberOfRows*numberOfColumns];
			for (int I = 1; I < numberOfRows*numberOfColumns; I++) {
				numbers[I] = I;
			}
			
			//Mess up the numbers
			for (int I = numbers.length; I > 0; I--) {
			    int posicion = random.nextInt(I);
			    int tmp = numbers[I-1];
			    numbers[I - 1] = numbers[posicion];
			    numbers[posicion] = tmp;
			}
			
			//Add the numbers to the matrix
			int numberTemp = 0;
			for (int I = 0; I < lastBattleMatrix.length; I++) {
				for (int J = 0; J < lastBattleMatrix.length; J++) {
					lastBattleMatrix[I][J] = numbers[numberTemp];
					numberTemp++;
				}
			}
		}

		return lastBattleMatrix;
	}

	/*
	 * 
	 * The method serves to instantiate a coefficient battle matrix and fill it with
	 * random values
	 * 
	 * @param Int number of rows , which indicates the number of rows in the array
	 * to create
	 * 
	 * @param int number of columns , which indicates the number of columns in the
	 * array to create
	 * 
	 * @param boolean which indicates if the matrix values can be repeated
	 * 
	 * @return The last battle matrix, filled with random integers between 1 and 51
	 * 
	 */
	public int[][] generateTheCoefficientMatrix(int numberOfRows, int numberOfColumns,  boolean repeatedValues) {
		Random random = new Random();
		coefficientMatrix = new int[numberOfRows][numberOfColumns];

		if (repeatedValues) {
			for (int I = 0; I < coefficientMatrix.length - 1; I++) {
				for (int J = 0; J < coefficientMatrix[I].length - 1; J++) {
					coefficientMatrix[I][J] = random.nextInt(100) + 1;
				}
			}
		} else {
			int[] numbers = new int[numberOfRows*numberOfColumns];
			for (int I = 1; I < numberOfRows*numberOfColumns; I++) {
				numbers[I] = I;
			}
			
			//Mess up the numbers
			for (int I = numbers.length; I > 0; I--) {
			    int posicion = random.nextInt(I);
			    int tmp = numbers[I-1];
			    numbers[I - 1] = numbers[posicion];
			    numbers[posicion] = tmp;
			}	
			
			//Add the numbers to the matrix
			int numberTemp = 0;
			for (int I = 0; I < coefficientMatrix.length; I++) {
				for (int J = 0; J < coefficientMatrix.length; J++) {
					coefficientMatrix[I][J] = numbers[numberTemp];
					numberTemp++;
				}
			}
		}
		return coefficientMatrix;
	}

	/*
	 * The function of this method is: multiply two matrices if possible, otherwise,
	 * this will throw a custom exception indicating that the product operation
	 * cannot be carried out.
	 * 
	 * @param last battle matrix
	 * 
	 * @param coefficient matrix
	 * 
	 * pre: Matrices to multiply cannot be null or empty (unfilled)
	 * 
	 * @throws Exception if it is impossible to multiply the matrices
	 * 
	 * @return The product of the matrices that arrived by parameter
	 * 
	 */
	public int[][] multiplyMatrices() throws Exception {
		if(lastBattleMatrix!=null || coefficientMatrix!=null) {
			int[][] currentBattleMatrix = new int[lastBattleMatrix.length][coefficientMatrix[0].length];

			if (lastBattleMatrix[0].length == coefficientMatrix.length) {
				for (int I = 0; I < lastBattleMatrix.length; I++) {
					for (int J = 0; J < coefficientMatrix[0].length; J++) {
						for (int K = 0; K < lastBattleMatrix[0].length; K++) {
							currentBattleMatrix[I][J] += lastBattleMatrix[I][K] * coefficientMatrix[K][J];
						}
					}
				}
			} else {
				throw new Exception("It is impossible to multiply the Matrices");
			}
		}else {
			
		}
		
		return currentBattleMatrix;
	}

	/*
	 * The method serves to verify if a number is prime
	 * 
	 * @param int number which is what we are going to test if it is cousin or not
	 * 
	 * pre: The number received by parameter cannot be negative
	 * 
	 * @throws Exception if a negative number is received
	 * 
	 * @return boolean that indicates whether the number received by parameter is a
	 * prime number or not
	 * 
	 */
	public boolean isPrime(int number) throws Exception {
		boolean isPrime = true;

		if (number >= 0) {
			if (number % 2 == 0) {
				isPrime = false;
			}else {
				for (int I = 3; I * I <= number; I += 2) {
					if (number % I == 0) {
						isPrime = false;
					}
				}
			}
		} else {
			throw new Exception("You cannot work with negative numbers");
		}

		return isPrime;
	}

	/*
	 * The function of the method is to find the prime numbers (enemy ships) in the
	 * current battle matrix
	 * 
	 * @param int[][] current battle matrix
	 * 
	 * pre: The current battle matrix must be different from null
	 * 
	 * @throws Eception if the method isPrime fail
	 * 
	 * post: The positions of the prime numbers (enemy ships) found were saved in
	 * the ArrayList positionOfTheEnemyShips
	 * 
	 */
	public void identifyEnemyShips(int[][] currentBattleMatrix) throws Exception {

		for (int I = 0; I < currentBattleMatrix.length; I++) {
			for (int J = 0; J < currentBattleMatrix[I].length; J++) {
				if (isPrime(currentBattleMatrix[I][J])) {
					positionOfTheEnemyShips.add(I + " " + J);
				}
			}
		}
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
}

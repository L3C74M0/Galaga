package model;

import java.util.ArrayList;
import java.util.Random;

public class Battlefield {

	private int[][] coefficientMatrix;
	private int[][] lastBattleMatrix;
	private int[][] currentBattleMatrix;
	private ArrayList<String> enemyShips;
	
	
	protected int[] primeNumbers;

	/*
	 * 
	 * The constructor method The largest possible product can be 51x51 = 2601, we
	 * look for a list of the lesser cousins to that number, and add them to a
	 * primeNumbers array
	 * 
	 */
	public Battlefield() {
		primeNumbers = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
				83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
				193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311,
				313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439,
				443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577,
				587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709,
				719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857,
				859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997,
				1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103,
				1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231,
				1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367,
				1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487,
				1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601, 1607,
				1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733,
				1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873,
				1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, 2003,
				2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131,
				2137, 2141, 2143, 2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239, 2243, 2251, 2267, 2269, 2273,
				2281, 2287, 2293, 2297, 2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357, 2371, 2377, 2381, 2383, 2389,
				2393, 2399, 2411, 2417, 2423, 2437, 2441, 2447, 2459, 2467, 2473, 2477, 2503, 2521, 2531, 2539, 2543,
				2549, 2551, 2557, 2579, 2591, 2593, 2609 };
	}

	/*
	 * 
	 * The method serves to instantiate a past battle matrix and fill it with random
	 * values
	 * 
	 * @param Int number of rows, number of columns . This to know what size to
	 * generate the last battle matrix
	 * 
	 * @return The last battle matrix, filled with random integers between 1 and 51
	 * 
	 */
	public int[][] generateTheLastBattleMatrix(int numberOfRows, int numberOfColumns) {
		Random r = new Random();
		lastBattleMatrix = new int[numberOfRows][numberOfColumns];

		for (int I = 0; I < lastBattleMatrix.length - 1; I++) {
			for (int J = 0; J < lastBattleMatrix[I].length - 1; J++) {
				lastBattleMatrix[I][J] = r.nextInt(100) + 1;
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
	 * @return The last battle matrix, filled with random integers between 1 and 51
	 * 
	 */
	public int[][] generateTheCoefficientMatrix(int numberOfRows, int numberOfColumns) {
		Random r = new Random();
		coefficientMatrix = new int[numberOfRows][numberOfColumns];

		for (int I = 0; I < coefficientMatrix.length - 1; I++) {
			for (int J = 0; J < coefficientMatrix[I].length - 1; J++) {
				coefficientMatrix[I][J] = r.nextInt(100) + 1;
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
	 * @return The product of the matrices that arrived by parameter
	 * 
	 */
	public int[][] multiplyMatrices(int[][] lastBattleMatrix, int[][] coefficientMatrix) {

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
			// lanzar excepcion personalizada: >>>>>>>
			// ItIsImpossibleToMultiplyTheMatricesPAPUException
		}

		return currentBattleMatrix;
	}
	
	/*
	 * The method serves to verify if a number less than 2601 (because it is the
	 * highest value with which we are going to work this project) is prime
	 * 
	 * @param int number which is what we are going to test if it is cousin or not
	 * pre: The matrix of prime numbers, has to have all the prime numbers less than
	 * 2601 pre: The number received by parameter cannot be negative
	 * 
	 * @return boolean that indicates whether the number received by parameter is a
	 * prime number or not
	 * 
	 */
	public boolean isPrime(int number) {
		boolean isPrime = false;

		if (number >= 0) {

			int low = 0;
			int high = primeNumbers.length - 1;
			int middle;
			int position;

			for (int I = 0; I < primeNumbers.length && isPrime == false; I++) {
				middle = (high + low) / 2;
				if (primeNumbers[middle] == number) {
					isPrime = true;
				} else if (primeNumbers[middle] < number) {
					low = middle + 1;
				} else if (primeNumbers[middle] > number) {
					high = middle - 1;
				} else {
					if (middle == high || middle == low) {
						isPrime = true;
					}
				}
			}
		} else {
			// excepcion personalizada >>> YouCannotWorkWithNegativeNumbersException
		}
		
		return isPrime;
	}
	
	
	public void identifyEnemyShips() {
		
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

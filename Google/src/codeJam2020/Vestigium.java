package codeJam2020;

import java.util.Arrays;
import java.util.HashSet;

/*
 * Vestigium means "trace" in Latin. In this problem we work with Latin squares and matrix traces.

The trace of a square matrix is the sum of the values on the main diagonal (which runs from the upper left to the lower right).

An N-by-N square matrix is a Latin square if each cell contains one of N different values, and no value is repeated within a row or a column. In this problem, we will deal only with "natural Latin squares" in which the N values are the integers between 1 and N.

Given a matrix that contains only integers between 1 and N, we want to compute its trace and check whether it is a natural Latin square. To give some additional information, instead of simply telling us whether the matrix is a natural Latin square or not, please compute the number of rows and the number of columns that contain repeated values.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each starts with a line containing a single integer N: the size of the matrix to explore. Then, N lines follow. The i-th of these lines contains N integers Mi,1, Mi,2 ..., Mi,N. Mi,j is the integer in the i-th row and j-th column of the matrix.

Output
For each test case, output one line containing Case #x: k r c, 
where x is the test case number (starting from 1), k is the trace of the matrix, 
r is the number of rows of the matrix that contain repeated elements, and c is the number of columns of the matrix that contain repeated elements.
 * */
public class Vestigium {

	public static int[] calculateTrace(int[][] latinArray) {
		int[] result = new int[3];

		// calculating trace
		for (int x = 0; x < latinArray.length; x++) {
			result[0] += latinArray[x][x];
		}

		// row wise check
		for (int row = 0; row < latinArray.length; row++) {
			HashSet<Integer> set = new HashSet<>();
			for (int column = 0; column < latinArray[row].length; column++) {
				set.add(latinArray[row][column]);
			}
			if (set.size() != latinArray.length)
				result[1]++;
		}

		// columns wise check
		for (int column = 0; column < latinArray.length; column++) {
			HashSet<Integer> set = new HashSet<>();
			for (int row = 0; row < latinArray.length; row++) {
				set.add(latinArray[row][column]);
			}
			if (set.size() != latinArray.length)
				result[2]++;
		}

		return result;
	}

	public static void main(String[] args) {

		System.out.println(Arrays.toString(calculateTrace(new int[][] { //
				{ 2, 2, 2, 2 }, //
				{ 2, 3, 2, 3 }, //
				{ 2, 2, 2, 3 }, //
				{ 2, 2, 2, 2 } //
		})));
	}
}

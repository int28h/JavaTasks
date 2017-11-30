/**
 * Given a 6*6 2D Array, A. 
 * Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.
 * 
 * Sample Input
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 *
 * Sample Output
 * 19
 *
 * Explanation
 * A contains the following hourglasses:
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *   1       0       0       0
 * 1 1 1   1 1 0   1 0 0   0 0 0
 * 
 * 0 1 0   1 0 0   0 0 0   0 0 0
 *   1       1       0       0
 * 0 0 2   0 2 4   2 4 4   4 4 0
 * 
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *   0       2       4       4
 * 0 0 0   0 0 2   0 2 0   2 0 0
 * 
 * 0 0 2   0 2 4   2 4 4   4 4 0
 *   0       0       2       0
 * 0 0 1   0 1 2   1 2 4   2 4 0
 * The hourglass with the maximum sum () is:
 * 2 4 4
 *   2
 * 1 2 4
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i = 0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        int max = Integer.MIN_VALUE, temp = 0;
        for(int i = 0; i < 4; i++) {
        	for(int j = 1; j < 5; j++) {
        		temp = arr[i][j - 1] + arr[i][j] + arr[i][j + 1] +
        				arr[i + 1][j] + 
        				arr[i + 2][j - 1] + arr[i + 2][j] + arr[i + 2][j + 1];
        		if(temp > max) max = temp;
        	}
        }
        System.out.println(max);
    }
}

/**
 * Given an array, a, of size distinct elements, sort the array in ascending order using the Bubble Sort algorithm above. 
 * Once sorted, print the following 3 lines:
 * 1. Array is sorted in numSwaps swaps where numSwaps is the number of swaps that took place.
 * 2. First Element: firstElement where firstElement is the first element in the sorted array.
 * 3. Last Element: lastElement where lastElement is the last element in the sorted array.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i < n; i++){
            a[i] = in.nextInt();
        }
        
        int swaps = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                if(a[j] > a[j + 1]){
                    int t = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = t;
                    swaps++;
                }
            }
        }
        
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);
    }
}
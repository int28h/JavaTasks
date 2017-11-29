/**
 * Given a base-10 integer, n, convert it to binary (base-2). Then find and print the base-10 integer 
 * denoting the maximum number of consecutive 1's in n's binary representation.
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
        String binaryNumber = Integer.toBinaryString(n);
        char [] data = binaryNumber.toCharArray();
        
        int result = 0, temp = 0;
        for(char ch : data) {
        	if (ch == '1') {
        		temp++;
        	} else {
        		temp = 0;
        	}
        	
        	if (temp > result) {
        		result = temp;
        	}
        }
        System.out.println(result);
        in.close();
    }
}
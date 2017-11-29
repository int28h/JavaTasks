/**
 * Write a factorial function that takes a positive integer, N as a parameter and prints the result of N!(N factorial).
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int factorial(int n) {
        int result = 1;
        for(int i = 1; i <= n; i++)
        {
            result *= i;
        }
        return result; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = factorial(n);
        System.out.println(result);
    }
}
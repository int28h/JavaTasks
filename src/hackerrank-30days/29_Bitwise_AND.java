/**
 * Given set S = {1, 2, 3, ..., N}. Find two integers, A and B (where A<B), from set S such that the value of A&B
 * is the maximum possible and also less than a given integer, K. In this case, & represents the bitwise AND operator.
 */
import java.io.*;
import java.util.*;

public class Solution {
    public static int findMaximum(int n, int k){
        int max = 0;
        int a = n - 1;
        while(a-- > 0) {
            for(int b = a + 1; b <= n; b++){
                int test = a & b;
                if(test < k && 	test > max){
                    max = test;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println( findMaximum(n, k) );
        }
        in.close();
    }
}
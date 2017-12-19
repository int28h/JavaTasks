/**
 * Your local library needs your help! Given the expected and actual return dates for a library book, 
 * create a program that calculates the fine (if any). The fee structure is as follows:
 * 
 * If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine = 0).
 *
 * If the book is returned after the expected return day but still within the same calendar month and year 
 * as the expected return date, fine = 15 Hackos * (the number of days late).
 * 
 * If the book is returned after the expected return month but still within the same calendar year 
 * as the expected return date, the fine = 500 Hackos * (the number of months late).
 *
 * If the book is returned after the calendar year in which it was expected, there is a fixed fine of 10000 Hackos.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int[] actual = new int[3];
        for(int i = 0; i < 3; i++){
            actual[i] = in.nextInt();
        }
		
        int[] expected = new int[3];
        for(int i = 0; i < 3; i++){
            expected[i] = in.nextInt();
        }
        in.close();
        
        int fine = 0;
        
        if(expected[2] == actual[2]){
            if(expected[1] < actual[1]){
                fine = (actual[1] - expected[1]) * 500;
            }
            else if((expected[1] == actual[1]) && (expected[0] < actual[0])){
                fine = (actual[0] - expected[0]) * 15;
            }
        } else if(expected[2] < actual[2]){
            fine = 10000;
        }
        System.out.println(fine);
    }
}

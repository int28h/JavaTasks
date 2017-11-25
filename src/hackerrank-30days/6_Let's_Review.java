/**
 * Given a string, S, of length N that is indexed from 0 to N-1, print its even-indexed and odd-indexed characters 
 * as 2 space-separated strings on a single line (see the Sample below for more detail).
 *
 * Note: 0 is considered to be an even index. 
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stringsCount = sc.nextInt();
        String[] data = new String[stringsCount];
        
        for(int i = 0; i < stringsCount; i++){
            data[i] = sc.next();
            char[] symbols = data[i].toCharArray();
            String even = "";
            String odd = "";
            
            for(int j = 0; j < symbols.length; j++) {
                if(j % 2 == 0) {
                even += symbols[j];
                } else {
                odd += symbols[j];
                }
            } 
            System.out.println(even + " " + odd);
        }
    }
}
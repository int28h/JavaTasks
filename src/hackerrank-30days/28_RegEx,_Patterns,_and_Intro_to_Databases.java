/**
 * Consider a database table, Emails, which has the attributes First Name and Email ID. 
 * Given N rows of data simulating the Emails table, print an alphabetically-ordered list of people whose 
 * email address ends in @gmail.com.
 *
 * Print an alphabetically-ordered list of first names for every user with a gmail account. 
 * Each name must be printed on a new line.
 */
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String pattern = "@gmail.com";
        
        List<String> data = new LinkedList<>();
        while(in.hasNextLine()) {
            String name = in.next();
            String email = in.next();
            if(email.contains(pattern)){
                data.add(name);
            }
        }
        in.close();
        
        Collections.sort(data);
        for (String name : data) {
			System.out.println(name);
        }
    }
}
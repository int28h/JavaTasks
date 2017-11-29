/**
 * Given n names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers. 
 * You will then be given an unknown number of names to query your phone book for. 
 * For each name queried, print the associated entry from your phone book on a new line in the form 
 * "name=phoneNumber"; if an entry for is not found, print "Not found" instead. 
 */
import java.util.*;
import java.io.*;

class Main{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        Map<String, Integer> data = new HashMap<>();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            data.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            Integer a = data.get(s);
            if(a == null) {
            	System.out.println("Not found");
            } else {
            	System.out.println(s + "=" + data.get(s));
            }
        }
        in.close();
    }
}
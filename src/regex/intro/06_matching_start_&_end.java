/*
The ^ symbol matches the position at the start of a string.

The $ symbol matches the position at the end of a string.

Task

You have a test string S. Your task is to match the pattern Xxxxx

Here, x denotes a word character, and X denotes a digit.
S must start with a digit X and end with . symbol.
S should be 6 characters long only.

Note

This is a regex only challenge. You are not required to write code.
You have to fill the regex pattern in the blank (_________).
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {    

    public static void main(String[] args) {
        
        Regex_Test tester = new Regex_Test();
        tester.checker("^\\d....\\.$"); 
    
    }
}

class Regex_Test {

    public void checker(String Regex_Pattern){
    
        Scanner Input = new Scanner(System.in);
        String Test_String = Input.nextLine();
        Pattern p = Pattern.compile(Regex_Pattern);
        Matcher m = p.matcher(Test_String);
        System.out.println(m.find());
    }   
    
}

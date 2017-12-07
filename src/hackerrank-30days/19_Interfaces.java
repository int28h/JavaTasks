/**
 * The AdvancedArithmetic interface and the method declaration for the abstract int divisorSum(int n) method 
 * are provided for you in the editor below. Write the Calculator class, which implements the AdvancedArithmetic interface. 
 * The implementation for the divisorSum method must be public and take an integer parameter, n, and return 
 * the sum of all its divisors.
 */
import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        List<Integer> divisors = new LinkedList<>();
        for(int i = n; i > 0; i--){
            if(n % i == 0){
                divisors.add(i);
            }
        }
        int result = 0;
        for(Integer entry : divisors){
            result += entry;
        }
        return result;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}
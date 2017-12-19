/**
 * A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself. 
 * Given a number, n, determine and print whether it's "Prime" or "Not prime". 
 */
public class Solution {
    public static boolean isPrime(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
            prime = false;
            break;
        }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        } 
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] data = new int[n];
        for(int d : data){
            d = in.nextInt();
            if(isPrime(d)){
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}
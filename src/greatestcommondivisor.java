/**
 * По данным двум числам 1 <= a, b <= 2*10^9 найдите их наибольший общий делитель.
 */
import java.util.Scanner;

public class Main {
    public static int gcd(int a, int b){
        if (a == 0) return b;
        if (b == 0) return a;
        if (a >= b) return gcd(a%b, b);
        if(b >= a) return gcd(a, b%a);
        return 0;
    }
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(gcd(a, b));
  }
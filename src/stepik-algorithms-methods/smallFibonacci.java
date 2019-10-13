/**
 * Дано целое число 1 <= n <= 40, необходимо вычислить n-е число Фибоначчи (напомним, что F[0]=0, F[1]=1 и F[n]=F[n−1]+F[n−2] при n >= 2).
 */

import java.util.Scanner;

public class Main {
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }
}
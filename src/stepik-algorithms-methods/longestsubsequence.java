/**
 * Дано целое число 1 <= n <= 10^3 и массив A[1…n] натуральных чисел, не превосходящих 2*10^9. 
 * Выведите максимальное 1 <= k <= n, для которого найдётся подпоследовательность 
 * 1 <= i[1] < i[2] < … < i[k] <= n длины k, в которой каждый элемент делится на предыдущий 
 * (формально: для  всех 1 <= j < k, A[ij]|A[ij+1]).
 * 
 * Sample Input:
 * 4
 * 3 6 7 12
 * Sample Output:
 * 3
 */
import java.util.Scanner;

public class MaxSubsequence {
	private static int getMax(int[] arr) {
		int max = 0;
		for(int a : arr) {
			if(a > max) {
				max = a;
			}
		}
		return max;
	}
	
	private static int maxSeq(int[] data) {
		int[] result = new int[data.length];
		for(int i = 0; i < data.length; i++) {
			result[i] = 1;
			for(int j = 0; j <= i - 1; j++) {
				if(data[i] % data[j] == 0 && result[j] + 1 > result[i]) {
					result[i] = result[j] + 1;
				}
			}
		}
		return getMax(result);
	}
	
	public static void run() {
		Scanner sc = new Scanner(System.in);
		int numbersCount = sc.nextInt();
		
		int[] data = new int[numbersCount];		
		for(int i = 0; i < numbersCount; i++) {
			data[i] = sc.nextInt();
		}
		
		System.out.println(maxSeq(data));
	}
	
	public static void main(String[] args) throws Exception { 
		new MaxSubsequence().run();		
	}
}
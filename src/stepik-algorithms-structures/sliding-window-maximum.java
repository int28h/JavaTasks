/*
Найти максимум в каждом окне размера m данного массива чисел A[1..n].
Наивный способ решить данную задачу — честно просканировать каждое окно и найти в нем максимум. Время работы такого 
алгоритма — O(nm). Ваша задача — реализовать алгоритм со временем работы O(n).

Формат ввода. 
Первая строка входа содержит число n, вторая — массив A[1..n], третья — число m.

Формат вывода. 
n - m + 1 максимумов, разделенных пробелами.

Sample Input 1:
3
2 1 5
1
Sample Output 1:
2 1 5

Sample Input 2:
8
2 7 3 1 5 2 6 2
4
Sample Output 2:
7 7 5 6 6
*/
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SlidingWindowMax {		
	public static void main(final String[] args) throws Exception {
		Scanner in = new Scanner(System.in);		
		
		int arrSize = in.nextInt();
		int[] array = new int[arrSize];
		for(int i = 0; i < arrSize; i++) {
			array[i] = in.nextInt();
		}
		int window = in.nextInt();
		in.close();
		
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i  = 0; i < arrSize; ++i) {
			if(i >= window) {
				int x = deque.peekFirst();
				System.out.println(x);
				if(x == array[i - window]) {
					deque.pollFirst();
				}
			}
			
			while(!deque.isEmpty() && deque.peekLast() < array[i]) {
				deque.pollLast();
			}
			deque.addLast(array[i]);			
		}
		
		if(!deque.isEmpty() && arrSize >= window) {
			System.out.println(deque.peekFirst());
		}
	}
}

/*
Построение кучи — ключевой шаг алгоритма сортировки кучей. Данный алгоритм имеет время работы O(n log n) в худшем случае 
в отличие от алгоритма быстрой сортировки, который гарантирует такую оценку только в среднем случае. Алгоритм быстрой 
сортировки чаще используют на практике, поскольку в большинстве случаев он работает быстрее, но алгоритм сортировки кучей 
используется для внешней сортировки данных, когда необходимо отсортировать данные огромного размера, не помещающиеся 
в память компьютера.
Чтобы превратить данный массив в кучу, необходимо произвести несколько обменов его элементов. Обменом мы называем базовую
операцию, которая меняет местами элементы A[i] и A[j]. Ваша цель в данной задаче — преобразовать заданный массив 
в кучу за линейное количество обменов.

Формат ввода. 
Первая строка содержит число n. Следующая строка задает массив чисел A[0], ..., A[n - 1].

Формат вывода. 
Первая строка выхода должна содержать число обменов m, которое должно удовлетворять неравенству 0 <= m <= 4n. 
Каждая из последующих m строк должна задавать обмен двух элементов массива А. Каждый обмен задается парой различных индексов
0 <= i != j <= n-1. После применения всех обменов в указанном порядке массив должен превратиться в мин-кучу, то есть для всех
0 <= i <= n-1 должны выполняться следующие два условия:
	если 2i + 1 <= n-1, то A[i] < A[2i + 1],
	если 2i + 2 <= n-1, то A[i] < A[2i + 2].
	

	
Sample Input 1:
6
0 1 2 3 4 5
Sample Output 1:
0

Sample Input 2:
6
7 6 5 4 3 2
Sample Output 2:
4
2 5
1 4
0 2
2 5
*/
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MinHeapBuilding {
	private static int arrSize;
	private static int[] arr;	
	private static List<String> log = new LinkedList<>();
	
	private static void siftDown(int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int min = i;
		
		if (left < arrSize) {
            min = left;
		}

        if (right < arrSize && arr[right] < arr[left]) {
        	min = right;
        }
        
        if (i != min && arr[i] > arr[min]) {
        	int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;            
            
            log.add(new String(i + " " + min));
            siftDown(min);
        }
	}
	
	public static void main(final String[] args) throws Exception {
		Scanner in = new Scanner(System.in);		
		
		arrSize = in.nextInt();
		arr = new int[arrSize];
		for(int i = 0; i < arrSize; i++) {
			arr[i] = in.nextInt();
		}		
		in.close();		
		
		for(int i = arrSize; i >= 0; i--) {
			siftDown(i);
		}
		
		System.out.println(log.size());
		for(String s : log) {
			System.out.println(s);
		}
	}
}
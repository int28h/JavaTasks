/**
 * Вам задан односвязный список в виде массива длины n: i-й элемент содержит ссылку на следующий элемент списка. 
 * Формально, в этой задаче список всегда начинается со значения 1, 
 * i-й элемент массива содержит значение равное следующему элементу списка после значения i. 
 * Если i-й элемент массива равен 0, то список заканчивается значением i.
 * 
 * Например, если n=5, а массив имеет вид a=[5, 4, 0, 3, 2], то за значением 1 следует значение 5 
 * (так как a[1]=5), затем следует значение 2 (так как a[5]=2) и так далее. 
 * Таким образом, заданный список имеет вид: 1 -> 5 -> 2 -> 4 -> 3.
 * 
 * Выведите заданный список в обратном порядке.
 * 
 * Входные данные
 * В первой строке входных данных записано целое число n (1 <= n <= 100) — длина списка.
 * Во второй строке записаны элементы массива a1, a2,..., an (0 <= ai <=n, ai != 1), 
 * где ai равно элементу, который следует в списке за элементом i или a[i]=0, если элемент i — последний элемент списка.
 * Гарантируется, что массив a корректно задает некоторый список длины n, который начинается со значения 1.
 * 
 * Выходные данные
 * Выведите элементы заданного списка в обратном порядке, то есть от последнего элементы списка к первому.
 
 * === Пример 1 ===
 * input.txt
 * 5
 * 5 4 0 3 2
 * output.txt
 * 3 4 2 5 1 
 *
 * === Пример 2 === 
 * input.txt
 * 3
 * 3 0 2
 * output.txt
 * 2 3 1 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	private static class Node{
		Node next;
		int number;
	}
	
	private static Node head = new Node();

    public static void main(String[] args) throws FileNotFoundException {    	    	
    	Scanner in = new Scanner(new File("input.txt"));
        int[] array = new int[in.nextInt()];
        for(int i = 0; i < array.length; i++) {        	
        	array[i] = in.nextInt();
        }       
        in.close();             
        
        Node first = new Node();
        first.number = 1;
        head.next = first;
        Node current = first;
        for(int i = 0; i < array.length; i++) {
        	Node x = new Node();
        	current.next = x;
        	if (array[current.number - 1] == 0) {
        		x.number = current.number - 1;
        		break;
        	}
        	x.number = array[current.number - 1];        	
        	current = x;
        }
        
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintStream out = new PrintStream(fos);
        
        //Так как автор задания не уточнил, каким  именно образом следует производить вывод перевернутого списка, 
		//ниже представлены два варианта решения.
        
        //первый способ
        StringBuilder s = new StringBuilder();
        current = first;
        for(int i = 0; i < array.length; i++) {
        	if(i == 0) {
        		s.append(current.number);
        		current = current.next;
        	} else {
        	s.append(" ").append(current.number);
        	current = current.next;
        	}
        }
        out.print(s.reverse());
        
        //второй способ
        int[] reverse = new int[array.length];
        current = head;
        for(int i = 0; i < array.length; i++) {
        	current = current.next;
        	reverse[i] = current.number;
        }
        for(int i = array.length - 1; i >= 0; i--) {
        	if (i == array.length) {
        		out.print(reverse[i]);
        	} else {
        		out.print(" " + reverse[i]);
        	}
        }
        out.close();
    }
}

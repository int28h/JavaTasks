/*
Напишите reducer, который объединяет элементы из множества A и B. 
На вход в reducer приходят пары key / value, где key - элемент множества, value - маркер множества (A или B)

Sample Input:

1	A
2	A
2	B
3	B

Sample Output:

1
2
3
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s;
		String last = "";
		
		while((s = br.readLine()) != null) {
			String[] current = s.split("\t");
			if(!current[0].equals(last)) {
				System.out.println(current[0]);
				last = current[0];
			}
        }
	}
}
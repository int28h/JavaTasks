/*
Напишите reducer, который реализует симметричную разность множеств A и B (т.е. оставляет только те элементы, которые есть только в одном из множеств). 
На вход в reducer приходят пары key / value, где key - элемент множества, value - маркер множества (A или B)

Sample Input:

1	A
2	A
2	B
3	B

Sample Output:

1
3
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s, last = "";		
		
		List<String> result = new LinkedList<>();
		
		while((s = br.readLine()) != null) {
			String[] current = s.split("\t");
			
			if(!current[0].equals(last)) {
				result.add(current[0]);
				last = current[0];
			} else {
				result.remove(last);
			}
        }
		for(String entry: result) {
			System.out.println(entry);
		}
	}
}
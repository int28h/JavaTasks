/*
Напишите reducer, который делает вычитание элементов множества B из множества A. На вход в reducer приходят пары key / value, где key - элемент множества, value - маркер множества (A или B)

Sample Input:

1	A
2	A
2	B
3	B

Sample Output:

1
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s;
		
		List<String> result = new LinkedList<>();
		
		while((s = br.readLine()) != null) {
			String[] current = s.split("\t");
			
			if(current[1].equals("A")) {
				result.add(current[0]);
			} else {
				if(result.contains(current[0])) {
					result.remove(current[0]);
				}
			}
        }
		for(String entry: result) {
			System.out.println(entry);
		}
	}
}
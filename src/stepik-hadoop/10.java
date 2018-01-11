/*
Реализуйте reducer из задачи Distinct Values v2.

Reducer принимает на вход строки, каждая из которых состоит из разделенных табуляцией значения и названия группы.

Sample Input:

1	a
1	b
1	b
2	a
2	d
2	e
3	a
3	b

Sample Output:

a	3
d	1
b	2
e	1
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<String> distinct = new HashSet<>();
		String s;
		
		while((s = br.readLine()) != null) {
			distinct.add(s);
		}
		
		Map<String, Integer> data = new HashMap<>();
		for(Iterator<String> it = distinct.iterator(); it.hasNext(); ) {
			String entry = it.next();
			String[] current = entry.split("\t");
			if(data.containsKey(current[1])) {
				data.replace(current[1], data.get(current[1]) + 1);
			} else {
				data.put(current[1], 1);
			}
		}
		
		for(Entry<String, Integer> entry : data.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
}

/*
Реализуйте mapper для задачи Cross-Correlation, который для каждого объекта из кортежа создает stripe.

Mapper принимает на вход кортежи - строки, состоящие из объектов, разделенных пробелом.

Mapper пишет данные в виде key / value, где key - объект, value - соответствующий stripe (пример: a:1,b:2,c:3)

Sample Input:

a b
a b a c

Sample Output:

a	b:1
b	a:1
a	b:1,c:1
b	a:2,c:1
a	b:1,c:1
c	b:1,a:2
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s;
		
		while((s = br.readLine()) != null) {
			String[] current = s.split(" ");
			for(String entry : current) {
				Map<String, Integer> data = new HashMap<>();
				for(String pair : current) {
					if(!pair.equals(entry)) {
						if(!data.containsKey(pair)) {
							data.put(pair, 1);	
						} else {
							data.replace(pair, data.get(pair) + 1);
						}
					}
				}
				
				StringBuilder result = new StringBuilder();
				for(Entry<String, Integer> d : data.entrySet()) {
					result.append(d.getKey() + ":" + d.getValue() + ",");
				}				
				System.out.println(entry + "\t" + result.substring(0, result.length() - 1));
			}
		}
	}
}
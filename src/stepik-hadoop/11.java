/*
Реализуйте mapper для задачи Cross-Correlation, который для каждого кортежа создает все пары элементов, входящих в него.

Mapper принимает на вход кортежи - строки, состоящие из объектов, разделенных пробелом.

Mapper пишет данные в виде key / value, где key - пара объектов, разделенных запятой, value - единица.

Sample Input:

a b
a b a c

Sample Output:

a,b	1
b,a	1
a,b	1
a,c	1
b,a	1
b,a	1
b,c	1
a,b	1
a,c	1
c,a	1
c,b	1
c,a	1
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s;
		
		while((s = br.readLine()) != null) {
			String[] current = s.split(" ");
			for(String entry : current) {
				for(String pair : current) {
					if(entry.equals(pair)) {
						continue;
					}
					System.out.println(entry + "," + pair + "\t" + 1);
				}
			}
		}
	}
}
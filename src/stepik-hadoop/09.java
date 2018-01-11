/*
Реализуйте mapper из фазы 2 задачи Distinct Values v1.

Mapper принимает на вход строку, содержащую значение и группу, разделенные запятой.

Sample Input:

1,a
2,a
3,a
1,b
3,b
2,d
2,e

Sample Output:

a	1
a	1
a	1
b	1
b	1
d	1
e	1
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {    
    public static void main(final String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        
    	String s;
    	
    	while((s = br.readLine()) != null) {
    		String[] entry = s.split(",");
    		System.out.println(entry[1] + "\t" + 1);
    	}
    }
}
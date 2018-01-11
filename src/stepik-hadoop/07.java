/*
Реализуйте mapper из фазы 1 задачи Distinct Values v1. 

Mapper принимает на вход строку, содержащую значение и через табуляцию список групп, разделенных запятой.

Sample Input:

1	a,b
2	a,d,e
1	b
3	a,b

Sample Output:

1,a	1
1,b	1
2,a	1
2,d	1
2,e	1
1,b	1
3,a	1
3,b	1
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {    
    public static void main(final String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            
    	String s;
    	
        while((s = br.readLine()) != null) {
        	String[] current = s.split("\t");
        	String[] groups = current[1].split(",");
        	for(String str : groups) {
        		System.out.println(current[0] + "," + str + "\t" + 1);
        	}
    	}        
    }
}
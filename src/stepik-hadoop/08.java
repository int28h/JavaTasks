/*
Реализуйте reducer из фазы 1 задачи Distinct Values v1.

Reducer принимает на вход данные, созданные mapper из предыдущей шага.

Sample Input:

1,a	1
1,b	1
1,b	1
2,a	1
2,d	1
2,e	1
3,a	1
3,b	1

Sample Output:

1,a
1,b
2,a
2,d
2,e
3,a
3,b
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {    
    public static void main(final String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        
    	String s, currentWord = "";
    	
    	while((s = br.readLine()) != null) {
    		String[] entry = s.split("\t");
    		 if(!entry[0].equals(currentWord)) {
    			 System.out.println(entry[0]);
    			 currentWord = entry[0];
    		 } else {
    			 continue;
    		 }
    	}
    }
}
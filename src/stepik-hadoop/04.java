/*
Напишите программу, которая реализует In-mapper combining v.2 для задачи WordCount в Hadoop Streaming.

Sample Input:

aut Caesar aut nihil
aut aut
de mortuis aut bene aut nihil

Sample Output:

aut	6
mortuis	1
bene	1
Caesar	1
de	1
nihil	2
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
    	Map<String, Integer> data = new HashMap<>();
    	
    	while((s = br.readLine()) != null) {    		
    		for(String entry : s.split(" ")) {
    			if(data.containsKey(entry)) {
    				data.replace(entry, data.get(entry), (data.get(entry) + 1));
    			} else {
    				data.put(entry, 1);
    			}
    		}
    	}
    	
    	for (Entry<String, Integer> entry : data.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
    }
}
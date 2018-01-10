/*
Напишите программу, которая реализует In-mapper combining v.1 для задачи WordCount в Hadoop Streaming.

Sample Input:

aut Caesar aut nihil
aut aut
de mortuis aut bene aut nihil

Sample Output:

nihil	1
aut	2
Caesar	1
aut	2
nihil	1
aut	2
de	1
bene	1
mortuis	1
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
    		Map<String, Integer> data = new HashMap<>();
    		
    		String[] current = s.split(" ");
    		for(String entry : current) {
    			if(data.containsKey(entry)) {
    				data.replace(entry, data.get(entry), (data.get(entry) + 1));
    			} else {
    				data.put(entry, 1);
    			}
    		}
    		
    		for (Entry<String, Integer> entry : data.entrySet()) {
    			System.out.println(entry.getKey() + "\t" + entry.getValue());
    		}
    	}
    }
}
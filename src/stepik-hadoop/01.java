/*
Напишите программу, которая реализует mapper для задачи WordCount в Hadoop Streaming.

Sample Input:

Vivere est cogitare
Vivere militate est
Scientia potentia est

Sample Output:

Vivere	1
est	1
cogitare	1
Vivere	1
militate	1
est	1
Scientia	1
potentia	1
est	1
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {    
    public static void main(final String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s;
    	while((s = br.readLine()) != null) {
    		for(String entry : s.split(" ")) {
    			System.out.println(entry + "\t1");
    		}
    	}
    }
}

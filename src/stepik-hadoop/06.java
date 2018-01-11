/*
Реализуйте Combiner в задаче подсчета среднего времени, проведенного пользователем на странице.

Mapper пишет данные в виде key / value, где key - адрес страницы, value - пара чисел, разделенных ";". 
Первое - число секунд, проведенных пользователем на данной странице, второе равно 1.

Sample Input:

www.facebook.com	100;1
www.google.com	10;1
www.google.com	5;1
www.google.com	15;1
stepic.org	60;1
stepic.org	100;1

Sample Output:

www.facebook.com	100;1
www.google.com	30;3
stepic.org	160;2
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {    
    public static void main(final String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        
        int sum = 0, count = 0;
        String current = br.readLine(), next = br.readLine();
    	
        while(next != null) {
    		String[] currentSplit = current.split("\t");
    		String[] nextSplit = next.split("\t");    		
    		String[] numbers = currentSplit[1].split(";");
    		
    		sum += Integer.parseInt(numbers[0]);
    		count += Integer.parseInt(numbers[1]);	
    		
    		if(!currentSplit[0].equals(nextSplit[0])) {
    			System.out.println(currentSplit[0] + "\t" + sum + ";" + count);
    			count = 0;
    			sum = 0;
    		}
    		
    		current = next;
    		next = br.readLine();
    	}
        
        String[] currentSplit = current.split("\t");
        String[] numbers = currentSplit[1].split(";");
    	System.out.println(currentSplit[0] + "\t" + 
		        (sum + Integer.parseInt(numbers[0]) + ";" + 
		    	(count + Integer.parseInt(numbers[1]))));
    }
}
/*
Реализуйте reducer в задаче подсчета среднего времени, проведенного пользователем на странице.

Mapper передает в reducer данные в виде key / value, где key - адрес страницы, value - число секунд, 
проведенных пользователем на данной странице.

Среднее время на выходе приведите к целому числу.

Sample Input:

www.facebook.com	100
www.google.com	10
www.google.com	5
www.google.com	15
www.stepic.org	60
www.stepic.org	100

Sample Output:

www.facebook.com	100
www.google.com	10
www.stepic.org	80
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {    
    public static void main(final String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int counter = 0, sum = 0;
        String current = br.readLine(), next = br.readLine();
    	
        while(next != null) {
    		String[] currentSplit = current.split("\t");
    		String[] nextSplit = next.split("\t");    		
    		counter += 1;
    		sum += Integer.parseInt(currentSplit[1]);
    		
    		if(!currentSplit[0].equals(nextSplit[0])) {
    			System.out.println(currentSplit[0] + "\t" + sum/counter);
    			counter = 0;
    			sum = 0;
    		}
    		
    		current = next;
    		next = br.readLine();
    	}
        
        String[] currentSplit = current.split("\t");
    	System.out.println(currentSplit[0] + "\t" + ((sum += Integer.parseInt(currentSplit[1]))/(counter + 1)));
    }
}
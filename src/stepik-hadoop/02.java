/*
Напишите программу, которая реализует reducer для задачи WordCount в Hadoop Streaming.

Sample Input:

cogitare	1
est	1
est	1
est	1
militate	1
potentia	1
Scientia	1
Vivere	1
Vivere	1

Sample Output:

cogitare	1
est	3
militate	1
potentia	1
Scientia	1
Vivere	2
*/

/*
https://stepik.org/lesson/17725/step/5?discussion=153686&reply=155632
Anonymous 1041478
сортировать ничего не надо, как и хранить все входящие данные чтобы потом их обрабатывать, 
надо принимать строку - обрабатывать её - и если следующая строка другая выдавать слово и счетчик на вывод, 
а если строка такая же добавлять счетчик и переходить к следующей, сокращается время обработки, 
и не переполнится память если данных будет действительно много, это ведь биг дата) 
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {    
    public static void main(final String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        	
    	int counter = 0;
    	String current = br.readLine(), next = br.readLine();
    	
    	while(next != null) {
    		String[] currentSplit = current.split("\t");
    		String[] nextSplit = next.split("\t");
    		
    		counter += 1;
    		
    		if(!currentSplit[0].equals(nextSplit[0])) {
    			System.out.println(currentSplit[0] + "\t" + counter);
    			counter = 0;
    		}
    		
    		current = next;
    		next = br.readLine();
    	} 
    	
    	String[] currentSplit = current.split("\t");
    	System.out.println(currentSplit[0] + "\t" + (counter + 1));
    }
}

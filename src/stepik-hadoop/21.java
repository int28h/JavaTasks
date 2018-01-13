/*
Реализуйте reducer первой mapreduce задачи для расчета TF-IDF с помощью Hadoop Streaming.

Ключ входных данных составной: он содержит слово и номер документа через "#".

Ключом в выходных данных является слово, а значение состоит из двух элементов, разделенных табуляцией: номер документа и tf (сколько раз данное слово встретилось в данном документе).

Sample Input:

aut#1	1
aut#1	1
aut#1	1
aut#1	1
aut#2	1
aut#2	1
bene#2	1
de#2	1
mortuis#2	1
nihil#1	1
nihil#2	1
Caesar#1	1

Sample Output:

aut	1	4
aut	2	2
bene	2	1
de	2	1
mortuis	2	1
nihil	1	1
nihil	2	1
Caesar	1	1
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s, lastWord = null, lastKey = null;
		int counter = 0;
		
		while((s = br.readLine()) != null) {
			String[] current = s.split("[#\t]");
			
			if((!current[0].equals(lastWord) && lastWord != null) || (!current[1].equals(lastKey) && lastKey != null)) {
				System.out.println(lastWord + "\t" + lastKey + "\t" + counter);
				counter = 0;
			} 
			lastWord = current[0];
			lastKey = current[1];
			counter++;			
		} 
		System.out.println(lastWord + "\t" + lastKey + "\t" + counter);	
	}
}

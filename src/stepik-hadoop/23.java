/*
Реализуйте reducer второй mapreduce задачи для расчета TF-IDF с помощью Hadoop Streaming.

Входные данные: ключ - слово, значение - тройка: номер документа, tf слова в документе и 1 (разделены ';').

Выходные данные: ключ - пара: слово, номер документа (разделены '#'), значение - пара: 
tf слова в документе, n - количество документов с данным словом (разделены табуляцией).

Sample Input:

aut	1;4;1
aut	2;2;1
bene	2;1;1
de	2;1;1
mortuis	2;1;1
nihil	1;1;1
nihil	2;1;1
Caesar	1;1;1

Sample Output:

aut#1	4	2
aut#2	2	2
bene#2	1	1
de#2	1	1
mortuis#2	1	1
nihil#1	1	2
nihil#2	1	2
Caesar#1	1	1
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s, last = null;
		List<String> result = new LinkedList<>();
		
		while((s = br.readLine()) != null) {
			String[] current = s.split("[;\t]");
			if (!current[0].equals(last) && last != null) {
				for(String entry : result) {
					System.out.println(entry + "\t" + result.size());
				}
				result.clear();
			}
			result.add(current[0] + "#" + current[1] + "\t" + current[2]);
			last = current[0];
		}
		
		for(String entry : result) {
			System.out.println(entry + "\t" + result.size());
		}
	}
}
